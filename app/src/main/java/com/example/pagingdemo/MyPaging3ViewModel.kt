package com.example.pagingdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

/**
 * Create by LiangJingJie
 * On Create: 2020/11/12 18:22
 * Description
 */
class MyPaging3ViewModel : ViewModel() {

    private val myRepository: MyRepository by lazy { MyRepository() }

    fun getData() = myRepository.getData().asLiveData()
}
