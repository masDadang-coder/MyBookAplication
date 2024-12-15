package com.dicoding.mybookaplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val name: String,
    val description: String,
    val photo: Int,
    val price: String,
    val author: String
) : Parcelable
