package com.example.pagingdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;

/**
 * Create by LiangJingJie
 * On Create: 2020/11/12 17:23
 * Description
 */
class MyPaged3ListAdapter extends PagingDataAdapter<MyDataBean, MyViewHolder> {

    public MyPaged3ListAdapter() {
        // 通过 构造方法 设置 DiffUtil.ItemCallback
        super(DIFF_CALLBACK);
    }

    private static DiffUtil.ItemCallback<MyDataBean> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MyDataBean>() {
                @Override
                public boolean areItemsTheSame(MyDataBean oldConcert, MyDataBean newConcert) {
                    // 比较两个Item数据是否一样的，可以简单用 Bean 的 hashCode来对比
                    return oldConcert.hashCode() == newConcert.hashCode();
                }

                @Override
                public boolean areContentsTheSame(MyDataBean oldConcert,
                                                  MyDataBean newConcert) {
                    // 写法基本上都这样写死即可
                    return oldConcert.equals(newConcert);
                }
            };


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // getItem() 是 PagedListAdapter 内部方法，通过此方法可以获取到对应位置Item 的数据
        holder.bindData(getItem(position));
    }
}
