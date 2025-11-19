package com.aiinty.core.ui

import com.aiinty.domain.model.Course
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class CourseAdapter : ListDelegationAdapter<List<Course>>(courseAdapterDelegate()) {
    init {
        items = emptyList()
    }
}