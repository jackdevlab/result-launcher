package io.github.jackdevlab.resultlauncher

import android.Manifest
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

class ResultLauncherFragment : Fragment() {

    private var callback: Callback? = null

    private val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        callback?.onStartActivityCallback(ActivityResult(it.resultCode, it.data))
    }
    private val permissionsResultLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
        callback?.onRequestPermissionsCallback(PermissionsResult(it))
    }


    fun startActivityForCallback(intent: Intent) {
        activityResultLauncher.launch(intent)
    }

    fun requestPermissionsForCallback(permissions: Array<String>) {
        permissionsResultLauncher.launch(permissions)
    }

    internal fun setCallback(callback: Callback) {
        this.callback = callback
    }

    internal open class Callback {
        open fun onStartActivityCallback(result: ActivityResult) {

        }

        open fun onRequestPermissionsCallback(result: PermissionsResult) {

        }
    }


}