package com.practicum.sharedpreferncesfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.practicum.sharedpreferncesfragments.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    private lateinit var paramArray: ArrayList<Model>
    private val adapter = FragmentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramArray = it.getParcelableArrayList(Constants.ARG_PARAM)!!

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         binding.backButton.setOnClickListener {
            navigator().goBack()
        }

        initAdapter(adapter,activity?.applicationContext)
        adapter.modelList = paramArray
    }

    fun initAdapter(newAdapter: FragmentAdapter,context: Context?){
        binding.rv.adapter = newAdapter
        binding.rv.layoutManager = LinearLayoutManager(context)
    }

    companion object {
        @JvmStatic
        fun newInstance(param : ArrayList<Model>)  =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(Constants.ARG_PARAM,param)
                }
            }
    }
}