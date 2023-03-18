package com.practicum.sharedpreferncesfragments

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practicum.sharedpreferncesfragments.databinding.ActivityMainBinding

//Создай 4 фрагмента и без использования navigation component сделать переход между ними
//Для перехода изучить bundle но для назад не использовать bundle
//обезьятельно должен быть back stack

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(Constants.PREFERENCES_TEXT, Context.MODE_PRIVATE)
        //val editor = sharedPreferences.edit()
        val text = sharedPreferences.getString(Constants.PREFERENCES_TEXT, "place for saved text").toString()

        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,MainFragment.newInstance(text))
                .commit()
        }

        /*
        binding.savedText.text = sharedPreferences.getString(Constants.PREFERENCES_TEXT, "place for saved text")
        binding.button.setOnClickListener {
            val text = binding.edit.text.toString()
            editor.putString(Constants.PREFERENCES_TEXT,text)
            editor.apply()

            binding.savedText.text = text
        }
        */
    }
}