package hse.ru.baldej.ui.fragments

import android.app.AlertDialog
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import hse.ru.baldej.R
import hse.ru.baldej.databinding.FragmentProfileBinding
import hse.ru.baldej.ui.activities.MainActivity
import java.io.ByteArrayOutputStream


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    val GALLERY_REQUEST = 123
    private lateinit var selectImageFromGalleryResult: ActivityResultLauncher<String>

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        selectImageFromGalleryResult =
            registerForActivityResult(androidx.activity.result.contract.ActivityResultContracts.GetContent()) { uri: android.net.Uri? ->
                uri?.let { binding.profileImage.setImageURI(uri) }
            }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            exit.setOnClickListener {
                showDialog("Вы действительно ходите выйти из аккаунта?", 0)
            }
            profileImage.apply {
                setOnClickListener {
                    showDialog("Загрузить фотографию с устройства?", 1)

                }
            }
            (activity as MainActivity).apply {
                val login = mySharedPreferences!!.getString(EMAIL_STR, "Почта")
                email.text = login
                nameLastName.text = login!!.substringBefore("@")
                if (mySharedPreferences!!.contains(BITMAP_STR)) {
                    val b64: String = mySharedPreferences!!.getString(BITMAP_STR, "")!!
                    if (b64.isNotEmpty() && b64.isNotBlank()) {
                        val bytes = Base64.decode(b64, Base64.DEFAULT)
                        val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                        profileImage.setImageBitmap(bitmap)
                    }
                }
            }
        }
    }

    private fun selectImageFromGallery() = selectImageFromGalleryResult.launch("image/*")
    private fun exit() {
        (activity as MainActivity).apply {
            val editor: SharedPreferences.Editor = mySharedPreferences!!.edit()
            editor.remove(REGISTRATION_CODE_PREFERENCES)
            editor.remove(EMAIL_STR)
            editor.apply()
            if (mySharedPreferences!!.contains(REGISTRATION_CODE_PREFERENCES)) {
                Toast.makeText(context, "Не удалил", Toast.LENGTH_LONG).show()
            }
            navigationController.navigate(R.id.loginFragment)
        }
    }

    private fun saveImageToStorage() {

        binding.profileImage.apply {
            val bitmap = drawable.toBitmap()
//            val bitmap = Bitmap.createBitmap(
//                width,
//                height,
//                Bitmap.Config.ARGB_8888
//            )
            //val bitmap = ( drawable as BitmapDrawable).bitmap
            val baos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val bytes: ByteArray = baos.toByteArray()
            val b64: String = Base64.encodeToString(bytes, Base64.DEFAULT)
            (activity as MainActivity).apply {
                val editor: SharedPreferences.Editor = mySharedPreferences!!.edit()
                editor.putString(
                    BITMAP_STR,
                    b64
                )
                editor.apply()
            }

        }
    }

    private fun showDialog(message: String, code: Int) {
        activity.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(message)
                .setCancelable(true)
                .setPositiveButton("ДА") { dialog, id ->
                    when (code) {
                        0 -> exit()
                        1 -> {
                            selectImageFromGallery()
                            saveImageToStorage()
                        }
                    }
                }
                .setNegativeButton("Нет") { dialog, id ->
                    dialog.cancel()
                }
            builder.create().show()
        }
    }

}