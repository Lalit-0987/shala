package com.soft.shala.RoomDataBase.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.soft.shala.RoomDataBase.Entity.SubjectTbl

@Dao
interface SubjectDao {

    @Insert
    suspend fun saveSubject(subject:SubjectTbl)

    @Query("select * from subject where subjectName =:subjectName AND classCode =:classCode")
    suspend fun getSubjectCode(subjectName:String,classCode:String):LiveData<List<SubjectTbl>>

    @Query("delete from subject")
    suspend fun deleteSubject()

}