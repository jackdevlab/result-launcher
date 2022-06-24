package io.github.jackdevlab.resultlauncher

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.suspendCoroutine

object ResultLauncher {


    fun startActivityForResultCallback(activity: FragmentActivity, intent: Intent, callback: (result: ActivityResult) -> Unit) {
        val fragment = ResultLauncherFragment().apply {
            setCallback(object : ResultLauncherFragment.Callback() {
                override fun onStartActivityCallback(result: ActivityResult) {
                    super.onStartActivityCallback(result)
                    callback.invoke(result)
                }
            })
        }
        activity.supportFragmentManager.beginTransaction()
            .add(fragment, "ResultLauncherFragment")
            .commitNowAllowingStateLoss()
        fragment.startActivityForCallback(intent)
    }

    suspend fun startActivityForResultSuspend(activity: FragmentActivity, intent: Intent): ActivityResult {
        return withContext(Dispatchers.Main) {
            suspendCoroutine { continuation ->
                val fragment = ResultLauncherFragment().apply {
                    setCallback(object : ResultLauncherFragment.Callback() {
                        override fun onStartActivityCallback(result: ActivityResult) {
                            super.onStartActivityCallback(result)
                            continuation.resumeWith(Result.success(result))
                        }
                    })
                }
                activity.supportFragmentManager.beginTransaction()
                    .add(fragment, "ResultLauncherFragment")
                    .commitNowAllowingStateLoss()
                fragment.startActivityForCallback(intent)
            }
        }
    }

    fun requestPermissionsCallback(activity: FragmentActivity, permissions: Array<String>, callback: (result: PermissionsResult) -> Unit) {
        val fragment = ResultLauncherFragment().apply {
            setCallback(object : ResultLauncherFragment.Callback() {
                override fun onRequestPermissionsCallback(result: PermissionsResult) {
                    super.onRequestPermissionsCallback(result)
                    callback.invoke(result)
                }
            })
        }
        activity.supportFragmentManager.beginTransaction()
            .add(fragment, "ResultLauncherFragment")
            .commitNowAllowingStateLoss()
        fragment.requestPermissionsForCallback(permissions)
    }

    suspend fun requestPermissionsSuspend(activity: FragmentActivity, permissions: Array<String>): PermissionsResult {
        return withContext(Dispatchers.Main) {
            suspendCoroutine { continuation ->
                val fragment = ResultLauncherFragment().apply {
                    setCallback(object : ResultLauncherFragment.Callback() {
                        override fun onRequestPermissionsCallback(result: PermissionsResult) {
                            super.onRequestPermissionsCallback(result)
                            continuation.resumeWith(Result.success(result))
                        }
                    })
                }
                activity.supportFragmentManager.beginTransaction()
                    .add(fragment, "ResultLauncherFragment")
                    .commitNowAllowingStateLoss()
                fragment.requestPermissionsForCallback(permissions)
            }
        }
    }

}