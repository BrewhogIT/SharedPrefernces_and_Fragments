package com.practicum.sharedpreferncesfragments

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practicum.sharedpreferncesfragments.databinding.ActivityMainBinding

//Создай 4 фрагмента и без использования navigation component сделать переход между ними
//Для перехода изучить bundle но для назад не использовать bundle
//обезьятельно должен быть back stack

class MainActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences : SharedPreferences
    var modelList = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createModelList(modelList)

        sharedPreferences = getSharedPreferences(Constants.PREFERENCES_TEXT, Context.MODE_PRIVATE)
        val text = sharedPreferences.getString(Constants.PREFERENCES_TEXT, "place for saved text").toString()

        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,MainFragment.newInstance(text))
                .commit()
        }
    }

    override fun showSecondFragment() {
        val fragment = SecondFragment.newInstance(modelList)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container,fragment)
            .commit()
    }

    override fun goBack() {
        onBackPressedDispatcher.onBackPressed()
    }

    fun createModelList (list: ArrayList<Model>){
        val names = arrayOf("Pasha","Sasha","Yulya","Katya","Kiril")
        val ages = arrayOf(19,26,75,41,32)

        for (i in 0 .. names.size - 1){
            list.add(Model(names[i],ages[i]))
        }
    }
}