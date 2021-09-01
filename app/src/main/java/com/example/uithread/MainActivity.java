package com.example.uithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG=MainActivity.class.getSimpleName();

    private Button buttonStart, buttonStop;

    private boolean mStopLoop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,"Thread id: "+Thread.currentThread().getId() );

        buttonStart = (Button)findViewById(R.id.button_start);
        buttonStop = (Button)findViewById(R.id.button_stop);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_start:
                mStopLoop=true;


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (mStopLoop){

                            Log.i(TAG,"Thread id in While loop: "+Thread.currentThread().getId() );

                        }

                    }
                }).start();

                break;

            case R.id.button_stop: mStopLoop=false;
            break;
        }
    }
}