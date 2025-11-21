package com.aiinty.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Query("SELECT * FROM courses_table")
    fun getAllCourses(): Flow<List<CourseEntity>>

    @Query("SELECT * FROM courses_table WHERE hasLike = 1")
    fun getFavoriteCourses(): Flow<List<CourseEntity>>

    @Upsert
    suspend fun upsertAll(courses: List<CourseEntity>)

    @Query("UPDATE courses_table SET hasLike = :isFavorite WHERE id = :courseId")
    suspend fun setLikeStatus(courseId: Int, isFavorite: Boolean)

    @Query("SELECT COUNT(*) FROM courses_table")
    suspend fun getCoursesCount(): Int
}