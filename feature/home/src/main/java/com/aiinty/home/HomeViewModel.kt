package com.aiinty.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aiinty.domain.model.Course
import com.aiinty.domain.model.CourseSortType
import com.aiinty.domain.usecase.GetCoursesUseCase
import com.aiinty.domain.usecase.InitDatabaseUseCase
import com.aiinty.domain.usecase.ToggleLikeStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase,
    private val toggleLikeStatusUseCase: ToggleLikeStatusUseCase,
    private val initDatabaseUseCase: InitDatabaseUseCase
) : ViewModel() {
    private val _sortType = MutableStateFlow(CourseSortType.BY_PUBLISH_DATE_ASC)
    val sortType: StateFlow<CourseSortType> get() = _sortType

    val courses: StateFlow<List<Course>> = getCoursesUseCase()
        .combine(_sortType) { courseList, sort ->
            when (sort) {
                CourseSortType.BY_PUBLISH_DATE_ASC ->
                    courseList.sortedBy { it.publishDate }
                CourseSortType.BY_PUBLISH_DATE_DESC ->
                    courseList.sortedByDescending { it.publishDate }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    init {
        viewModelScope.launch {
            initDatabaseUseCase()
        }
    }

    fun toggleSortByPublishDate() {
        _sortType.update { currentSort ->
            if (currentSort == CourseSortType.BY_PUBLISH_DATE_DESC)
                CourseSortType.BY_PUBLISH_DATE_ASC
            else
                CourseSortType.BY_PUBLISH_DATE_DESC
        }
    }

    fun onLikeClicked(course: Course) {
        viewModelScope.launch {
            toggleLikeStatusUseCase(course.id, course.hasLike)
        }
    }
}