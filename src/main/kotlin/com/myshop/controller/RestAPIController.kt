package com.myshop.controller

import com.myshop.service.EmployeeService
import com.myshop.service.ProductService
import com.myshop.utils.Constant.KeyProductBrand
import com.myshop.utils.Constant.KeyProductName
import com.myshop.utils.Constant.KeyProductPrice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["/api"])
class RestAPIController {

    //https://lishman.io/spring-data-mongodb-repositories

    @Autowired
    private var registerService: ProductService? = null

    @Autowired
    private var registerEmp: EmployeeService? = null


    @PostMapping("/createProduct")
    fun createProduct(@RequestBody body: Map<String, String>): Any {
        return registerService!!.createProduct(body[KeyProductName],
                body[KeyProductBrand], body[KeyProductPrice]!!.toDouble())
    }


    @GetMapping("/showAllProduct")
    fun showAllStudent(): Any = registerService!!.showAllProduct()


    @PostMapping(value = ["/registerEmployee"])
    fun registerEmployee(@RequestBody body: Map<String, String>): Any {
        return registerEmp!!.registerEmployee(body)
    }

    @GetMapping(value = ["/showAllEmployee"])
    fun showAllEmployee(): Any = registerEmp!!.showAllEmployee()

    @GetMapping(value = ["/sortBySalary/{age}"])
    fun sortBySalary(@PathVariable("age")age:Int): Any = registerEmp!!.sortBySalary(age)




}