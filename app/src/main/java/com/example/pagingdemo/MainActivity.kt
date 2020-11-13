package com.example.pagingdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val myPagedListAdapter = MyPaged3ListAdapter()
        recyclerView.adapter = myPagedListAdapter
        /**
         *      ViewModel 绑定 Activity 生命周期
         * */
        val myViewModel = ViewModelProviders.of(this).get(MyPaging3ViewModel::class.java)

        /**
         *      ViewModel 感知数据变化，更新 Adapter 列表
         *      Adapter.submitData 这是一个用 suspend 修饰的方法，所以需要开启一个有生命周期的协程
         * */
        myViewModel.getData().observe(this, Observer {
            lifecycleScope.launch {
                myPagedListAdapter.submitData(it)
            }
        })


    }

}