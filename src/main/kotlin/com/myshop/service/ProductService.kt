package com.myshop.service


interface ProductService{


    fun createProduct(productName: String?,productBrand: String?, productPrice: Double?):Any

    fun showAllProduct():Any

}

