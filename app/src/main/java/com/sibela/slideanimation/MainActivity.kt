package com.sibela.slideanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sibela.slideanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.setOnClickListener {
            binding.helloWorld.slideUpAlpha(1_000, 0)
        }
    }
}