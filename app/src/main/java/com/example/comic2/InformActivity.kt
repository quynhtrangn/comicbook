package com.example.comic2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class InformActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inform)

        val comicImage: ImageView= findViewById(R.id.image)
        val comicName: TextView = findViewById(R.id.name)
        val comicDescrip: TextView = findViewById(R.id.descrip)

        comicDescrip.text= intent.getStringExtra("key_dis" )
        comicName.text= intent.getStringExtra("key_name" )
        intent.getStringExtra("key_img")?.let { comicImage.setImageResource(it.toInt()) }

//        val actionbar = supportActionBar
//
//         showing the back button in action bar
//        if (actionbar != null) {
//            actionbar.setDisplayHomeAsUpEnabled(true)
//        }

    }

//    override fun onSupportNavigateUp(): Boolean {
//        onBackPressed()
//        return true
//    }


}