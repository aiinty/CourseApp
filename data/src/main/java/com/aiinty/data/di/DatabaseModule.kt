package com.aiinty.data.di

import android.content.Context
import androidx.room.Room
import com.aiinty.data.local.CourseAppDatabase
import com.aiinty.data.local.CourseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val DB_FILE_NAME = "course_app_database"

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): CourseAppDatabase {
        return Room.databaseBuilder(
            context,
            CourseAppDatabase::class.java,
            DB_FILE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCourseDao(courseAppDatabase: CourseAppDatabase): CourseDao {
        return courseAppDatabase.courseDao()
    }
}