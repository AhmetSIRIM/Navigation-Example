package com.whale.navigationexample

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backStackEntryCountToast(this, supportFragmentManager)

        /** Add */

        findViewById<Button>(R.id.button_add).setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FirstFragment>(R.id.fragment_container_view)
            }
            backStackEntryCountToast(this, supportFragmentManager)
        }

        findViewById<Button>(R.id.button_add_with_back_stack).setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FirstFragment>(R.id.fragment_container_view)
                addToBackStack(null)
            }
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<SecondFragment>(R.id.fragment_container_view)
                addToBackStack(null)
            }
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ThirdFragment>(R.id.fragment_container_view)
                addToBackStack(null)
            }
            backStackEntryCountToast(this, supportFragmentManager)
        }

        /** Replace */

        findViewById<Button>(R.id.button_replace).setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<SecondFragment>(R.id.fragment_container_view)
            }
            backStackEntryCountToast(this, supportFragmentManager)
        }

        findViewById<Button>(R.id.button_replace_with_back_stack).setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<FirstFragment>(R.id.fragment_container_view)
                addToBackStack(null)
                replace<SecondFragment>(R.id.fragment_container_view)
                addToBackStack(null)
            }
            backStackEntryCountToast(this, supportFragmentManager)
        }

        /** Remove */

        findViewById<Button>(R.id.button_remove_first_fragment).setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                val firstFragment =
                    supportFragmentManager.findFragmentById(R.id.fragment_container_view) as FirstFragment
                remove(firstFragment)
            }
            backStackEntryCountToast(this, supportFragmentManager)
        }

        findViewById<Button>(R.id.button_remove_second_fragment).setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                val secondFragment =
                    supportFragmentManager.findFragmentById(R.id.fragment_container_view) as SecondFragment
                remove(secondFragment)
            }
            backStackEntryCountToast(this, supportFragmentManager)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        backStackEntryCountToast(this, supportFragmentManager)
    }

}

fun backStackEntryCountToast(context: Context, fragmentManager: FragmentManager) {
    Toast.makeText(context, "${fragmentManager.backStackEntryCount}", Toast.LENGTH_SHORT).show()
}