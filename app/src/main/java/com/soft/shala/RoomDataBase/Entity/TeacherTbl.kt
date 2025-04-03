package com.soft.shala.RoomDataBase.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teacher")
data class TeacherTbl(

    @PrimaryKey(autoGenerate = true) val  id:Int=0,
    val teacherId:String,
    val title:String,
    val teacherName:String,
    val emailId:String,
    val regNo:String,
    val password:String,
    val subjectCode:String,
    val joinDate:String,
    val updateDate:String
    ){}
