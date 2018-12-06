package com.example.death.walkrenger;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class group extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton add_button;
    LinearLayout tab_background;
    ListView groupListView;
    ArrayList<group_class> groupList = new ArrayList<>();
    TextView tabToAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        add_button = (FloatingActionButton) findViewById(R.id.fab);
        tab_background = (LinearLayout) findViewById(R.id.background);
        groupListView = (ListView) findViewById(R.id.listView);
        tabToAdd = (TextView) findViewById(R.id.Text);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        if(!UserInfoThisSession.getGroupList().isEmpty()) {
            tabToAdd.setVisibility(View.INVISIBLE);
            tabToAdd.setEnabled(false);
            tab_background.setEnabled(false);
        }
        CustomAdapter adapter = new CustomAdapter(group.this, UserInfoThisSession.getGroupList());
        groupListView.setAdapter(adapter);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        clickGroup();
        clickAdd_button();
        clickTab_bg();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent gotogroup = new Intent(group.this,Mainpage.class);
            startActivity(gotogroup);
            finish();
        } else if (id == R.id.nav_profile) {
            Intent gotogroup = new Intent(group.this,profile.class);
            startActivity(gotogroup);
            finish();
        } else if (id == R.id.nav_group) {
            startActivity(getIntent());
            finish();
        } else if (id == R.id.nav_leaderboard) {
            Intent gotogroup = new Intent(group.this,leaderboard.class);
            startActivity(gotogroup);
            finish();
        } else if (id == R.id.nav_mywalk) {
            Intent gotogroup = new Intent(group.this,mywalk.class);
            startActivity(gotogroup);
            finish();
        } else if (id == R.id.nav_goodplace) {
            Intent gotogroup = new Intent(group.this,goodplace.class);
            startActivity(gotogroup);
            finish();
        } else if (id == R.id.nav_Challenge) {
            Intent gotogroup = new Intent(group.this,challenge.class);
            startActivity(gotogroup);
            finish();
        } else if (id == R.id.nav_setting) {
            Intent gotogroup = new Intent(group.this,setting.class);
            startActivity(gotogroup);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void clickAdd_button() {
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog join_create_dialog = new Dialog(group.this);
                join_create_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                join_create_dialog.setContentView(R.layout.group_dialog);
                join_create_dialog.setCancelable(true);

                Button createButton = (Button) join_create_dialog.findViewById(R.id.create_button_group);
                Button joinButton = (Button) join_create_dialog.findViewById(R.id.join_button_group);

                createButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        join_create_dialog.dismiss();
                        clickCreate();
                    }
                });

                joinButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        join_create_dialog.dismiss();
                        clickJoin();
                    }
                });

                join_create_dialog.show();
            }
        });
    }

    public void clickTab_bg() {
        tab_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog join_create_dialog = new Dialog(group.this);
                join_create_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                join_create_dialog.setContentView(R.layout.group_dialog);
                join_create_dialog.setCancelable(true);

                Button createButton = (Button) join_create_dialog.findViewById(R.id.create_button_group);
                Button joinButton = (Button) join_create_dialog.findViewById(R.id.join_button_group);

                createButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        join_create_dialog.dismiss();
                        clickCreate();
                    }
                });

                joinButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        join_create_dialog.dismiss();
                        clickJoin();
                    }
                });

                join_create_dialog.show();
            }
        });
    }

    public void clickCreate() {
        final Dialog create_dialog = new Dialog(group.this);
        create_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        create_dialog.setContentView(R.layout.group_dialog_create);
        create_dialog.setCancelable(true);

        final EditText groupName = (EditText) create_dialog.findViewById(R.id.group_name);
        final EditText groupTag = (EditText) create_dialog.findViewById(R.id.group_tag);
        Button create = (Button) create_dialog.findViewById(R.id.group_create_create);
        Button cancel = (Button) create_dialog.findViewById(R.id.group_create_cancel);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (groupName.getText().toString() != null && groupTag.getText().toString() != null) {
                    if (groupName.getText().toString().length() >= 3) {
                        if (groupTag.getText().toString().length() >= 2) {
                            if (groupName.getText().toString().matches(".*[a-zA-Z]+.*")) {
                                if (groupTag.getText().toString().matches(".*[a-zA-Z]+.*")) {
                                    //??????????
                                    //???????
                                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                                    UserInfoThisSession.addGroupNameByName(groupName.getText().toString());
                                    UserInfoThisSession.addGroupByName(groupName.getText().toString(),groupTag.getText().toString());
                                    UserInfoThisSession.setRecentGroup(groupName.getText().toString());
                                    create_dialog.dismiss();
                                    Intent gotogroup = new Intent(group.this,group_profile.class);
                                    startActivity(gotogroup);
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Group tag need at least one alphabet.", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Group name need at least one alphabet.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Group tag need 2-4 characters.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Group name need 3-16 characters", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create_dialog.dismiss();
            }
        });

        create_dialog.show();

    }

    public void clickJoin() {
        final Dialog join_dialog = new Dialog(group.this);
        join_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        join_dialog.setContentView(R.layout.group_dialog_join);
        join_dialog.setCancelable(true);

        final Spinner drop_down = (Spinner) join_dialog.findViewById(R.id.group_dialog_join_choose);
        final EditText groupJoin = (EditText) join_dialog.findViewById(R.id.group_name_or_code);
        Button join = (Button) join_dialog.findViewById(R.id.group_join_join);
        Button cancel = (Button) join_dialog.findViewById(R.id.group_join_cancel);

        final String[] joinBy = {"Group name", "Group code"};
        int joinByOption = 0;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(group.this,android.R.layout.simple_spinner_dropdown_item,joinBy);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drop_down.setAdapter(adapter);
        drop_down.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.v("item", (String) parent.getItemAtPosition(0));
            }
        });

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(drop_down.getSelectedItem()) == joinBy[0]) {
                    //group name to server
                    join_dialog.dismiss();
                }
                else if(String.valueOf(drop_down.getSelectedItem()) == joinBy[1]) {
                    //group code to server
                    join_dialog.dismiss();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                join_dialog.dismiss();
            }
        });

        join_dialog.show();
    }

    public void clickGroup() {
        groupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserInfoThisSession.setRecentGroup(UserInfoThisSession.getGroupsName().get(position));
                Intent gotogroup = new Intent(group.this,group_profile.class);
                startActivity(gotogroup);
                finish();
            }
        });
    }
}
