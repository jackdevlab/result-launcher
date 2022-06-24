package io.github.jackdevlab.resultlauncher.sample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.jackdevlab.resultlauncher.sample.databinding.ActivityMainBinding
import io.github.jackdevlab.resultlauncher.sample.databinding.ActivityResultTestBinding

class ResultTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSetResult.setOnClickListener {
            val data = Intent()
            data.putExtra("result", binding.etResult.text.toString())
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}