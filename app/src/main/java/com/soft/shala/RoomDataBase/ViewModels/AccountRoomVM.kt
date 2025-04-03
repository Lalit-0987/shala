package com.soft.shala.RoomDataBase.ViewModels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soft.shala.RoomDataBase.DataBase.DatabaseProvider
import com.soft.shala.RoomDataBase.Entity.StudentTbl
import com.soft.shala.RoomDataBase.Entity.TeacherTbl
import kotlinx.coroutines.launch

class AccountRoomVM (c:Context):ViewModel() {

    val api=DatabaseProvider.getDatabase(c)

    public fun saveStudentAcc(studentTbl: StudentTbl){

        viewModelScope.launch {
            try{
                  api.studentDao().saveStudent(studentTbl)
            }catch (ex:Exception){
                Log.e("SaveStudentRVM",ex.localizedMessage)
            }
        }
    }

    public fun getStudentAccInfo():StudentTbl{
        lateinit var student:StudentTbl
        viewModelScope.launch{

            try{
                    student =api.studentDao().getStudentAccountInfo()
            }catch (ex:Exception){
                Log.e("studentInfoRVM",ex.localizedMessage)
            }
        }
            return student
    }


    public fun saveTeacherInfo(teacherTbl: TeacherTbl){

        viewModelScope.launch {
            try{
                api.teacherDao().saveTeacherInfo(teacherTbl)
            }catch (ex:Exception){
                Log.e("saveTeacherRVM",ex.localizedMessage)
            }
        }
    }

    public fun getTeacherAccInfo():TeacherTbl{


        lateinit var teacher:TeacherTbl
        viewModelScope.launch {
            try{
                teacher=api.teacherDao().getTeacherAccountInfo()
            }catch (ex:Exception){
                Log.e("teacherAccRVM",ex.localizedMessage)
            }
        }

        return teacher
    }
}