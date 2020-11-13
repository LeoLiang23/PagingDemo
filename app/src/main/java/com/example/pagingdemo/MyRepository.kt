package com.example.pagingdemo

import androidx.paging.Pager
import androidx.paging.PagingConfig

/**
 * Create by LiangJingJie
 * On Create: 2020/11/12 18:11
 * Description
 */
class MyRepository {

    /**
     *      pageSize = 20  设置每一页加载长度，
     *      和 PagingSource 的 params.loadSize对应
     * */
    fun getData() = Pager(PagingConfig(pageSize = 20)) {
        MyPagingSource()
    }.flow

}