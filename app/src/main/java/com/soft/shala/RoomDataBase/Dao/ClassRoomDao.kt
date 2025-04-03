package com.soft.shala.RoomDataBase.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.soft.shala.RoomDataBase.Entity.ClassRoom

@Dao
interface ClassRoomDao {

    @Insert
    suspend fun saveClassRoom(classRoom:ClassRoom)

    @Query("Select * from classRoom where stream =:stream AND course =:course AND " +
            " standard =:standard AND specialization  =:specialization AND division =:division")
    suspend fun getClassCode(stream:String,course:String,standard:String,specialization:String,division:String):LiveData<List<ClassRoom>>

    @Query("Select * from classRoom")
    suspend fun getStream():LiveData<List<ClassRoom>>

    @Query("Select * from classRoom where stream =:stream")
    suspend fun getCourse(stream:String):LiveData<List<ClassRoom>>

    @Query("Select * from classRoom where stream =:stream AND course =:course")
    suspend fun getSpecialization(stream:String,course:String):LiveData<List<ClassRoom>>


    @Query("Select * from classRoom where stream =:stream AND course =:course AND specialization  =:specialization")
    suspend fun getStandard(stream:String,course:String,specialization:String):LiveData<List<ClassRoom>>

    @Query("Select * from classRoom where stream =:stream AND course =:course AND " +
            " standard =:standard AND specialization  =:specialization")
    suspend fun getDivision(stream:String,course:String,standard:String,specialization:String):LiveData<List<ClassRoom>>

    @Query("delete from classRoom")
    suspend fun deleteAllClassRoom()

    }