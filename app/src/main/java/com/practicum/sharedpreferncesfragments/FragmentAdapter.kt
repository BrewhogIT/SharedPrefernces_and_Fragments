package com.practicum.sharedpreferncesfragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentViewHolder
import com.practicum.sharedpreferncesfragments.databinding.FragmentSecondBinding
import com.practicum.sharedpreferncesfragments.databinding.ItemViewBinding

class FragmentAdapter:RecyclerView.Adapter<FragmentAdapter.FragmentHolder>() {
    var modelList = mutableListOf<Model>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class FragmentHolder(view: View):RecyclerView.ViewHolder(view){
        lateinit var binding: ItemViewBinding

        constructor(bind:ItemViewBinding) : this(bind.root){
            binding = bind
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentHolder {
        val viewBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context))

        return FragmentHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    override fun onBindViewHolder(holder: FragmentHolder, position: Int) {
        holder.binding.nameText.text = "Name: " + modelList[position].name
        holder.binding.ageText.text = "Age: " + modelList[position].age
    }
}