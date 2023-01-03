package com.example.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Countries(val name: String?,
                     val flags: flags?,
                     val alpha2Code: String?,
                     val capital: String?,
                     val region: String?):Parcelable
