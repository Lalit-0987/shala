package com.soft.shala.RoomDataBase.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class StudentTbl(
    @PrimaryKey(autoGenerate = true) var  id:Int=0,
    var no:Int,
    var studentId:String,
    var rollNo:String,
    var name:String,
    var classCode:String,
    var standard:String,
    var division:String,
    var specialization:String,
    var accedemic_year:String,
    var emailId:String,
    var regNo:String,
    var password:String,
    var admitDate:String,
    var updateDate:String
) {


}