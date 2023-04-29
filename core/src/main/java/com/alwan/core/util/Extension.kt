package com.alwan.core.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}

fun Long.toIDRString(): String {
    val localeID = Locale("in", "ID")
    val currencyFormatter = NumberFormat.getCurrencyInstance(localeID) as DecimalFormat
    currencyFormatter.applyPattern("Rp ###,###,###")
    return currencyFormatter.format(this)
}

fun Int?.orZero() = this ?: 0
fun Long?.orZero() = this ?: 0L

fun String?.orEmpty() = this ?: ""
fun String?.orImageUrlPlaceholder() =
    this ?: "https://drive.google.com/uc?id=1KfpMNrTR1trdNqjjwbxZkaDObA61RIkC"