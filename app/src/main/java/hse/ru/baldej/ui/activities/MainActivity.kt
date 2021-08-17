package hse.ru.baldej.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import hse.ru.baldej.R
import hse.ru.baldej.databinding.ActivityMainBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    public lateinit var navigationController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //FirebaseApp.initializeApp(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomMenu: BottomNavigationView = findViewById(R.id.bottom_menu)
        navigationController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomMenu, navigationController)
//        val auth = Firebase.auth
//        if (auth.currentUser != null) {
//
//        } else {
        val builder = NavOptions.Builder()
        val navOptions =
            builder
                .build()
       navigationController.navigate(R.id.loginFragment);
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