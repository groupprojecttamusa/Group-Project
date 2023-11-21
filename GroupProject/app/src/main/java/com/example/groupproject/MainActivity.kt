package com.example.groupproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager

        val bubbleGame: Fragment = Bubble_Pop_Game()
        val coinGame: Fragment = CoinFliperFragment()
        val rpsGame: Fragment = Rock_Paper_Scissors_LevelUp()
        val spinnerGame: Fragment = SpinnerGame()
        val statsFragment: Fragment = Stats()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener {item -> lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.action_buttonpopper -> fragment = bubbleGame
                R.id.action_coinflip -> fragment = coinGame
                R.id.action_rockpaper -> fragment = rpsGame
                R.id.action_spinner -> fragment = spinnerGame
                R.id.action_stats -> fragment = statsFragment
            }
            fragmentManager.beginTransaction().replace(R.id.rlContainer, fragment).commit()
            true
        }

        bottomNavigationView.selectedItemId = R.id.action_stats
    }
}