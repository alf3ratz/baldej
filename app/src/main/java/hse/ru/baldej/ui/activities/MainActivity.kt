package hse.ru.baldej.ui.activities

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import hse.ru.baldej.R
import hse.ru.baldej.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var navigationController: NavController
    var mySharedPreferences: SharedPreferences? = null
    val REGISTRATION_CODE_PREFERENCES = "registrationCode"
    lateinit var menu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //FirebaseApp.initializeApp(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        menu = findViewById(R.id.bottom_menu)
        binding.bottomMenu.apply {
            menu
        }
        navigationController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(binding.bottomMenu, navigationController)
//        val auth = Firebase.auth
//        if (auth.currentUser != null) {
//
//        } else {
        val builder = NavOptions.Builder()
        val navOptions =
            builder
                .build()
        mySharedPreferences =
            getPreferences(Context.MODE_PRIVATE)//getSharedPreferences(REGISTRATION_CODE_PREFERENCES, Context.MODE_PRIVATE)
        if (mySharedPreferences!!.contains(REGISTRATION_CODE_PREFERENCES)) {
            navigationController.navigate(R.id.mainFragment)
        } else {
            navigationController.navigate(R.id.loginFragment);
        }
        //navigationController.navigate(R.id.loginFragment);
//        navigationController.navigate(R.id.fragment_login, null, navOptions)
        //navigationController.navigate(R.id.fragment_login)
        //}

//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.activity_main, MainFragment())
//                .commit()
//        }
        //setContentView(R.layout.activity_main)
        //supportFragmentManager.fragmentFactory = fragmentFactory
    }
}