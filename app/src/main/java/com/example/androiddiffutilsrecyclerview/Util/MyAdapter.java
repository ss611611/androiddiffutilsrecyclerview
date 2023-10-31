package com.example.androiddiffutilsrecyclerview.Util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddiffutilsrecyclerview.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<String> dataSource;

    public MyAdapter(List<String> dataSource) {
        this.dataSource = dataSource;
    }

    public  void insertData(List<String> insertList)
    {
        /*
        This function will add new data to RecyclerView
         */
        MyDiffUtilCallback diffUtilCallback = new MyDiffUtilCallback(dataSource, insertList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);

        dataSource.addAll(insertList);
        diffResult.dispatchUpdatesTo(this);
    }

    public  void updateData(List<String> newList)
    {
        /*
        This function will clear old data and add new
         */
        MyDiffUtilCallback diffUtilCallback = new MyDiffUtilCallback(dataSource, newList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);

        dataSource.clear();
        dataSource.addAll(newList);
        diffResult.dispatchUpdatesTo(this);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.my_text_view.setText(dataSource.get(i));
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView my_text_view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            my_text_view = (TextView)itemView.findViewById(R.id.my_text_view);
        }
    }
}
