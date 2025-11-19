package com.aiinty.data.mapper

import com.aiinty.data.model.CourseDto
import com.aiinty.domain.model.Course
import java.time.LocalDate

fun CourseDto.toDomain(): Course = Course(
    id = id,
    title = title,
    text = text,
    price = price,
    rate = rate,
    startDate = LocalDate.parse(startDate),
    hasLike = hasLike,
    publishDate = LocalDate.parse(publishDate),
)