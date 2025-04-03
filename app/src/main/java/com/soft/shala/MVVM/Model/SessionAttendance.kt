package com.soft.shala.MVVM.Model

data class SessionAttendance(

     private var session_id:String,
     private var subject_code:String,
     private var class_code:String,
     private var session_date:String,
     private var session_time:String,
     private var teacher_code:String,
     private var subject:String,
     private var topic:String,
     private var no_of_students:String,
     private var no_of_present:String,
     private var present_list:String,
     private var month:String,
     private var year:String,
     private var update_time:String

)
