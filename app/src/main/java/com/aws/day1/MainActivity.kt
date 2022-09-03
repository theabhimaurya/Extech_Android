package com.aws.day1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aws.day1.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataAdapter: DataAdapter
    private var dataModel = mutableListOf<DataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataModel.add(DataModel("Vipul"))
        dataModel.add(DataModel("Abhishek"))
        dataModel.add(DataModel("Navneet"))
        dataModel.add(DataModel("Vipul"))
        dataModel.add(DataModel("Vipul"))
        dataModel.add(DataModel("Vipul"))




        dataAdapter = DataAdapter(this, dataModel)
        binding.recycler.adapter = dataAdapter

    }
}