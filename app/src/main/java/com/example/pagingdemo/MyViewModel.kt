package com.example.pagingdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList


/**
 * Create by LiangJingJie
 * On Create: 2020/11/2 18:08
 * Description
 */
class MyViewModel : ViewModel() {

    private var mDataSource : DataSource<Int, MyDataBean>
    private var mDataList: LiveData<PagedList<MyDataBean>>

    init {
        // 把 PositionalDataSource 和 Factory 绑定，让 ViewModel 感知数据的变化
        var dataFactory = DataFactory()
        mDataSource = dataFactory.create()
        /**
         *      @param1 dataFactory 设定 dataFactory
         *      @param2 设定每一次加载的长度
         *              这个和 PositionalDataSource 回调方法 loadSize 一致的
         * */
        mDataList = LivePagedListBuilder(dataFactory, 20).build()
    }

    // 暴露方法，让Activity 感知数据变化，去驱动 Adapter更新列表
    fun getConvertList(): LiveData<PagedList<MyDataBean>> {
        return mDataList
    }
}