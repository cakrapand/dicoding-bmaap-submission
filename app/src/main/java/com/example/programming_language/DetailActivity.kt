package com.example.programming_language

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.programming_language.databinding.ActivityDetailBinding
import com.example.programming_language.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object{
        const val EXTRA_LANGUAGE = "extra_language"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val language = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Language>(EXTRA_LANGUAGE)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Language>(EXTRA_LANGUAGE)
        }

        if(language != null){
            binding.tvDetailName.text = language.name
            binding.tvDetailDesc.text = language.desc
            binding.imgDetail.setImageResource(language.photo)
        }

        binding.actionShare.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT, "${language?.name}: ${language?.desc}")
            startActivity(intent)
        }
    }
}