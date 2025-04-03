package com.soft.shala.RoomDataBase.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.soft.shala.RoomDataBase.Entity.ScheduleTbl

@Dao
interface ScheduleDao {

    @Insert
    suspend fun saveSchedule(scheduleTbl: ScheduleTbl)

    @Update
    suspend fun updateSchedule(scheduleTbl: ScheduleTbl)

    @Query("delete from schedule")
    suspend fun deleteSchedule()
}