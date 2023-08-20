package com.apidemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.apidemo.databinding.LayoutItemBinding
import com.apidemo.model.ModelDataItem

class AdapterList : RecyclerView.Adapter<AdapterList.viewModel>() {

    private var list = mutableListOf<ModelDataItem>()

    fun addData(list : List<ModelDataItem>)
    {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewModel {
        val binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewModel(binding)
    }

    override fun onBindViewHolder(holder: viewModel, position: Int) {

        val data = list[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    inner class viewModel(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(data: ModelDataItem)
        {
            binding.item = data
        }
    }
}