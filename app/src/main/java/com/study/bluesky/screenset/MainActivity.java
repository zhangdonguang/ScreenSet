package com.study.bluesky.screenset;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="MainActivity";
    private Button screenConvertbutton;
    private Button quitbutton;
    private TextView infoTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO info
        infoTextView=findViewById(R.id.info);
        //TODO button listen
        screenConvertbutton=(Button) findViewById(R.id.screenconvert);
        screenConvertbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i(TAG,"screenConvertbutton click");

                    }
                }
        );
    quitbutton=(Button) findViewById(R.id.quit);
    quitbutton.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i(TAG,"quitbutton click");
                }
            }
    );
    SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String time=format.format(new Date()) ;
    Log.i(TAG,"onCreate"+time);
    infoTextView.setText("onCreate"+time);
    }
    //改变横竖屏切换的方法
    public void changeScreen(View view)
    {
        /**
         * int ORIENTATION_PORTRAIT = 1;  竖屏
         * int ORIENTATION_LANDSCAPE = 2; 横屏
         */
        //获取屏幕的方向  ,数值1表示竖屏，数值2表示横屏
        int screenNum = getResources().getConfiguration().orientation;
        //（如果竖屏）设置屏幕为横屏
        if(screenNum==1)
        {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }else
        {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            infoTextView.append("\n 当前屏幕为横屏");
        } else {
            infoTextView.append("\n 当前屏幕为竖屏");
        }
        super.onConfigurationChanged(newConfig);
        Log.i(TAG,"onConfigurationChanged");
    }

    @Override
    protected void onStart() {
        super.onStart();
        infoTextView.append("\n onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        infoTextView.append("\n onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        infoTextView.append("\n onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        infoTextView.append("\n onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        infoTextView.append("\n onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        infoTextView.append("\n onDestroy");
    }

}
