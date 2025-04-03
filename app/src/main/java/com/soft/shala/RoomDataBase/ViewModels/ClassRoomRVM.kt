package com.soft.shala.RoomDataBase.ViewModels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soft.shala.RoomDataBase.DataBase.DatabaseProvider
import com.soft.shala.RoomDataBase.Entity.ClassRoom
import kotlinx.coroutines.launch

class ClassRoomRVM(c:Context) :ViewModel() {
    val room=DatabaseProvider.getDatabase(c)

    public fun saveClassRoom(classRoom: ClassRoom){
        viewModelScope.launch {
            try{
                room.classRoomDao().saveClassRoom(classRoom)
            }catch (ex:Exception){
                Log.e("classRoomRVM",ex.localizedMessage)
            }
        }
    }
}