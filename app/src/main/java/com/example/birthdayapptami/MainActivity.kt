package com.example.birthdayapptami

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.birthdayapptami.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtGiftForYou.animate().setDuration(2_000).alpha(1F)

        binding.edtName.addTextChangedListener {
            binding.btnSubmit.isEnabled = it.toString().trim().isNotEmpty()
        }

        binding.btnSubmit.setOnClickListener {
            if (binding.edtName.text.toString().trim().isNotEmpty()) {
                val intent = Intent(this, GiftActivity::class.java)
                intent.putExtra("name", binding.edtName.text.toString())
                startActivityForResult(intent, 100)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("name", binding.edtName.text.toString())
    }
}