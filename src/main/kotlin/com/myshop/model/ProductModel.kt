package com.myshop.model

import com.myshop.utils.Constant.KeyCollectionProduct
import com.myshop.utils.Constant.KeyProductBrand
import com.myshop.utils.Constant.KeyProductDate
import com.myshop.utils.Constant.KeyProductId
import com.myshop.utils.Constant.KeyProductName
import com.myshop.utils.Constant.KeyProductPrice
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field


@Document(collection = KeyCollectionProduct)
data class ProductModel(
        @Id
        @Field(KeyProductId)
        var productId:  String? = null,

        @Field(KeyProductName)
        val productName: String? = null,

        @Field(KeyProductBrand)
        val productBrand: String? = null,

        @Field(KeyProductPrice)
        val productPrice: Double? = null,

        @Field(KeyProductDate)
        val productDate: String? = null


)