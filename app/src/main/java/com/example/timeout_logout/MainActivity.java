package com.example.timeout_logout;
import android.content.Intent;

import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer;
    private Timer timer2;
    private Toolbar toolbar;

    TextView t_inter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        t_inter = findViewById(R.id.txt_inter);



    }

    @Override
    protected void onPause() {
        super.onPause();

//        timer2 = new Timer();
//        Log.i("Main", "Invoking logout timer");
//        LogOutTimerTask logoutTimeTask = new LogOutTimerTask();
//        //timer.schedule(logoutTimeTask, 5*60*1000); //auto logout in 5 minutes
//
//        timer2.schedule(logoutTimeTask, 5000); // 5 sec
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();

//        if (timer2 != null) {
//            timer2.cancel();
//            timer2 = null;
//        }

        t_inter.setText("Stai interagendo!");

        if (timer != null) {
            timer.cancel();
            Log.i("Main", "cancel timer");
            timer = null;
        }

        timer = new Timer();
        Log.i("Main", "Invoking logout timer");
        LogOutTimerTask logoutTimeTask = new LogOutTimerTask();
        timer.schedule(logoutTimeTask, 5000); // 5 sec

    }







    @Override
    protected void onResume() {
        super.onResume();
//        if (timer2 != null) {
//            timer2.cancel();
//            Log.i("Main", "cancel timer");
//            timer2 = null;
//        }

    }

    private class LogOutTimerTask extends TimerTask {

        @Override
        public void run() {

            //redirect user to login screen
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            //finish();
            System.exit(0);
        }
    }
}