package com.bcaf.ujiankotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.bcaf.ujiankotlin.AboutActivity
import com.bcaf.ujiankotlin.model.Article


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setTitle("10 Model Indonesia")

        val orientation = resources.configuration.orientation

        if(orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.sideList, ListArtisFragment.newInstance("",""))
                .commit()

            supportFragmentManager.beginTransaction()
                .replace(R.id.sideDetail, ListDetailFragment.newInstance(Article(R.drawable.chelsea,"Chelsea Islan","",""),""))
                .commit()
        }else{
            supportFragmentManager.beginTransaction()
                .replace(R.id.frmFragment, ListArtisFragment.newInstance("",""))
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, 1, 0, "About").apply {
            setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
            setOnMenuItemClickListener {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
                true
            }
        }
        return super.onCreateOptionsMenu(menu)
    }
}
