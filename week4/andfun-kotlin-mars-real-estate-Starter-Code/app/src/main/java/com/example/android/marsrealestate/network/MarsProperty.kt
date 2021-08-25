/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate.network

import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.os.Parcel
import android.os.Parcelable
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.marsrealestate.R
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.security.AccessController.getContext

@Parcelize
 class MarsProperty(
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String,
    val type: String,
    val price: Double
    ) : Parcelable{
    val isRental
        get() = type == "rent"
    val displayPropertyType =
        let {
            when (type) {
                "rent" -> "For Rent"
//                    R.string.display_price_monthly_rental
                "buy" -> "For Sale"
//                    R.string.display_price
                else -> "else"
            }
        }
    val displayPropertyPrice =
        let {
            when (isRental) {
                true -> "\$${price}/month"
//                    R.string.display_price_monthly_rental
                false -> "\$${price}"
//                    R.string.display_price
                else -> "else"
            }
        }
}


