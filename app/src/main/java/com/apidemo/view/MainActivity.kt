package com.apidemo.view

import android.graphics.drawable.GradientDrawable.Orientation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apidemo.adapter.AdapterList
import com.apidemo.databinding.ActivityMainBinding
import com.apidemo.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapterList: AdapterList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initView()

        setData()
    }

    fun initView()
    {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        adapterList = AdapterList()

        val linearLayoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        binding.rvUniversity.setHasFixedSize(true)
        binding.rvUniversity.layoutManager = linearLayoutManager
        binding.rvUniversity.adapter = adapterList

    }

    fun setData()
    {
        viewModel.universityList.observe(this, Observer {
           if(it.isNotEmpty())
           {
               adapterList.addData(it)
           }
        })

        viewModel.progressVisible.observe(this, Observer {
            if(it)
            {
                binding.progress.visibility = View.VISIBLE
                binding.rvUniversity.visibility = View.GONE
            }else
            {
                binding.progress.visibility = View.GONE
                binding.rvUniversity.visibility = View.VISIBLE
            }
        })
    }
}