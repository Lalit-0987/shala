package com.soft.shala.API

import com.soft.shala.MVVM.Model.Attendance
import com.soft.shala.MVVM.Model.ClassRoom
import com.soft.shala.MVVM.Model.Examination
import com.soft.shala.MVVM.Model.HallTicketMaster
import com.soft.shala.MVVM.Model.ResultMaster
import com.soft.shala.MVVM.Model.Schedule
import com.soft.shala.MVVM.Model.Session
import com.soft.shala.MVVM.Model.SessionAttendance
import com.soft.shala.MVVM.Model.Student
import com.soft.shala.MVVM.Model.Subject
import com.soft.shala.MVVM.Model.Teacher
import com.soft.shala.MVVM.Model.TeacherHallTicket
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    //Common API

    @GET("getClassCodeBackUp.php")
    suspend fun getClassCodeBackUp()

    @GET("getStream.php")
    suspend fun getStream()

    @POST("getCourse.php")
    suspend fun getCourse(stream: String)

    @POST("getStandard.php")
    suspend fun getStandard(stream: String,course: String)

    @POST("getStandard.php")
    suspend fun getSpecialization(stream: String,course: String)

    @POST("getDivision.php")
    suspend fun getDivision(stream: String,course: String,standard: String)

    @POST("getClassCode.php")
    suspend fun getClassCode(stream: String,course: String,standard: String,specialization: String,division: String)

    @GET("getClassBackUp.php")
    suspend fun getClassBackUp() :Response<List<ClassRoom>>

    @GET("getScheduleBackUp.php")
    suspend fun getScheduleBackUp() :Response<List<Schedule>>

    @GET("getSessionBackUp.php")
    suspend fun getSessionBackUp():Response<List<Session>>


    //Account for Student & Teacher

    @POST("getAuthStudent.php")
    suspend fun getStudentAuth(reg:String,pass:String):Response<Student>

    @POST("getAuthTeacher.php")
    suspend fun getTeacherAuth(reg:String,pass:String):Response<Teacher>

    @POST("createStudentAcc.php")
    suspend fun createStudentAcc(name:String,classCode:String,stream:String,standard:String,course:String,division:String,specialization:String,
                                 accedemic_year:String,emailId:String,regNo:String,password:String,admitDate:String,
                                 updateDate:String):Response<Student>
    @POST("createTeacherAcc.php")
    suspend fun createTeacherAcc(title:String,teacherName:String,emailId:String,regNo:String,password:String,
                                 subject:String,classCode:String,joinDate:String,updateDate:String):Response<Teacher>


    @POST("getAuthByOTP.php")
    suspend fun getAuthByOTP(reg:String,otp:String):Response<String>

    @POST("saveFCMDetails.php")
    suspend fun saveFCMDetails(userType:String,fcmToken:String,reg: String) :Response<String>

    // Attendance for Teacher & Student

    @POST("createRequestOTP.php")
    suspend fun createRequestForOTP(classCode:String,subCode:String,teacherCode:String):Response<String>

    @POST("deleteQRCodeByTimeUP.php")
    suspend fun deleteQRCODEByTimeUP(classCode:String,subCode:String,teacherCode:String,otp:String):Response<String>

    @POST("sendQRCodeByStudent.php")
    suspend fun sendQRCODEOTPTOServer(rollNo: String,subCode: String,classCode:String,otp:String,updateTime:String):Response<String>

    @POST("saveFinalAttendanceByDMY.php")
    suspend fun saveFinalAttendanceByDMY(attendDate:String,classCode:String,teacherCode:String,subCode:String,topic:String,noOfStudents:Int,noOfPresent:Int,presentList:String,
                                         sessionDate:String,sessionTime: String,month:String,year:Int,updateTime:String):Response<List<SessionAttendance>>

    @POST("getStudentAttendanceBySubjectCode.php") // for teacher
    suspend fun getStudentAttendanceBySubjectCode(subCode: String,month: String,year: Int):Response<List<SessionAttendance>>

    @POST("getAttendanceBySubjectCode.php") // for teacher
    suspend fun getAttendanceListOfStudentBySubjectCode(subCode: String,teacherCode: String,month: String,year: Int):Response<List<SessionAttendance>>

    @POST("getAttendanceByDate.php") // student
    suspend fun  getAttendanceByDate(attendDate: String,classCode: String):Response<List<SessionAttendance>>

    @POST("getAttendanceByClassCode.php") // for Student
    suspend fun getAttendanceByClassCode(classCode: String):Response<List<SessionAttendance>>

    // Schedule for Student
    @POST("getDayWiseLectureForTeacher.php") //for teacher
    suspend fun getDayWiseLecture(teacherCode: String,day:String):Response<List<Schedule>>

    @POST("getDayWiseLectureForStudent.php") //for students
    suspend fun  getDayWiseLectureForStudent(classCode: String,day:String)

    @POST("getLectureDetailsBySubject.php") // for Student & Teacher remainin to design
    suspend fun getLectureDetailsBySubject(subjectCode:String,classCode: String):Response<List<Schedule>>

    @POST("getLectureDetailsByClassCode.php") // for Student & Teacher remainin to design
    suspend fun getLectureDetailsByClassCode(classCode: String):Response<List<Schedule>>

    //schedule for teachers
    @POST("getLectureDetailsBySubjectTeacher.php") // for teacher (Summery , upcoming 5 lectures display
    suspend fun getLectureDetailsBySubjectTeacher(subCode: String,teacherCode: String):Response<List<Schedule>>


    //Examination for Student

    @POST("getStudentHallTicket.php")
    suspend fun getStudentHallTicket(studentId: String,classCode: String,examCode:String):Response<HallTicketMaster>

    @POST("getExamDetailsByExamCode.php")
    suspend fun getExamDetailsByExamCode(examCode: String,examType:String):Response<List<Examination>>

    @POST("getExamListByClassCode.php")
    suspend fun getExamListByClassCode(classCode: String,examType: String):Response<List<Examination>>

    @POST("getExamDetailsByMonth.php")
    suspend fun getExamDetailsByMonth(examCode: String,examType: String,month: String):Response<List<Examination>>

    // Examination For Teacher

    @POST("getTeacherHallTicket.php")
    suspend fun getTeacherHallTicket(teacherId:String,examCode: String,examType: String):Response<List<TeacherHallTicket>>

    @POST("getExamWorkDetails.php")
    suspend fun getExamWorkDetails(teacherId: String,examCode: String,examType: String):Response<List<Examination>>


    // Result for Student
    @POST("getResultByStudent.php")
    suspend fun getResultByStudent(studentId: String,hallTicketNo:String,examCode: String):Response<List<ResultMaster>>

    //Result For Teacher
    @POST("getResultBySubjectCode.php")
    suspend fun getResultBySubjectCode(subCode: String,examCode: String):Response<List<ResultMaster>>

    @POST("getResultByClassCode.php")
    suspend fun getResultByClassCode(classCode: String,examCode: String):Response<List<ResultMaster>>

    @POST("getResultByAllClassCode.php")
    suspend fun getResultByAllClassCode(examCode: String,examType: String):Response<List<ResultMaster>>

    @POST("getResultForAllExam.php")
    suspend fun getResultForAllExam(examType: String):Response<List<ResultMaster>>


}