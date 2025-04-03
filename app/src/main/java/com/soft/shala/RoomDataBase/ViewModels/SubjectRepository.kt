package com.soft.shala.RoomDataBase.ViewModels

import androidx.lifecycle.LiveData
import com.soft.shala.RoomDataBase.Dao.SubjectDao
import com.soft.shala.RoomDataBase.Entity.SubjectTbl

class SubjectRepository (private val subjectDao: SubjectDao) {

    suspend fun saveSubject(subject: SubjectTbl){
        subjectDao.saveSubject(subject)
    }

    suspend fun getSubjectCode(subjectName:String,classCode:String): LiveData<List<SubjectTbl>>{
        return subjectDao.getSubjectCode(subjectName,classCode)
    }

    suspend fun deleteSubject(){
        return subjectDao.deleteSubject()
    }


}