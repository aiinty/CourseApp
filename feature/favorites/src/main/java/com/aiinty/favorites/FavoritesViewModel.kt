package com.aiinty.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aiinty.domain.model.Course
import com.aiinty.domain.usecase.GetFavoriteCoursesUseCase
import com.aiinty.domain.usecase.ToggleLikeStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoriteCoursesUseCase: GetFavoriteCoursesUseCase,
    private val toggleLikeStatusUseCase: ToggleLikeStatusUseCase,
) : ViewModel() {
    val courses: StateFlow<List<Course>> = getFavoriteCoursesUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    fun onLikeClicked(course: Course) {
        viewModelScope.launch {
            toggleLikeStatusUseCase(course.id, course.hasLike)
        }
    }
}