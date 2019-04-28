package com.example.cdttwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    Context context;
    ArrayList<list_item> list_itemArrayList;
    ImageView list_image;
    TextView list_title;
    TextView list_place;
    TextView list_content;


    public MyListAdapter(Context context, ArrayList<list_item> list_itemArrayList) {
        this.context = context;
        this.list_itemArrayList = list_itemArrayList;
    }

    @Override
    public int getCount() {
        return this.list_itemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return list_itemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
            //item을 컨버트 뷰를 통해 연결
            list_image = (ImageView) convertView.findViewById(R.id.list_imageview);
            list_title =(TextView)convertView.findViewById(R.id.list_title);
            list_content = (TextView)convertView.findViewById(R.id.list_content);
            list_place = (TextView)convertView.findViewById(R.id.list_place);

        }
        // 연결된 변수 값을 입력값으로 연결
        list_title.setText(list_itemArrayList.get(position).getList_title());
        list_place.setText(list_itemArrayList.get(position).getList_place());
        list_content.setText(list_itemArrayList.get(position).getList_content());
        list_image.setImageResource(list_itemArrayList.get(position).getList_img());

        return convertView;
    }




}
