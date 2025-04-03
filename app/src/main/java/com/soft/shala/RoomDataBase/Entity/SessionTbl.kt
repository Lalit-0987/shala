package com.soft.shala.RoomDataBase.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "session")
data class SessionTbl(
    @PrimaryKey(autoGenerate = true) val  id:Int=0,
    val sessionId:String,
    val sessionTime:String,
    val sessionDay:String,
    val time:String,
    val updateTime:String
)
