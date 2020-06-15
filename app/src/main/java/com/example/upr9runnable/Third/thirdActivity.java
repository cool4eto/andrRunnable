package com.example.upr9runnable.Third;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.upr9runnable.R;

public class thirdActivity extends AppCompatActivity implements FinishListener {
    private Button button;
    private TextView textView;
    /*private Boolean imageResult=null;
    private Boolean loginResult=null;*/
    private Boolean finishResult=null;
    private  ProgressFragment progressFragment=new ProgressFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        button = findViewById(R.id.button6);
        textView = findViewById(R.id.textView3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressFragment = ProgressFragment.newInstance(1);
                progressFragment.show(getSupportFragmentManager(), "Dialog");
               /* final ImageDownload imageDownload=new ImageDownload(thirdActivity.this);
                final Login login=new Login(thirdActivity.this);*/
              /*  final Handler handler=new Handler();
               // handler.post(new LoginThread(thirdActivity.this));
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        handler.post(new LoginThread(thirdActivity.this));
                    }
                }.start();*/

                new Thread() {
                    @Override
                    public void run() {
                       runOnUiThread(new LoginThread(thirdActivity.this));
                    }
                }.start();
            }
        });
    }



    @Override
    public void finishResult(boolean result) {
            uiChange(result?"Success!!!":"Fail!!!");
    }
    public void uiChange(String text1)
    {
        textView.setText(text1);
        progressFragment.dismiss();
    }

}
