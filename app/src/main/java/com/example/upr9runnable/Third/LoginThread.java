package com.example.upr9runnable.Third;

public class LoginThread extends Thread implements FinishListener{

    private Boolean firstResult=null;
    private Boolean secondResult=null;
    private FinishListener listener;
    public LoginThread(FinishListener listener1) {
        this.listener=listener1;
    }
    @Override
    public void run() {
        super.run();
        final ImageDownload imageDownload=new ImageDownload(this);
        final Login login=new Login(this);
        Thread thread1 = new Thread(imageDownload);
        Thread thread2 = new Thread(login);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
           /* if(imageResult&&loginResult)
            {
                thirdActivity.this.uiChange("Success!!!");
            }
            else {
                thirdActivity.this.uiChange("Fail!!!");
            }*/
               listener.finishResult(firstResult&&secondResult);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void finishResult(boolean result) {
            if(firstResult==null)
            {
                firstResult=result;
            }
            else {
                secondResult=result;
            }
    }
}

