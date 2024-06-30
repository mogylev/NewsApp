package com.mohylev.database.utils

import androidx.room.TypeConverter
import java.time.Instant

internal class InstantConverter {

    @TypeConverter
    fun fromInstant(instant: Instant): Long = instant.toEpochMilli()

    @TypeConverter
    fun toInstant(millis: Long): Instant = Instant.ofEpochMilli(millis)
}