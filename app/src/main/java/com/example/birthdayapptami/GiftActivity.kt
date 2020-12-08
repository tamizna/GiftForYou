package com.example.birthdayapptami

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.birthdayapptami.databinding.ActivityGiftBinding

class GiftActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityGiftBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name =  intent.getStringExtra("name") ?:"Anonymous"
        binding.txtName.text = String.format(resources.getString(R.string.it_s_for_you), name)
    }
}