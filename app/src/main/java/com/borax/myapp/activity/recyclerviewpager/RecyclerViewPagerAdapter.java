package com.borax.myapp.activity.recyclerviewpager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.borax.myapp.R;
import com.borax.myapp.activity.shengchong.entity.DateBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by borax on 2017/2/21.
 */

public class RecyclerViewPagerAdapter extends RecyclerView.Adapter<RecyclerViewPagerAdapter.ViewHolder> {

    private Context context;
    private List<DateBean> list = new ArrayList<DateBean>();

    public RecyclerViewPagerAdapter(Context context, List<DateBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.datepager_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final int num = position * 7;

        holder.day0.setText(list.get(num).getDay() + "");
        holder.day1.setText(list.get(num + 1).getDay() + "");
        holder.day2.setText(list.get(num + 2).getDay() + "");
        holder.day3.setText(list.get(num + 3).getDay() + "");
        holder.day4.setText(list.get(num + 4).getDay() + "");
        holder.day5.setText(list.get(num + 5).getDay() + "");
        holder.day6.setText(list.get(num + 6).getDay() + "");

        holder.ll0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateBean date = list.get(num);
                Toast.makeText(context, date.getYear() + "-" + date.getMonth() + "-" + date.getDay(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateBean date = list.get(num + 1);
                Toast.makeText(context, date.getYear() + "-" + date.getMonth() + "-" + date.getDay(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateBean date = list.get(num + 2);
                Toast.makeText(context, date.getYear() + "-" + date.getMonth() + "-" + date.getDay(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateBean date = list.get(num + 3);
                Toast.makeText(context, date.getYear() + "-" + date.getMonth() + "-" + date.getDay(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateBean date = list.get(num + 4);
                Toast.makeText(context, date.getYear() + "-" + date.getMonth() + "-" + date.getDay(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.ll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateBean date = list.get(num + 5);
                Toast.makeText(context, date.getYear() + "-" + date.getMonth() + "-" + date.getDay(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.ll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateBean date = list.get(num + 6);
                Toast.makeText(context, date.getYear() + "-" + date.getMonth() + "-" + date.getDay(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size() / 7;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.week0)
        TextView week0;
        @BindView(R.id.day0)
        TextView day0;
        @BindView(R.id.week1)
        TextView week1;
        @BindView(R.id.day1)
        TextView day1;
        @BindView(R.id.week2)
        TextView week2;
        @BindView(R.id.day2)
        TextView day2;
        @BindView(R.id.week3)
        TextView week3;
        @BindView(R.id.day3)
        TextView day3;
        @BindView(R.id.week4)
        TextView week4;
        @BindView(R.id.day4)
        TextView day4;
        @BindView(R.id.week5)
        TextView week5;
        @BindView(R.id.day5)
        TextView day5;
        @BindView(R.id.week6)
        TextView week6;
        @BindView(R.id.day6)
        TextView day6;
        @BindView(R.id.ll0)
        LinearLayout ll0;
        @BindView(R.id.ll1)
        LinearLayout ll1;
        @BindView(R.id.ll2)
        LinearLayout ll2;
        @BindView(R.id.ll3)
        LinearLayout ll3;
        @BindView(R.id.ll4)
        LinearLayout ll4;
        @BindView(R.id.ll5)
        LinearLayout ll5;
        @BindView(R.id.ll6)
        LinearLayout ll6;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
