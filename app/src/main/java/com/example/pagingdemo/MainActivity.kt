package com.example.pagingdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val myPagedListAdapter = MyPagedListAdapter()
        recyclerView.adapter = myPagedListAdapter

        /**
         *      ViewModel 绑定 Activity 生命周期
         * */
        val myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)

        /**
         *      ViewModel 感知数据变化，更新 Adapter 列表
         * */
        myViewModel.getConvertList().observe(this, Observer {
            myPagedListAdapter.submitList(it)
        })
    }

}