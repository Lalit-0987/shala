package com.soft.shala.appInIt

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class splash_screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent= Intent(this,login::class.java);
            startActivity(intent)
            finish()
        },5000)
    }
}