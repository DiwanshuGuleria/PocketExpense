package com.example.sidharth.pocketexpensemanager.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sidharth.pocketexpensemanager.R;
import com.example.sidharth.pocketexpensemanager.data.Category_Data;

import java.util.ArrayList;

/**
 * Created by root on 25/3/17.
 */

public class Category_Adapter extends ArrayAdapter<Category_Data> {
    int groupId;
    Activity context;
    ArrayList<Category_Data> list;
    LayoutInflater inflater;
    public Category_Adapter(Activity context, int groupId, int id, ArrayList<Category_Data> list){
        super(context,id,list);
        this.list=list;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupId=groupId;

    }
    public View getView(int position, View convertView, ViewGroup parent){
        View itemView=inflater.inflate(groupId,parent,false);
        ImageView cat_image=(ImageView)itemView.findViewById(R.id.category_image);
        cat_image.setImageResource(list.get(position).getImage());
        TextView category_name = (TextView)itemView.findViewById(R.id.category);
        category_name.setText(list.get(position).getText());
        return itemView;
    }
    public View getDropDownView(int position,View convertView,ViewGroup parent){
        return getView(position,convertView,parent);
    }
}
