package com.example.pagingdemo

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource


/**
 * Create by LiangJingJie
 * On Create: 2020/11/2 18:01
 * Description
 */
class DataFactory: DataSource.Factory<Int, MyDataBean>() {

    private val mSourceLiveData: MutableLiveData<MyDataSource> =
        MutableLiveData<MyDataSource>()

    override fun create(): DataSource<Int, MyDataBean> {
        val myDataSource = MyDataSource()
        mSourceLiveData.postValue(myDataSource)
        return myDataSource
    }

}