package com.aiinty.domain.usecase

import com.aiinty.domain.model.Course
import com.aiinty.domain.repository.CourseRepository

class GetCoursesUseCase(private val repository: CourseRepository) {
    suspend operator fun invoke(): List<Course> {
        return repository.getCourses()
    }
}