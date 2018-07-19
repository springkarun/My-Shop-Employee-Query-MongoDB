package com.myshop.utils

import org.springframework.http.HttpStatus
import java.time.format.DateTimeFormatter


object Constant{



   const val regOK="Registation is create successfully."
   const val category="Category is create successfully."
   const val regExists="Roll No already exists !!."
   const val dataEmpty="Data is Empty."
   const val shopAvatar="Please select a shopAvatar to upload."



    //Product Key & Collection Name 0r Table Name
    const val KeyCollectionProduct="product"

    //Product Key & Field Name 0r Column Name
    const val KeyProductId="productId"
    const val KeyProductName="productName"
    const val KeyProductBrand="productBrand"
    const val KeyProductPrice="productPrice"
    const val KeyProductDate="productDate"


    //Product Key & Collection Name 0r Table Name
    const val KeyCollectionEmp="emp"

    //Product Key & Field Name 0r Column Name
    const val KeyEmpId="emp_id"
    const val KeyEmpFname="first_name"
    const val KeyEmpLname="last_name"
    const val KeyEmpAge="age"
    const val KeyGender="gender"
    const val KeyEmpCity="city"
    const val KeyEmpSalary="salary"
    const val KeyEmpDept="dept"
    const val KeyEmpDate="date"


    //Product Key & Field Name 0r Column Name




    val String.upperCaseFirstLetter: String
        get() = this.substring(0, 1).toUpperCase().plus(this.substring(1))




         val OK= HttpStatus.OK
         val CREATED= HttpStatus.CREATED
         val CONFLICT= HttpStatus.CONFLICT
         val NOT_FOUND= HttpStatus.NOT_FOUND
         val emptyArrays=  arrayOf<String>()


    //Date Format
    val dataFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")


}