package com.soft.shala.RoomDataBase.ViewModels

import com.soft.shala.RoomDataBase.Dao.StudentDao
import com.soft.shala.RoomDataBase.Entity.StudentTbl

class StudentRepository (private val studentDao:StudentDao) {

    suspend fun saveStudent(student: StudentTbl){
        studentDao.saveStudent(student)
    }

    suspend fun getStudentAccountInfo(): StudentTbl{
        return studentDao.getStudentAccountInfo()
    }

    suspend fun deleteStudentAccount(){
        studentDao.deleteStudentAccount()
    }

}