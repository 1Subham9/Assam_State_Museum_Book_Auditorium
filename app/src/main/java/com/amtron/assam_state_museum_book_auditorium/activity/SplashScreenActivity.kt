package com.amtron.assam_state_museum_book_auditorium.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.amtron.assam_state_museum_book_auditorium.R
import com.amtron.assam_state_museum_book_auditorium.databinding.ActivitySplashScreenBinding
import com.amtron.assam_state_museum_book_auditorium.helper.ConnectionLiveData

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val networkConnection = ConnectionLiveData(application)

        networkConnection.observe(this, Observer {
            if (it) {

                binding.splashLayout.visibility = View.VISIBLE
                binding.noInternet.visibility = View.GONE

                val intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()


            } else {
                binding.splashLayout.visibility = View.GONE
                binding.noInternet.visibility = View.VISIBLE
            }
        })

    }
}