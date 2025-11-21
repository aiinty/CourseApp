package com.aiinty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [CourseEntity::class],
    version = 1
)
@TypeConverters(DateConverter::class)
abstract class CourseAppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
}