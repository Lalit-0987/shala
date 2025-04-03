package com.soft.shala.RoomDataBase.Dao

import androidx.room.Insert
import androidx.room.Query
import com.soft.shala.RoomDataBase.Entity.TeacherTbl

interface TeacherDao {

    @Insert
    suspend fun saveTeacherInfo(teacher:TeacherTbl)

    @Query("select * from teacher")
    suspend fun getTeacherAccountInfo(): TeacherTbl

    @Query("delete from teacher")
    suspend fun deleteTeacherAccountInfo()
}