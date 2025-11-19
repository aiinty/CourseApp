package com.aiinty.data.repository

import android.content.Context
import com.aiinty.data.mapper.toDomain
import com.aiinty.data.model.CourseDto
import com.aiinty.data.model.CoursesResponseDto
import com.aiinty.data.network.CourseApi
import com.aiinty.domain.model.Course
import com.aiinty.domain.repository.CourseRepository
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val courseApi: CourseApi
) : CourseRepository {
    override suspend fun getCourses(): List<Course> {
        //val response = courseApi.getCourses()

        return parseCoursesFromAssets().map { it.toDomain() }
    }

    override suspend fun getFavoriteCourses(): List<Course> {
        //val response = courseApi.getFavoriteCourses()

        val favoriteCourses = parseCoursesFromAssets().filter { it.hasLike }
        return favoriteCourses.map { it.toDomain() }
    }

    private fun parseCoursesFromAssets(): List<CourseDto> {
        val json = context.assets.open("courses.json").bufferedReader().use { it.readText() }
        return Gson().fromJson(json, CoursesResponseDto::class.java).courses
    }
}