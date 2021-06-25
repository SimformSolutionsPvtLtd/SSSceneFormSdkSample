package com.scenesdksample.model

import android.net.Uri

/*
* This is a bean class in which we can pass resource
* image which want to show and uri
* for same image which
* is used to render over scene
* */
data class PlaceObjectBean(
    var resourceId: Int, var uri: Uri
)
