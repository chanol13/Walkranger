package com.example.death.walkrenger;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class group_member extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_member);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        for(int i = 0; i < 5; i++) {
            UserInfoThisSession.addUserRByName("usertestR" + (i + 1));
        }
        for(int i = 0; i < 3; i++) {
            UserInfoThisSession.addUserIByName("usertestI" + (i + 1));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.null_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.group_add_member:
                final Dialog invite_request_dialog = new Dialog(group_member.this);
                invite_request_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                invite_request_dialog.setContentView(R.layout.group_member_add_request);
                invite_request_dialog.setCancelable(true);

                final LinearLayout requestTab = (LinearLayout) invite_request_dialog.findViewById(R.id.request_tab);
                final LinearLayout inviteTab = (LinearLayout) invite_request_dialog.findViewById(R.id.invite_tab);
                final FrameLayout tabToInvite = (FrameLayout) invite_request_dialog.findViewById(R.id.tab_to_invite);
                final TextView textInvite = (TextView) invite_request_dialog.findViewById(R.id.textView10);
                final ListView listPending = (ListView) invite_request_dialog.findViewById(R.id.pending_list);

                tabToInvite.setEnabled(false);
                textInvite.setVisibility(View.INVISIBLE);

                final CustomAdapter[] adapter = {new CustomAdapter(group_member.this, UserInfoThisSession.getDummyRUsers(), "request")};
                listPending.setAdapter(adapter[0]);

                requestTab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(((ColorDrawable) requestTab.getBackground()).getColor() == Color.parseColor("#000cb1")) {
                            adapter[0] = new CustomAdapter(group_member.this, UserInfoThisSession.getDummyRUsers(), "request");
                            listPending.setAdapter(adapter[0]);

                            tabToInvite.setEnabled(false);
                            textInvite.setVisibility(View.INVISIBLE);

                            requestTab.setBackgroundColor(Color.parseColor("#3d40ff"));
                            inviteTab.setBackgroundColor(Color.parseColor("#000cb1"));


                        }
                    }
                });

                inviteTab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(((ColorDrawable) inviteTab.getBackground()).getColor() == Color.parseColor("#000cb1")) {
                            adapter[0] = new CustomAdapter(group_member.this, UserInfoThisSession.getDummyIUsers(), "invite");
                            listPending.setAdapter(adapter[0]);

                            tabToInvite.setEnabled(true);
                            textInvite.setVisibility(View.VISIBLE);
                            if(!UserInfoThisSession.getDummyIUsers().isEmpty()) {
                                textInvite.setEnabled(false);
                            }

                            inviteTab.setBackgroundColor(Color.parseColor("#3d40ff"));
                            requestTab.setBackgroundColor(Color.parseColor("#000cb1"));
                        }
                    }
                });

                invite_request_dialog.show();

                return true;
            default:
                finish();
                return super.onOptionsItemSelected(item);
        }
    }

}
