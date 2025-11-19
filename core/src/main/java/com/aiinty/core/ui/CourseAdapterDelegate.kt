package com.aiinty.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aiinty.core.R
import com.aiinty.core.databinding.ItemCourseBinding
import com.aiinty.domain.model.Course
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import java.time.format.DateTimeFormatter
import java.util.Locale

fun courseAdapterDelegate() =
    adapterDelegateViewBinding<Course, Course, ItemCourseBinding>(
        { layoutInflater: LayoutInflater, parent: ViewGroup ->
            ItemCourseBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        val dateFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale("ru"))
        bind {
            binding.rate.text = item.rate
            binding.publishDate.text  = item.publishDate.format(dateFormatter)
            binding.title.text = item.title
            binding.description.text = item.text
            binding.price.text = "${item.price} ₽"
            binding.bookmark.setImageResource(if (item.hasLike) R.drawable.bookmark_fill
                else R.drawable.bookmark)
        }
    }