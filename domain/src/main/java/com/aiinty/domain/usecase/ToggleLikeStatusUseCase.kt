package com.aiinty.domain.usecase

import com.aiinty.domain.repository.CourseRepository

class ToggleLikeStatusUseCase(private val repository: CourseRepository) {
    suspend operator fun invoke(courseId: Int, isCurrentlyLiked: Boolean) {
        repository.toggleLike(courseId, !isCurrentlyLiked)
    }
}