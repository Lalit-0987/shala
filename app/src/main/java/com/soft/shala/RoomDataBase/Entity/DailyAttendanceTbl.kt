package com.soft.shala.RoomDataBase.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dailyAttendance")
data class DailyAttendanceTbl(
        @PrimaryKey(autoGenerate = true) val  id:Int=0,
        var no:Int,
        var rollNo:String,
        var studentId:String,
        var classCode:String,
        var teacherCode:String,
        var subCode:String,
        var attendDate:String,
        var month:String,
        var year:Int,
        var updateTime:String
){}