package com.example.noteapproomhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.noteapproomhilt.databinding.ActivityMainBinding
import com.example.noteapproomhilt.db.UserEntity
import com.example.noteapproomhilt.viewmodel.MainActivtyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainActivtyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.saveButton.setOnClickListener {
            val userEntity=UserEntity(name = binding.enterDescription.text.toString())
            viewModel.insertData(userEntity)
            binding.enterDescription.setText("")

        }

        initVM()

    }
    private fun initVM(){
        viewModel=ViewModelProvider(this).get(MainActivtyViewModel::class.java)
        viewModel.getRecordsObserver().observe(this, object  : Observer<List<UserEntity>> {
            override fun onChanged(t: List<UserEntity>?) {
                binding.resultTextView.setText("")
                t?.forEach {
                    binding.resultTextView.append(it.name+"\n")

                }
            }


        })
    }
}