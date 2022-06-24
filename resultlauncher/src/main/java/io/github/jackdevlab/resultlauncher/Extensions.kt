package io.github.jackdevlab.resultlauncher

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import io.github.jackdevlab.resultlauncher.ActivityResult
import io.github.jackdevlab.resultlauncher.PermissionsResult
import io.github.jackdevlab.resultlauncher.ResultLauncher

fun FragmentActivity.startActivityForResultCallback(intent: Intent, callback: (result: ActivityResult) -> Unit) {
    ResultLauncher.startActivityForResultCallback(this, intent, callback)
}

suspend fun FragmentActivity.startActivityForResultSuspend(intent: Intent): ActivityResult {
    return ResultLauncher.startActivityForResultSuspend(this, intent)
}

fun FragmentActivity.requestPermissionsCallback(permissions: Array<String>, callback: (result: PermissionsResult) -> Unit) {
    ResultLauncher.requestPermissionsCallback(this, permissions, callback)
}

suspend fun FragmentActivity.requestPermissionsSuspend(permissions: Array<String>): PermissionsResult {
    return ResultLauncher.requestPermissionsSuspend(this, permissions)
}