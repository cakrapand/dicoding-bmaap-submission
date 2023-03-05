package com.example.programming_language

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Language(
    val name: String,
    val desc: String,
    val desain: String,
    val tahun: String,
    val photo: Int
): Parcelable
