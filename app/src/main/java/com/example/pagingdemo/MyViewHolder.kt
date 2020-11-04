package com.example.pagingdemo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Create by LiangJingJie
 * On Create: 2020/11/3 10:46
 * Description
 */
class MyViewHolder(val itemV: View) : RecyclerView.ViewHolder(itemV) {

    fun bindData(data: MyDataBean) {
        itemV.findViewById<TextView>(R.id.tvNum).text = data.position.toString()

        if (data.position % 2 == 0){
            itemV.findViewById<TextView>(R.id.tvNum).setBackgroundColor(itemV.context.resources.getColor(R.color.colorAccent))
        }else{
            itemV.findViewById<TextView>(R.id.tvNum).setBackgroundColor(itemV.context.resources.getColor(R.color.colorPrimaryDark))
        }
    }
}