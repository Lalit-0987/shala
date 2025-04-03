package com.soft.shala.RoomDataBase.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "classRoom")
data class ClassRoom(

    @PrimaryKey(autoGenerate = true) val  id:Int=0,
    @ColumnInfo(name = "classCode") val classCode:String,
    @ColumnInfo(name = "stream") val stream:String,
    @ColumnInfo(name = "course") val course_type:String,
    @ColumnInfo(name = "course") val course:String,
    @ColumnInfo(name = "standard") val standard:String,
    @ColumnInfo(name = "division") val division:String,
    @ColumnInfo(name = "specialization") val specialization:String,
    @ColumnInfo(name = "no_of_student") val no_of_student:Int,
    @ColumnInfo(name = "accedemic_year") val accedemic_year:String,
    @ColumnInfo(name = "update_date")val update_date:String

)
