package com.soft.shala.RoomDataBase.Dao

import androidx.room.Insert
import androidx.room.Query
import com.soft.shala.RoomDataBase.Entity.StudentTbl
import com.soft.shala.RoomDataBase.Entity.TeacherTbl

interface StudentDao {

    @Insert
    suspend fun saveStudent(student:StudentTbl)

    @Query("select * from student")
    suspend fun getStudentAccountInfo():StudentTbl

    @Query("delete from student")
    suspend fun deleteStudentAccount()

}