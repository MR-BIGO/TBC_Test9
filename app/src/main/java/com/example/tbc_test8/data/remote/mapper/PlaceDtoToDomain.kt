package com.example.tbc_test8.data.remote.mapper

import com.example.tbc_test8.data.remote.model.PlaceDto
import com.example.tbc_test8.domain.model.Place

fun PlaceDto.toDomain(): Place {
    return Place(
        id = id,
        cover = cover,
        price = price,
        title = title,
        location = location,
        reactionCount = reactionCount,
        rate = rate,
    )
}