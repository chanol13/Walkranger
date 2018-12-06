package com.example.death.walkrenger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter{
    ArrayList<String> nameList;
    Context context;
    ArrayList<Integer> imageId;
    int layout,img,text;

    private static LayoutInflater inflater=null;
    public CustomAdapter(Context context, ArrayList<group_class> list) {
        // TODO Auto-generated constructor stub
        layout = R.layout.listview_group_page;
        text = R.id.group_list_name;
        img = R.id.group_list_image;
        nameList = new ArrayList<>();
        imageId = new ArrayList<>();
        for(group_class group : list) {
            this.nameList.add(group.getGroup_name());
        }
        this.context = context;
        for(group_class group : list) {
            this.imageId.add(group.getGroup_emblem());
        }
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public CustomAdapter(Context context, ArrayList<user_class> list, String listType) {
        // TODO Auto-generated constructor stub
        if(listType.matches("request")) {
            layout = R.layout.listview_group_request;
            text = R.id.group_list_request_name;
            img = R.id.group_list_request_image;
        } else {
            layout = R.layout.listview_group_invite;
            text = R.id.group_list_invite_name;
            img = R.id.group_list_invite_image;
        }
        nameList = new ArrayList<>();
        imageId = new ArrayList<>();
        for(user_class group : list) {
            this.nameList.add(group.getUser_name());
        }
        this.context = context;
        for(user_class group : list) {
            this.imageId.add(group.getProfilePic());
        }
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return nameList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        TextView name;
        ImageView emblem;
        final View rowView;

        rowView = inflater.inflate(layout, null);

        if(layout == R.layout.listview_group_request) {
            Button decline = (Button) rowView.findViewById(R.id.group_list_request_decline);
            Button accept = (Button) rowView.findViewById(R.id.group_list_request_accept);

            accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Accepted", Toast.LENGTH_SHORT).show();
                    UserInfoThisSession.delUserRByPosition(position);
                }
            });

            decline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Declined", Toast.LENGTH_SHORT).show();
                    UserInfoThisSession.delUserRByPosition(position);
                }
            });
        }

        name = (TextView) rowView.findViewById(text);
        emblem = (ImageView) rowView.findViewById(img);

        name.setText(nameList.get(position));
        emblem.setImageResource(imageId.get(position));

        return rowView;
    }


}