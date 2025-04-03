package com.soft.shala.RoomDataBase.ViewModels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soft.shala.RoomDataBase.DataBase.DatabaseProvider
import com.soft.shala.RoomDataBase.Entity.SessionTbl
import kotlinx.coroutines.launch

class SessionRVM(c: Context) :ViewModel() {

    val api=DatabaseProvider.getDatabase(c)
    public fun saveSession(sessionTbl: SessionTbl){

        viewModelScope.launch {
            try{
                api.sessionDao().saveSession(sessionTbl)
            }catch (ex:Exception){
                Log.e("sessRVM",ex.localizedMessage)
            }
        }
    }
}