package com.aiinty.data.network

import com.aiinty.data.model.CoursesResponseDto
import retrofit2.http.GET

interface CourseApi {
    @GET
    suspend fun getCourses(): CoursesResponseDto
    @GET
    suspend fun getFavoriteCourses(): CoursesResponseDto
}