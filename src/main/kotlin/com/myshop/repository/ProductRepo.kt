package com.myshop.repository

import com.myshop.model.ProductModel
import com.myshop.utils.Constant.KeyProductId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query


interface ProductRepo:MongoRepository<ProductModel,String>{

    @Query("{$KeyProductId : ?0}")
    fun findByProductId(productId: String?):List<ProductModel>





}

