package com.aiinty.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aiinty.domain.model.Course
import com.aiinty.domain.model.CourseSortType
import com.aiinty.domain.usecase.GetCoursesUseCase
import com.aiinty.domain.usecase.GetFavoriteCoursesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoriteCoursesUseCase: GetFavoriteCoursesUseCase
) : ViewModel() {
    private val _courses = MutableStateFlow<List<Course>>(emptyList())
    val courses: StateFlow<List<Course>> get() = _courses

    init {
        loadCourses()
    }

    private fun loadCourses() {
        viewModelScope.launch {
            _courses.value = getFavoriteCoursesUseCase()
        }
    }
}