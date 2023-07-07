package com.example.universitylist;

import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustamBaseAdaptor extends BaseAdapter {

    public Context context;
    String Countries[];
    int [] ListOfImages;
    LayoutInflater inflater;
    CustamBaseAdaptor(Context ctx,String[] countries , int[] images){

        this.context = ctx;
        this.Countries = countries;
        this.ListOfImages = images;
        inflater = LayoutInflater.from(ctx);


    }

    @Override
    public int getCount() {
        return Countries.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.list_view,null);
        TextView Text_view = (TextView)view.findViewById(R.id.text_view);
        ImageView Image_View = (ImageView)view.findViewById(R.id.image_view);
        Text_view.setText(Countries[i]);
        Image_View.setImageResource(ListOfImages[i]);

        return view;
    }
}
