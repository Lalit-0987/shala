package com.soft.shala.appInIt

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.soft.shala.MVVM.Model.Student
import com.soft.shala.MVVM.Model.Teacher
import com.soft.shala.MVVM.ViewModel.AccountVM
import com.soft.shala.R
import com.soft.shala.RoomDataBase.DataBase.AppDatabase
import com.soft.shala.RoomDataBase.DataBase.DatabaseProvider
import com.soft.shala.RoomDataBase.Entity.StudentTbl
import com.soft.shala.RoomDataBase.Entity.TeacherTbl
import com.soft.shala.RoomDataBase.ViewModels.AccountRoomVM
import com.soft.shala.databinding.LoginBinding


class login : AppCompatActivity() {

   private  lateinit var accType:String
   private lateinit var  loginBinding: LoginBinding
   val vm:AccountVM by viewModels()
   val accRvm :AccountRoomVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        loginBinding=DataBindingUtil.setContentView(this,R.layout.login)
        loginBinding.lifecycleOwner=this

        if(loginBinding.student.isChecked){
            accType="Student"
        }else{
            accType="Teacher"
        }

        loginBinding.login.setOnClickListener {
            if(accType=="Student"){
                    vm.getStudentAuth(loginBinding.registerNo.text.toString(),loginBinding.password.text.toString())
                        .observe(this){
                            result->saveStudent(result)
                        }
            }else{
                vm.getTeacherAuth(loginBinding.registerNo.text.toString(),loginBinding.password.text.toString())
                    .observe(this){
                        result->saveTeacher(result)
                    }
            }
        }
    }

    private  fun saveStudent(student: Student){
                    try{

                            val student=StudentTbl(id = student.id, no = student.no, studentId =student.studentId,
                               rollNo = student.rollNo, name = student.name, classCode = student.classCode, standard = student.standard,
                               division = student.division, specialization = student.specialization, accedemic_year = student.accedemic_year,
                               emailId = student.emailId, regNo = student.regNo,password = student.password, admitDate = student.admitDate,
                               updateDate = student.updateDate)

                            accRvm.saveStudentAcc(student)
                            moveToBackupData()
                    }catch (ex:Exception){
                            Log.e("saveRoomStudet",ex.localizedMessage)
                    }
    }

    private fun saveTeacher(teacher: Teacher){
            try{

                val teacher=TeacherTbl(id = 0, teacherId = teacher.teacherId, title = teacher.title, teacherName = teacher.teacherName,
                    regNo = teacher.regNo, emailId = teacher.emailId, password = teacher.password, subjectCode = teacher.subjectCode,
                    joinDate = teacher.joinDate, updateDate = teacher.updateDate)

                accRvm.saveTeacherInfo(teacher)
                moveToBackupData()
            }catch (ex:Exception){
                Log.e("teacherRoomEr",ex.localizedMessage)
            }
    }

    private fun moveToBackupData(){
        val intent=Intent(this,BackUpData::class.java)
        startActivity(intent)
    }
}