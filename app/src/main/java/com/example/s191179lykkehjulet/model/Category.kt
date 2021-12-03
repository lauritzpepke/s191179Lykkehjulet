package com.example.s191179lykkehjulet.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @StringRes val StringResourceId: Int,
    @DrawableRes val imageResourceId: Int)

val sportsgrene: List<String> = listOf("Fodbold", "Golf", "Tennis")

val instrumenter: List<String> = listOf("Guitar", "Piano", "Kazoo")

val historie: List<String> = listOf("Caesar", "Alexander", "Genkhis")

val lande: List<String> = listOf("Danmark", "USA", "Frankrig")

val dyr: List<String> = listOf("Ko", "Fisk", "Kat")
