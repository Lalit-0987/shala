package com.soft.shala.MVVM.Model

data class ClassRoom(val id:Int,val classCode:String,
                val stream:String,
                val course_type:String,
                val course:String
                ,val standard:String,
                val division:String,val specialization:String,
                val no_of_student:Int,val accedemic_year:String,val update_date:String) {
}