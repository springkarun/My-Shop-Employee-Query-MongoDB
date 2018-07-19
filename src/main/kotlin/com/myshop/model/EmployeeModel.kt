package com.myshop.model

import com.myshop.utils.Constant.KeyCollectionEmp
import com.myshop.utils.Constant.KeyEmpAge
import com.myshop.utils.Constant.KeyEmpCity
import com.myshop.utils.Constant.KeyEmpDate
import com.myshop.utils.Constant.KeyEmpDept
import com.myshop.utils.Constant.KeyEmpFname
import com.myshop.utils.Constant.KeyEmpId
import com.myshop.utils.Constant.KeyEmpLname
import com.myshop.utils.Constant.KeyEmpSalary
import com.myshop.utils.Constant.KeyGender
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.io.Serializable


@Document(collection = KeyCollectionEmp)
data class EmployeeModel(
        @Id
        @Field(KeyEmpId)
        val emp_id: String?=null,
        @Field(KeyEmpFname)
        val first_name: String?=null,
        @Field(KeyEmpLname)
        val last_name: String?=null,
        @Field(KeyEmpAge)
        val age: Int?=null,
        @Field(KeyGender)
        val gender:Char?=null,
        @Field(KeyEmpCity)
        val city: String?=null,
        @Field(KeyEmpSalary)
        val salary: Double?=null,
        @Field(KeyEmpDept)
        val dept: Int?=null,
        @Field(KeyEmpDate)
        val date: String?=null
):Serializable