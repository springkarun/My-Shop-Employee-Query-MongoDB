package com.myshop.serviceDAO

import com.myshop.model.ProductModel
import com.myshop.model.ResponseModel
import com.myshop.repository.ProductRepo
import com.myshop.service.ProductService
import com.myshop.utils.Constant
import com.myshop.utils.Constant.CREATED
import com.myshop.utils.Constant.dataFormat
import com.myshop.utils.Constant.emptyArrays
import com.myshop.utils.Constant.regOK
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.query.Query
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import sun.security.krb5.internal.KDCOptions.with
import org.springframework.data.mongodb.core.query.Query.query






@Service("productService")
class ProductDAO : ProductService {

    @Autowired
    private val regRepo:ProductRepo?=null


    override fun createProduct(productName: String?, productBrand: String?, productPrice: Double?): Any {
        val randomId="SM${(Math.random()*1000).toInt()}"
        val current = LocalDateTime.now()
        val date = current.format(dataFormat)
        regRepo!!.save(ProductModel(randomId,productName,productBrand,productPrice,date))
        val res=regRepo.findByProductId(randomId)
        return  ResponseEntity(ResponseModel(true, regOK,res),CREATED )

    }


    override fun showAllProduct(): Any {
        val res=regRepo!!.findAll().reversed()
        if(res.isNotEmpty())
            return  ResponseEntity(ResponseModel(true, "Total Size : ${res.size}",res), Constant.OK)
        else  return ResponseEntity(ResponseModel(false, Constant.dataEmpty,emptyArrays), Constant.OK)
    }
}