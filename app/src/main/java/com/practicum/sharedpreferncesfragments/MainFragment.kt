package com.practicum.sharedpreferncesfragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.practicum.sharedpreferncesfragments.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    lateinit var binding : FragmentMainBinding
    var sharedPreferences: SharedPreferences? = null
    var text : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        text = arguments?.getString(ARG_OPTIONS,"place for saved text")
        sharedPreferences = context?.getSharedPreferences(Constants.PREFERENCES_TEXT,Context.MODE_PRIVATE)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.savedText.text = text
        binding.button.setOnClickListener {
            val newText = binding.edit.text
            saveText(newText.toString())

            binding.savedText.text = newText
        }

        binding.nextButton.setOnClickListener {
            navigator().showSecondFragment()
        }
    }

    fun saveText (text: String){
        val editor = sharedPreferences?.edit()
        editor?.putString(Constants.PREFERENCES_TEXT,text)
        editor?.apply()
    }

    companion object{
        private val ARG_OPTIONS = "EXTRA OPTIONS"

        fun newInstance (text : String) : MainFragment {
            val args = Bundle()
            args.putString(ARG_OPTIONS,text)

            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }
}