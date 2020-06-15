package com.example.upr9runnable.First;

import android.util.Log;
import android.util.Patterns;

import java.util.regex.Pattern;

public class LoginTask implements Runnable {
    LoginFinishListener listener;
    private String email;
    private String password;
    private Boolean validEmail=false;
    private Boolean validPassword=false;

    public LoginTask(String email, String password, LoginFinishListener listener1)  {
        this.email = email;
        this.password = password;
        this.listener=listener1;
    }

    public void run() {
        //tova ne raboti Only the original thread that created a view hierarchy can touch its views.
       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        validEmail=emailValidator();
        validPassword=passwordValidator();
        Log.d("EmailValidate", "value: " + validEmail);
        Log.d("PasswordValidate", "value: " + validPassword);
        if(validEmail&&validPassword)
        listener.result(true);
        else
            listener.result(false);
    }
    public boolean emailValidator()
    {
        return (!email.isEmpty()&& Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    public boolean passwordValidator()
    {
        return !password.isEmpty()&&Pattern.matches("..\\d..\\d[A-Z][!,@,#,$,%,&,*]..\\d..\\d[A-Z][!,@,#,$,%,&,*]",password);
        //return (!password.isEmpty()&&Pattern.compile("..\\d..\\d[A-Z][!,@,#,$,%,&,*]..\\d..\\d[A-Z][!,@,#,$,%,&,*]").matcher(password).matches());
    }


}
