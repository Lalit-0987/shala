package com.soft.shala.RoomDataBase.ViewModels

import com.soft.shala.RoomDataBase.Dao.TeacherDao
import com.soft.shala.RoomDataBase.Entity.TeacherTbl

class TeacherRepository(private val teacherDao: TeacherDao) {


    suspend fun saveTeacherInfo(teacher: TeacherTbl){
        teacherDao.saveTeacherInfo(teacher)
    }

    suspend fun getTeacherAccountInfo(): List<TeacherTbl>{
        return teacherDao.getTeacherAccountInfo()
    }


    suspend fun deleteTeacherAccountInfo(){
        teacherDao.deleteTeacherAccountInfo()
    }

}