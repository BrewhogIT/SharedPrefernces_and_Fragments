package com.practicum.sharedpreferncesfragments

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practicum.sharedpreferncesfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(Constants.PREFERENCES_TEXT, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        binding.savedText.text = sharedPreferences.getString(Constants.PREFERENCES_TEXT, "place for saved text")
        binding.button.setOnClickListener {
            val text = binding.edit.text.toString()
            editor.putString(Constants.PREFERENCES_TEXT,text)
            editor.apply()

            binding.savedText.text = text
        }
    }
}