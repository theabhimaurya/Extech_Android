package com.aws.day1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aws.day1.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataAdapter: DataAdapter
    private lateinit var sharedPreferenceManager: SharedPreferenceManager

    var count = 1
    private var dataModel = mutableListOf<DataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferenceManager = SharedPreferenceManager(this)

       val name  = sharedPreferenceManager.getString("Name",null)

        binding.editTextTextPersonName.setText(name)

        binding.button.setOnClickListener {
            sharedPreferenceManager.saveString("Name",binding.editTextTextPersonName.text.toString())
            DataObject.showToast(this, "save")
        }
        sharedPreferenceManager.saveString("Name",binding.editTextTextPersonName.text.toString())


        dataModel.add(DataModel("Vipul"))

        dataAdapter = DataAdapter(this, dataModel)
        binding.recycler.adapter = dataAdapter

        val num : Int = sharedPreferenceManager.getNumber("status").toInt()

        if (count == num) {
            binding.toggleBtn.isSelected = !binding.toggleBtn.isSelected
        }else{
            !binding.toggleBtn.isSelected
        }

        binding.toggleBtn.setOnClickListener {

            sharedPreferenceManager.saveNumber("status", 1) // on Button

                binding.toggleBtn.isSelected = !binding.toggleBtn.isSelected
                DataObject.showToast(this,"hey")

            if (!binding.toggleBtn.isSelected){
                sharedPreferenceManager.saveNumber("status", 0) // off button
                DataObject.showToast(this,"hello...")
            }
        }

    }
}