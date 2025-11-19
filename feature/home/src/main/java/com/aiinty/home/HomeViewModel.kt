package com.aiinty.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aiinty.domain.model.Course
import com.aiinty.domain.model.CourseSortType
import com.aiinty.domain.usecase.GetCoursesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase
) : ViewModel() {
    private val _courses = MutableStateFlow<List<Course>>(emptyList())
    val courses: StateFlow<List<Course>> get() = _courses

    private val _sortType = MutableStateFlow(CourseSortType.BY_PUBLISH_DATE_ASC)
    val sortType: StateFlow<CourseSortType> get() = _sortType

    init {
        loadCourses()
    }

    private fun loadCourses() {
        viewModelScope.launch {
            _courses.value = getCoursesUseCase()
        }
    }

    fun toggleSortByPublishDate() {
        val newSort = if (_sortType.value == CourseSortType.BY_PUBLISH_DATE_DESC)
            CourseSortType.BY_PUBLISH_DATE_ASC else CourseSortType.BY_PUBLISH_DATE_DESC
        _sortType.value = newSort
        applySort()
    }

    private fun applySort() {
        _courses.value = when (_sortType.value) {
            CourseSortType.BY_PUBLISH_DATE_ASC -> _courses.value.sortedBy { it.publishDate }
            else -> _courses.value.sortedByDescending { it.publishDate }
        }
    }
}