package com.soft.shala.RoomDataBase.ViewModels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soft.shala.RoomDataBase.DataBase.DatabaseProvider
import com.soft.shala.RoomDataBase.Entity.ScheduleTbl
import kotlinx.coroutines.launch

class ScheduleRVM(c:Context) : ViewModel() {

    val api=DatabaseProvider.getDatabase(c)

    public fun saveSchedule(scheduleTbl: ScheduleTbl){
        viewModelScope.launch {
            try{
                    api.scheduleDao().saveSchedule(scheduleTbl)
            }catch (ex:Exception){
                Log.e("savescheRVM",ex.localizedMessage)
            }
        }
    }

}