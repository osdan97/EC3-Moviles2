package com.ec3.jurado.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ec3.jurado.R
import com.ec3.jurado.databinding.ActivityMainNavigattionBinding

class MainNavigattionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainNavigattionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainNavigattionBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main_navigattion)

       /* binding.bnvApp.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.lista ->{

                    true
                }
            }

        }*/
    }

}