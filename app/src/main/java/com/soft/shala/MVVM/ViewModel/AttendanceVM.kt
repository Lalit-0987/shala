package com.soft.shala.MVVM.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soft.shala.API.API
import kotlinx.coroutines.launch

class AttendanceVM(private var dataBase:API):ViewModel() {

    private val createOTP=MutableLiveData<String>()
    private val deleteOTP=MutableLiveData<String>()
    private val sendOTP=MutableLiveData<String>()
    private val saveAttendance=MutableLiveData<String>()

    var api=API.ApiService

    public fun getCreateOTP():MutableLiveData<String>{
        viewModelScope.launch {
            try{

            }catch (ex:Exception){
                Log.e("createOTPError",ex.localizedMessage)
            }
        }

        return createOTP

    }
}