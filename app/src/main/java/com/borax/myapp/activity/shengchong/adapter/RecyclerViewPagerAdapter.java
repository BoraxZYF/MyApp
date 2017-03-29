package com.borax.myapp.activity.shengchong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.borax.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by borax on 2017/2/21.
 */

public class RecyclerViewPagerAdapter extends RecyclerView.Adapter<RecyclerViewPagerAdapter.ViewHolder> {

    private Context context;

    public RecyclerViewPagerAdapter(Context context) {
        this.context = context;
    }


    @Override
    public RecyclerViewPagerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.datepager_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewPagerAdapter.ViewHolder holder, int position) {

        holder.day0.setText(position + "0");
        holder.day1.setText(position + "1");
        holder.day2.setText(position + "2");
        holder.day3.setText(position + "3");
        holder.day4.setText(position + "4");
        holder.day5.setText(position + "5");
        holder.day6.setText(position + "6");

    }

    @Override
    public int getItemCount() {
        return 100;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.week0)
        TextView week0;
        @BindView(R.id.day0)
        TextView day0;
        @BindView(R.id.ll0)
        LinearLayout ll0;
        @BindView(R.id.week1)
        TextView week1;
        @BindView(R.id.day1)
        TextView day1;
        @BindView(R.id.ll1)
        LinearLayout ll1;
        @BindView(R.id.week2)
        TextView week2;
        @BindView(R.id.day2)
        TextView day2;
        @BindView(R.id.ll2)
        LinearLayout ll2;
        @BindView(R.id.week3)
        TextView week3;
        @BindView(R.id.day3)
        TextView day3;
        @BindView(R.id.ll3)
        LinearLayout ll3;
        @BindView(R.id.week4)
        TextView week4;
        @BindView(R.id.day4)
        TextView day4;
        @BindView(R.id.ll4)
        LinearLayout ll4;
        @BindView(R.id.week5)
        TextView week5;
        @BindView(R.id.day5)
        TextView day5;
        @BindView(R.id.ll5)
        LinearLayout ll5;
        @BindView(R.id.week6)
        TextView week6;
        @BindView(R.id.day6)
        TextView day6;
        @BindView(R.id.ll6)
        LinearLayout ll6;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
