package com.myshop.service


interface EmployeeService{

    fun registerEmployee(map:Map<String,String>):Any

    fun showAllEmployee():Any

    fun sortBySalary(age:Int):Any



}

