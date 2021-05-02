package com.example.imc

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataResult(
        val resultado: Double,

): Parcelable
