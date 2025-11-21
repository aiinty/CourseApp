package com.aiinty.data.mapper

import com.aiinty.data.local.CourseEntity
import com.aiinty.data.model.CourseDto
import com.aiinty.domain.model.Course
import java.time.LocalDate

fun Course.toEntity(): CourseEntity = CourseEntity(
    id = this.id,
    title = this.title,
    text = this.text,
    price = this.price,
    rate = this.rate,
    startDate = startDate,
    hasLike = this.hasLike,
    publishDate = startDate
)

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

fun CourseEntity.toDomain(): Course = Course(
    id = this.id,
    title = this.title,
    text = this.text,
    price = this.price,
    rate = this.rate,
    startDate = startDate,
    hasLike = this.hasLike,
    publishDate = startDate
)

fun List<CourseEntity>.toDomain(): List<Course> {
    return this.map { it.toDomain() }
}