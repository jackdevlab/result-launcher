# ResultLauncher
easy way to start activity for result or request permissions


## Quick Start

#### start activity for result

```kotlin
startActivityForResultCallback(intent) {

     //it.resultCode
     //it.data

}

//with kotlin coroutines
scope.launch {

     val result = startActivityForResultSuspend(intent)
     //result.resultCode
     //result.data

}
```



#### request permissions

```kotlin

requestPermissionsCallback(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)) {

    //it.allPermissionsGranted()
    //it.grantState

}

//with kotlin coroutines
scope.launch {

     val result = requestPermissionsSuspend(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE))
    //result.allPermissionsGranted()
    //result.grantState

}
```
