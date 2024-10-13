package com.bcaf.ujiankotlin.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article (
    val imageResourceId: Int,
    val title: String,
    val overview: String,
    val description: String
) : Parcelable;