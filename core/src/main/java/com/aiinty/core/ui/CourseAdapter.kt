package com.aiinty.core.ui

import com.aiinty.domain.model.Course
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class CourseAdapter(
    private val onLikeClicked: (Course) -> Unit
) : ListDelegationAdapter<List<Course>>(courseAdapterDelegate(onLikeClicked)) {
    init {
        items = emptyList()
    }
}