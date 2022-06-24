# ResultLauncher
result-launcher is a android library to star activity for result and request permissons easily.


## Download

ResultLauncher is available on `mavenCentral()`.

```kotlin
implementation("io.github.jackdevlab:result-launcher:1.0.1")
```

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
