package com.soft.shala.RoomDataBase.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schedule")
data class ScheduleTbl(
    @PrimaryKey(autoGenerate = true) val  id:Int=0,
    val scheduleId:String,
    val classCode:String,
    val subjectCode:String,
    val teacherCode:String,
    val time:String,
    val day:String,
    val updateDate:String
) {
}