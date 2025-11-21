package com.aiinty.domain.usecase

import com.aiinty.domain.repository.CourseRepository

class InitDatabaseUseCase(private val repository: CourseRepository) {
    suspend operator fun invoke() {
        if (repository.isDatabaseEmpty()) {
            repository.saveInitialCourses()
        }
    }
}