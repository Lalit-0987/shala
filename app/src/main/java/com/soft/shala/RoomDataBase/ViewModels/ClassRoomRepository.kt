package com.soft.shala.RoomDataBase.ViewModels

import androidx.lifecycle.LiveData
import com.soft.shala.RoomDataBase.Dao.ClassRoomDao
import com.soft.shala.RoomDataBase.Entity.ClassRoom

class ClassRoomRepository(private val classRoomDao:ClassRoomDao) {

    suspend fun getClassCode(stream:String,course:String,standard:String,specialization:String,division:String){
        classRoomDao.getClassCode(stream, course, standard, specialization, division)
    }

    suspend fun getStream(): LiveData<List<ClassRoom>>{
         return  classRoomDao.getStream()
    }

    suspend fun getCourse(stream:String): LiveData<List<ClassRoom>>{
                return classRoomDao.getCourse(stream)
    }

    suspend fun getSpecialization(stream:String,course:String): LiveData<List<ClassRoom>>{
                return classRoomDao.getSpecialization(stream, course)
    }


    suspend fun getStandard(stream:String,course:String,specialization:String): LiveData<List<ClassRoom>>{
                return classRoomDao.getStandard(stream, course, specialization)
    }

    suspend fun getDivision(stream:String,course:String,standard:String,specialization:String): LiveData<List<ClassRoom>>{
                return classRoomDao.getDivision(stream, course, standard, specialization)
    }

    suspend fun deleteAllClassRoom(){
                    classRoomDao.deleteAllClassRoom()
    }

}