package com.soft.shala.MVVM.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soft.shala.API.API
import com.soft.shala.API.ApiInterface
import com.soft.shala.MVVM.Model.ClassRoom
import com.soft.shala.MVVM.Model.Schedule
import com.soft.shala.MVVM.Model.Session
import kotlinx.coroutines.launch

class UtilAppVM:ViewModel() {

        private var schedule= MutableLiveData<List<Schedule>>()
        private var session = MutableLiveData<List<Session>>()
        private var classRoom= MutableLiveData<List<ClassRoom>>()
        private lateinit var api:ApiInterface

        init {
         api=API.ApiService
        }

    public fun getSchedulebackUp():MutableLiveData<List<Schedule>>{

        viewModelScope.launch {
            try{
                val schd= api.getScheduleBackUp()
                if(schd.isSuccessful && schd.body()!=null){
                    schedule.value=schd.body()
                }
            }catch (ex:Exception){
                Log.e("scheduleBCKVM",ex.localizedMessage)
            }
        }

        return schedule
    }

    public fun getSessionBackUp():MutableLiveData<List<Session>>{
        viewModelScope.launch {
            try{
                val sess=api.getSessionBackUp()
                if(sess.isSuccessful && sess.body()!=null){
                    session.value=sess.body()
                }
            }catch (ex:Exception){
                Log.e("sessionBCKVM",ex.localizedMessage)
            }
        }
        return session
    }

    public fun getClassRoomBackUp():MutableLiveData<List<ClassRoom>>{

        viewModelScope.launch {

            try{
                val classR=api.getClassBackUp()
                if(classR.isSuccessful && classR.body()!=null){
                    classRoom.value=classR.body()
                }
            }catch (ex:Exception){
                Log.e("classRoomUPDVM",ex.localizedMessage)
            }
        }

        return classRoom
    }


}