package com.practicum.sharedpreferncesfragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practicum.sharedpreferncesfragments.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.acceptButton.setOnClickListener {
            App.editor.putBoolean(Constants.PREFERENCES_ACCEPT,true)
            App.editor.apply()

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        if (App.sharedPreferenced.getBoolean(Constants.PREFERENCES_ACCEPT,false)){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}