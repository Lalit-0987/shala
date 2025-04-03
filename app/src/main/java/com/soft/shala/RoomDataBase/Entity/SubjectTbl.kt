package com.soft.shala.RoomDataBase.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subject")
data class SubjectTbl(
    @PrimaryKey(autoGenerate = true) val  id:Int=0,
    val subjectCode:String,
    val subjectName:String,
    val teacherCode:String,
    val classCode:String,
    val noOfSession:Int,
    val accedemisYear:Int,
    val updateDate:String
) {
}