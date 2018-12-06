package com.example.death.walkrenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Thread loadingpage = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    super.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent gotoNextPage = new Intent(Loading.this,Mainpage.class);
                    startActivity(gotoNextPage);
                    finish();
                }
            }
        };
        loadingpage.start();
    }
}
