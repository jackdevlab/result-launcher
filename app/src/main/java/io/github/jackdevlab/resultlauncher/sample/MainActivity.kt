package io.github.jackdevlab.resultlauncher.sample

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.jackdevlab.resultlauncher.*
import io.github.jackdevlab.resultlauncher.sample.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStartActivity.setOnClickListener {
            startActivityForResultCallback(Intent(this, ResultTestActivity::class.java)) {
                if (it.resultCode == Activity.RESULT_OK) {
                    binding.tvActivityResult.setTextColor(Color.GREEN)
                } else {
                    binding.tvActivityResult.setTextColor(Color.RED)
                }
                binding.tvActivityResult.text = "ResultCode:${it.resultCode} Result:${it.data?.getStringExtra("result")}"
            }
        }
        binding.btnStartActivitySuspend.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                val result = startActivityForResultSuspend(Intent(this@MainActivity, ResultTestActivity::class.java))
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.tvActivityResult.setTextColor(Color.GREEN)
                } else {
                    binding.tvActivityResult.setTextColor(Color.RED)
                }
                binding.tvActivityResult.text = "ResultCode:${result.resultCode} Result:${result.data?.getStringExtra("result")}"
            }
        }

        binding.btnRequestPermissions.setOnClickListener {
            requestPermissionsCallback(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                if (it.allPermissionsGranted()) {
                    binding.tvPermissionsResult.setTextColor(Color.GREEN)
                    binding.tvPermissionsResult.text = "${it.grantState.entries.first().key} is granted"
                } else {
                    binding.tvPermissionsResult.setTextColor(Color.RED)
                    binding.tvPermissionsResult.text = "${it.grantState.entries.first().key} is denied"
                }
            }
        }

        binding.btnRequestPermissionsSuspend.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                val result = requestPermissionsSuspend(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE))
                if (result.allPermissionsGranted()) {
                    binding.tvPermissionsResult.setTextColor(Color.GREEN)
                    binding.tvPermissionsResult.text = "${result.grantState.entries.first().key} is granted"
                } else {
                    binding.tvPermissionsResult.setTextColor(Color.RED)
                    binding.tvPermissionsResult.text = "${result.grantState.entries.first().key} is denied"
                }
            }
        }
    }
}