package com.example.jisung.mobapp_06;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by jisung on 2017-04-13.
 */

public class MetAdapter extends BaseAdapter {
    ArrayList<MetZip> data = new ArrayList<MetZip>();
    Context context;
    int checked = 0;

    public MetAdapter(Context context, ArrayList<MetZip> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView 가 만들어ㅈ져 있는지 아닌지 나눠서
        if (convertView == null) {
            convertView =
                    LayoutInflater.from(context).inflate(R.layout.listitem, null);
        }
        TextView t1 = (TextView) convertView.findViewById(R.id.tv1);
        TextView t2 = (TextView) convertView.findViewById(R.id.tv2);
        ImageView i1 = (ImageView) convertView.findViewById(R.id.imageView);
        CheckBox c1 = (CheckBox) convertView.findViewById(R.id.c1);
        if (checked == 1)
            c1.setVisibility(View.VISIBLE);
        else
            c1.setVisibility(View.INVISIBLE);

        final MetZip one = data.get(position);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                one.setChecked(true);
            }
        });


        t1.setText(one.getName());
        t2.setText(one.getNumber());


        if (one.getCatNum() == 1)
            i1.setImageResource(R.drawable.chicken);
        else if (one.getCatNum() == 2)
            i1.setImageResource(R.drawable.pizza);
        else
            i1.setImageResource(R.drawable.hamburger);

        return convertView;
    }

    Comparator<MetZip> nameAsc = new Comparator<MetZip>() {
        @Override
        public int compare(MetZip o1, MetZip o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    Comparator<MetZip> menuAsc = new Comparator<MetZip>() {
        @Override
        public int compare(MetZip o1, MetZip o2) {
            Log.d("menuASC", "OK2");
            Log.d("menuASC", o1.getCatNum() + "");
            String a = "A";
            String b = "B";
            if (o1.getCatNum() > o2.getCatNum())
                return 1;
            else
                return -1;
            // return o1.getCatNum()+" ".compareTo(o2.getCatNum()+" ");
        }
    };
    final static int NAME_ASC = 0;
    final static int MENU_ASC = 1;

    public void setAsc(int stype) {
        if (stype == NAME_ASC) {
            Collections.sort(data, nameAsc);
            this.notifyDataSetChanged();
        } else if (stype == MENU_ASC) {
            Log.d("menuASC", "OK");
            Collections.sort(data, menuAsc);
            this.notifyDataSetChanged();
        }
    }
}
