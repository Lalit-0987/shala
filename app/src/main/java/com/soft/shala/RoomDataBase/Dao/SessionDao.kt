package com.soft.shala.RoomDataBase.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.soft.shala.RoomDataBase.Entity.SessionTbl

@Dao
interface SessionDao {

    @Insert
    suspend fun saveSession(sessionTbl: SessionTbl)

    @Update
    suspend fun updateSession(sessionTbl: SessionTbl)

    @Query("delete from session")
    suspend fun deleteSession()

}