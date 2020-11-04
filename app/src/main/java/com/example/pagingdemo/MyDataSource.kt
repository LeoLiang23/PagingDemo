package com.example.pagingdemo

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.paging.PositionalDataSource


/**
 * Create by LiangJingJie
 * On Create: 2020/11/2 16:56
 * Description
 */
class MyDataSource : PositionalDataSource<MyDataBean>() {

    /**
     *  第一次打开页面，需要回调此方法来获取数据
     * */
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<MyDataBean>) {
        // 获取网络数据
        val list = getData(params.requestedStartPosition, params.pageSize)
        /**
         *      这个方法是返回数据，让 绑定ViewModel 感知。 这里要用对方法
         *      @param1  数据列表
         *      @param2  数据为起始位置
         *      @param3  数据列表总长度，这个一定要设置好哦，如果设置了50，
         *               当列表的长度为50时，列表再也无法出发 loadRange（） 去加载更多了
         *               如果不知道列表总长度，可以设置 Int 的最大值 999999999
         *               这里设置 10000
         * */
        callback.onResult(list, 0, 10000)
    }

    /**
     *  当有了初始化数据之后，滑动的时候如果需要加载数据的话，会调用此方法。
     * */
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<MyDataBean>) {
        /**
         *      params.startPosition  列表需要从 startPosition 加载更多
         *      params.loadSize       列表需要从 startPosition 加载长度 为 loadSize的数据
         * */
        val list = getData(params.startPosition, params.loadSize)
        callback.onResult(list)
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