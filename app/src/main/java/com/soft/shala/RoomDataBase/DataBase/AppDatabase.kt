package com.soft.shala.RoomDataBase.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.soft.shala.RoomDataBase.Dao.AttendanceDao
import com.soft.shala.RoomDataBase.Dao.ClassRoomDao
import com.soft.shala.RoomDataBase.Dao.ScheduleDao
import com.soft.shala.RoomDataBase.Dao.SessionDao
import com.soft.shala.RoomDataBase.Dao.StudentDao
import com.soft.shala.RoomDataBase.Dao.SubjectDao
import com.soft.shala.RoomDataBase.Dao.TeacherDao
import com.soft.shala.RoomDataBase.Entity.ClassRoom
import com.soft.shala.RoomDataBase.Entity.DailyAttendanceTbl
import com.soft.shala.RoomDataBase.Entity.ResultTbl
import com.soft.shala.RoomDataBase.Entity.ScheduleTbl
import com.soft.shala.RoomDataBase.Entity.SessionTbl
import com.soft.shala.RoomDataBase.Entity.StudentExamTbl
import com.soft.shala.RoomDataBase.Entity.StudentTbl
import com.soft.shala.RoomDataBase.Entity.SubjectTbl
import com.soft.shala.RoomDataBase.Entity.TeacherExamTbl
import com.soft.shala.RoomDataBase.Entity.TeacherTbl

@Database(entities = [ClassRoom::class,DailyAttendanceTbl::class,ResultTbl::class,ScheduleTbl::class,SessionTbl::class,StudentExamTbl::class,StudentTbl::class
                     ,StudentTbl::class,SubjectTbl::class,TeacherExamTbl::class,TeacherTbl::class], version = 1, exportSchema = false)
    abstract class AppDatabase : RoomDatabase() {
            abstract fun attendanceDao():AttendanceDao
            abstract fun classRoomDao():ClassRoomDao
            abstract fun studentDao():StudentDao
            abstract fun subjectDao():SubjectDao
            abstract fun teacherDao():TeacherDao
            abstract fun scheduleDao():ScheduleDao
            abstract fun sessionDao():SessionDao
}
object DatabaseProvider {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "shala_db"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}