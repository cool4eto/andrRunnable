package com.example.upr9runnable.First;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.upr9runnable.R;

public class firstActivity extends AppCompatActivity implements  LoginFinishListener{

    private EditText editText;//email
    private EditText editText2;//password
    private Button button;
    private TextView textView;//result
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        button=findViewById(R.id.button4);
        textView=findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    public void login()
    {
        LoginTask loginTask=new LoginTask(editText.getText().toString(),editText2.getText().toString(),firstActivity.this);
        //taka ne raboti Only the original thread that created a view hierarchy can touch its views.
       /* Thread thread=new Thread(loginTask);
        thread.start();*/
       runOnUiThread(loginTask);
        /*Handler handler=new Handler();
        handler.postDelayed(loginTask,1000);*/
    }

    @Override
    public void result(boolean result) {
        if(result) {
            textView.setText("Login success!!!");
            textView.setTextColor(Color.GREEN);
        }
        else {
            textView.setText("Login Failed!!!");
            textView.setTextColor(Color.RED);
        }
    }
}
