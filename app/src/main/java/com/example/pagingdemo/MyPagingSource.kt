package com.example.pagingdemo

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.paging.PagingSource

/**
 * Create by LiangJingJie
 * On Create: 2020/11/12 17:32
 * Description
 */
class MyPagingSource : PagingSource<Int, MyDataBean>() {

    /**
     *    params.key 是取 当前列表的起始节点
     *    params.loadSize 是获取当前列表的长度
     * */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MyDataBean> {
        val startPosition = params.key ?: 0
        val loadSize = params.loadSize
        // 加载的数据
        val data = getData(startPosition, loadSize)
        return LoadResult.Page(
            data,
            // 往上加载的Key ,如果不可以往上加载就null
            null,
            // 加载下一页的key 如果传null就说明到底了
            startPosition + data.size
        )
    }

    /**
     *  模拟网络获取数据
     * */
    private fun getData(startPosition: Int, pageSize: Int): MutableList<MyDataBean> {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(
                MyApplication.instant,
                "加载数据 从 $startPosition 加载到 ${startPosition + pageSize}",
                Toast.LENGTH_SHORT
            ).show()
        }
        val list = mutableListOf<MyDataBean>()
        for (i in startPosition until startPosition + pageSize) {
            list.add(MyDataBean(i))
        }
        return list
    }
}