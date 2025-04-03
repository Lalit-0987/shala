package com.soft.shala.MVVM.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soft.shala.API.API
import com.soft.shala.MVVM.Model.Student
import com.soft.shala.MVVM.Model.Teacher
import kotlinx.coroutines.launch

class AccountVM :ViewModel() {

    private val studentAuth=MutableLiveData<Student>()
    private val teacherAuth=MutableLiveData<Teacher>()
    private val accStudent=MutableLiveData<Student>()
    private val accTeacher=MutableLiveData<Teacher>()
    private val saveFCMToken=MutableLiveData<String>()


        var  api= API.ApiService

    fun getStudentAuth(reg:String,pass:String):MutableLiveData<Student>{

            viewModelScope.launch {
                try{
                val student=api.getStudentAuth(reg,pass)
                if(student.isSuccessful && student.body()!=null){
                  studentAuth.value=student.body()
                }
                }catch (ex:Exception){
                    Log.e("studenAuth",ex.localizedMessage)
                }
            }
        return studentAuth
    }

    fun getTeacherAuth(reg: String,pass: String):MutableLiveData<Teacher>{

        viewModelScope.launch {
            try{
                val teacher=api.getTeacherAuth(reg, pass)
                if (teacher.isSuccessful && teacher.body() !=null){
                    teacherAuth.value=teacher.body()
                }
            }catch (ex:Exception){
                Log.e("teacherAUth",ex.localizedMessage)
            }
        }
        return teacherAuth
    }

    fun saveStudentAcc(name:String,classCode:String,stream:String,standard:String,course:String,division:String,specialization:String,
                       accedemic_year:String,emailId:String,regNo:String,password:String,admitDate:String,
                       updateDate:String):MutableLiveData<Student>{

        viewModelScope.launch {
            try{
                    val student=api.createStudentAcc(name, classCode, stream, standard, course, division, specialization, accedemic_year, emailId, regNo, password, admitDate, updateDate)
                    if(student.isSuccessful && student.body() !=null){
                        accStudent.value=student.body()
                    }
            }catch (ex:Exception){
                Log.e("saveStudent",ex.localizedMessage)
            }
        }

        return accStudent
    }

    fun saveTeacherAcc(title:String,teacherName:String,emailId:String,regNo:String,password:String,
                       subject:String,classCode:String,joinDate:String,updateDate:String):MutableLiveData<Teacher>{

            viewModelScope.launch {
                try{
                    val teacher=api.createTeacherAcc(title, teacherName, emailId, regNo, password, subject, classCode, joinDate, updateDate)
                    if(teacher.isSuccessful && teacher.body()!=null){
                        accTeacher.value=teacher.body()
                    }
                }catch (ex:Exception){
                    Log.e("saveTeacher",ex.localizedMessage)
                }
            }

            return accTeacher
    }

    fun getsaveFCMToken(userType:String,fcmToken:String,reg: String):MutableLiveData<String>{

        viewModelScope.launch {
            val fcm=api.saveFCMDetails(userType, fcmToken, reg)
            if(fcm.isSuccessful && fcm.body()!=null){
                saveFCMToken.value=fcm.body()
            }
        }
        return saveFCMToken
    }
}