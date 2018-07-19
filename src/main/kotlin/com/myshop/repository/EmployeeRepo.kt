package com.myshop.repository

import com.myshop.model.EmployeeModel
import com.myshop.utils.Constant.KeyEmpId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query


interface EmployeeRepo:MongoRepository<EmployeeModel,String>{

     @Query("{_id : ?0}")
     fun findByEmpId(emp_id: String):List<EmployeeModel>


    // @Query("{'age' : {\$lt : ?0}}")
     @Query("{'salary' : {\$lt : ?0}}")
     fun sortBySalary(age:Int):List<EmployeeModel>



}

