package com.soft.shala.RoomDataBase.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.soft.shala.MVVM.Model.Student
import com.soft.shala.RoomDataBase.Entity.DailyAttendanceTbl

@Dao
interface AttendanceDao {

    @Insert
    suspend fun saveAttendance(student: DailyAttendanceTbl)

    @Query("Select * From dailyAttendance where classCode LIKE :classCode AND subCode LIKE :subCode AND attendDate" +
            " LIke :attendDate")
    suspend fun getAttendanceList(classCode:String,subCode:String,attendDate:String):List<DailyAttendanceTbl>

    @Query("Delete From dailyAttendance where attendDate LIKE :attendDate AND classCode LIKE :classCode AND " +
            "subCode LIKE :subCode")
    suspend fun clearAttendanceByDate(classCode:String,subCode:String,attendDate: String)

    @Query("Delete from dailyAttendance")
    suspend fun clearAllAttendanceRecord()

}