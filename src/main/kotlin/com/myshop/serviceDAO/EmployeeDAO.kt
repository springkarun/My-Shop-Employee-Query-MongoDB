package com.myshop.serviceDAO

import com.myshop.model.EmployeeModel
import com.myshop.model.ResponseModel
import com.myshop.repository.EmployeeRepo
import com.myshop.service.EmployeeService
import com.myshop.utils.Constant
import com.myshop.utils.Constant.CREATED
import com.myshop.utils.Constant.KeyEmpAge
import com.myshop.utils.Constant.KeyEmpCity
import com.myshop.utils.Constant.KeyEmpDept
import com.myshop.utils.Constant.KeyEmpFname
import com.myshop.utils.Constant.KeyEmpLname
import com.myshop.utils.Constant.KeyEmpSalary
import com.myshop.utils.Constant.KeyGender
import com.myshop.utils.Constant.dataFormat
import com.myshop.utils.Constant.emptyArrays
import com.myshop.utils.Constant.regOK
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service("employeeService")
class EmployeeDAO : EmployeeService {


    @Autowired
    private val regRepo: EmployeeRepo? = null


    override fun registerEmployee(map: Map<String, String>): Any {

        val randomId = "EMP${(Math.random() * 1000).toInt()}"
        val current = LocalDateTime.now()
        val date = current.format(dataFormat)

        regRepo!!.save(EmployeeModel(
                randomId,
                map[KeyEmpFname],
                map[KeyEmpLname],
                map[KeyEmpAge]!!.toInt(),
                map[KeyGender]!!.single(),
                map[KeyEmpCity],
                map[KeyEmpSalary]!!.toDouble(),
                map[KeyEmpDept]!!.toInt(),
                date))

        val res = regRepo.findByEmpId(randomId.trim())
        return ResponseEntity(ResponseModel(true, regOK, res), CREATED)

    }


    override fun showAllEmployee(): Any {
        val res = regRepo!!.findAll().reversed()
        return if (res.isNotEmpty())
            ResponseEntity(ResponseModel(true, "Total Size : ${res.size}", res), Constant.OK)
        else ResponseEntity(ResponseModel(false, Constant.dataEmpty, emptyArrays), Constant.OK)
    }

    override fun sortBySalary(age:Int): Any {
       // val res = regRepo!!.findAll().reversed()
        val res = regRepo!!.sortBySalary(age)
        return if (res.isNotEmpty())
            ResponseEntity(ResponseModel(true, "Total Size  : ${res.size}", res), Constant.OK)
        else ResponseEntity(ResponseModel(false, Constant.dataEmpty +age, emptyArrays), Constant.OK)
    }
}