package com.gmail.mmazouzi.neighbors

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.estia.neighbors.fragments.fragments.ListNeighborsFragment
import com.estia.neighbors.fragments.models.NavigationListener

class MainActivity : AppCompatActivity(), NavigationListener {
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        showFragment(ListNeighborsFragment())
    }

    override fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }
    override fun updateTitle(title: Int) {
        toolbar.setTitle(title)
    }
}
