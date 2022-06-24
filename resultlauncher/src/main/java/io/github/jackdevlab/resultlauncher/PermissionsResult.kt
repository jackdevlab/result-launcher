package io.github.jackdevlab.resultlauncher

import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

class PermissionsResult(val grantState: Map<String, Boolean>) {


    fun allPermissionsGranted() = grantState.all { it.value }

}