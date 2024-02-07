package com.example.tbc_test8.presentation.mapper

import com.example.tbc_test8.domain.model.Place
import com.example.tbc_test8.presentation.model.PlacePresentation

fun Place.toPresentation(): PlacePresentation {
    return PlacePresentation(
        id, cover, price, title, location, reactionCount, rate
    )
}