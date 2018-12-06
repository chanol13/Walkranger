package com.example.death.walkrenger;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class group_profile extends AppCompatActivity {

    ImageButton member;
    ImageButton challenge;
    ImageButton groupStatistic;
    ImageView editAnnouce;
    TextView groupName;
    TextView groupTag;
    TextView announcement;
    ImageView groupEmblem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Drawable backArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        backArrow.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(backArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);

        groupName = (TextView) findViewById(R.id.group_profile_name);
        groupEmblem = (ImageView) findViewById(R.id.group_profile_picture);
        groupTag = (TextView) findViewById(R.id.group_profile_code);
        member = (ImageButton) findViewById(R.id.group_profile_member);
        challenge = (ImageButton) findViewById(R.id.group_profile_challenge);
        groupStatistic = (ImageButton) findViewById(R.id.group_profile_statistic);
        editAnnouce = (ImageView) findViewById(R.id.group_profile_edit_announcement);
        announcement = (TextView) findViewById(R.id.group_profile_annoucement);

        //request group from server
        for(group_class groups : UserInfoThisSession.groupList) {
            if(groups.getGroup_name().matches(UserInfoThisSession.getRecentGroup())) {
                groupName.setText(groups.getGroup_name());
                groupTag.setText(groups.getGroup_name_short() + "  " + groups.getGroup_code());
                groupEmblem.setImageResource(groups.getGroup_emblem());
            }
        }

        clickMember();
        clickChallenge();
        clickStatistic();
        clickEditAnnouncement();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.group_profile_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting_group :

                return true;
            case R.id.leave_group :

                return true;
            default:Intent intent = new Intent(group_profile.this, group.class);
                startActivity(intent);
                finish();
                return super.onOptionsItemSelected(item);
        }
    }

    public void clickMember() {
        member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotogroup = new Intent(group_profile.this,group_member.class);
                startActivity(gotogroup);
            }
        });
    }

    public void clickChallenge() {
        challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //?????? challenge
                Toast.makeText(getApplicationContext(), "Challenge", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clickStatistic() {
        groupStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //?????? statistic ?? group
                Toast.makeText(getApplicationContext(), "Group Statistic", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clickEditAnnouncement() {
        editAnnouce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog editAnnouncement_dialog = new Dialog(group_profile.this);
                editAnnouncement_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                editAnnouncement_dialog.setContentView(R.layout.group_profile_dialog_announcement);
                editAnnouncement_dialog.setCancelable(true);

                final EditText newAnnouncement = (EditText) editAnnouncement_dialog.findViewById(R.id.group_profile_new_announcement);
                Button change = (Button) editAnnouncement_dialog.findViewById(R.id.group_profile_announcement_ok);
                Button cancel = (Button) editAnnouncement_dialog.findViewById(R.id.group_profile_announcement_cancle);

                change.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                        announcement.setText(newAnnouncement.getText().toString());
                        editAnnouncement_dialog.dismiss();
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editAnnouncement_dialog.dismiss();
                    }
                });
                editAnnouncement_dialog.show();
            }
        });
    }
}
