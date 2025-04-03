package com.soft.shala.appInIt

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.soft.shala.MVVM.Model.ClassRoom
import com.soft.shala.MVVM.Model.Schedule
import com.soft.shala.MVVM.Model.Session
import com.soft.shala.MVVM.ViewModel.UtilAppVM
import com.soft.shala.R
import com.soft.shala.RoomDataBase.DataBase.DatabaseProvider
import com.soft.shala.RoomDataBase.Entity.ScheduleTbl
import com.soft.shala.RoomDataBase.Entity.SessionTbl
import com.soft.shala.RoomDataBase.ViewModels.ClassRoomRVM
import com.soft.shala.RoomDataBase.ViewModels.ScheduleRVM
import com.soft.shala.RoomDataBase.ViewModels.SessionRVM
import com.soft.shala.databinding.SplashScreenBinding

class BackUpData :AppCompatActivity() {

    private lateinit var  splashScreen:SplashScreenBinding
    private val vm:UtilAppVM by viewModels()
    private lateinit var scheduleList:List<Schedule>
    private val schRVM:ScheduleRVM by  viewModels()
    private val sessRVM:SessionRVM by  viewModels()
    private val clsRVM:ClassRoomRVM by  viewModels()
    private val flag:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashScreen=DataBindingUtil.setContentView(this, R.layout.splash_screen)

        getScheduleBackUp()

        getSessionBackUp()

        getClassCodeBackUp()

    }

    private fun getScheduleBackUp(){
            try{
                val schList=vm.getSchedulebackUp()
                if (schList!=null){
                    scheduleList=schList as List<Schedule>
                    saveSchedule(scheduleList)
                }
            }catch (ex:Exception){
                Log.e("scheduleER",ex.localizedMessage)
            }
    }

    private fun getSessionBackUp(){
            try{
                val sessList=vm.getSessionBackUp()
                if(sessList!=null){
                    saveSession(sessList as List<Session>)
                }

            }catch (ex:Exception){
                Log.e("sceesER",ex.localizedMessage)
            }

    }

    private fun getClassCodeBackUp(){

        try{
            val classRoomList=vm.getClassRoomBackUp()
            if(classRoomList!=null){
                saveClassRoom(classRoomList as List<ClassRoom>)
            }
        }catch (ex:Exception){
            Log.e("classER",ex.localizedMessage)
        }

    }

    private fun saveSchedule(scedule:List<Schedule>){
        try{
            val roomDb=DatabaseProvider.getDatabase(this)
            for(sch in scedule){
               val schData=ScheduleTbl(id = 0, scheduleId = sch.scheduleId, classCode = sch.classCode, subjectCode = sch.subjectCode,
                   teacherCode = sch.teacherCode, time = sch.time, day = sch.day, updateDate = sch.updateDate)

                schRVM.saveSchedule(schData)
            }
        }catch (ex:Exception){
            Log.e("scheduleErr",ex.localizedMessage)
        }
    }

    private fun saveSession(session: List<Session>){
        try{
            for(sess in session){
                val sessData=SessionTbl(id = 0, sessionId = sess.sessionId, sessionTime = sess.sessionTime, sessionDay = sess.sessionDay,
                    time = sess.time, updateTime = sess.updateTime)

                sessRVM.saveSession(sessData)

            }
        }catch (ex:Exception){
            Log.e("sessEr",ex.localizedMessage)
        }
    }

    private fun saveClassRoom(classRoom:List<ClassRoom>){

        try{
            for(cls in classRoom){
                val cls=com.soft.shala.RoomDataBase.Entity.ClassRoom(id = 0,classCode = cls.classCode,stream = cls.stream,
                    course_type =cls.course_type, course = cls.course, standard = cls.standard, division = cls.division,
                    specialization = cls.specialization, no_of_student = cls.no_of_student, accedemic_year = cls.accedemic_year,
                    update_date = cls.update_date)

                clsRVM.saveClassRoom(cls)
            }
        }catch (ex:Exception){
            Log.e("classER",ex.localizedMessage)
        }


    }
}