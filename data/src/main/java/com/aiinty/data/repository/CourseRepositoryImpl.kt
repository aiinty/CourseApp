package com.aiinty.data.repository

import android.content.Context
import com.aiinty.data.local.CourseDao
import com.aiinty.data.mapper.toDomain
import com.aiinty.data.mapper.toEntity
import com.aiinty.data.model.CoursesResponseDto
import com.aiinty.data.network.CourseApi
import com.aiinty.domain.model.Course
import com.aiinty.domain.repository.CourseRepository
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val courseDao: CourseDao,
    private val courseApi: CourseApi
) : CourseRepository {
    override fun getAllCourses(): Flow<List<Course>> {
        //val response = courseApi.getCourses()

        return courseDao.getAllCourses().map { entities ->
            entities.toDomain()
        }
    }

    override fun getFavoriteCourses(): Flow<List<Course>> {
        //val response = courseApi.getFavoriteCourses()

        return courseDao.getFavoriteCourses().map { entities ->
            entities.toDomain()
        }
    }

    override suspend fun toggleLike(courseId: Int, isFavorite: Boolean) {
        courseDao.setLikeStatus(courseId, isFavorite)
    }

    override suspend fun saveInitialCourses() {
        val json = context.assets.open("courses.json").bufferedReader().use { it.readText() }
        val courses = Gson().fromJson(json, CoursesResponseDto::class.java).courses
        val entities = courses.map { it.toDomain().toEntity() }
        courseDao.upsertAll(entities)
    }

    override suspend fun isDatabaseEmpty(): Boolean {
        return courseDao.getCoursesCount() == 0
    }
}