package com.example.lr7_jo_android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private Bitmap loadImageFromNetwork(String url){
        try{
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(url).getContent());
            return bitmap;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void btnClick(View view){
        Thread threadExample = new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bmp = loadImageFromNetwork("https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwjCzMq9kLTiAhWS3eAKHW3jDMsQjRx6BAgBEAU&url=https%3A%2F%2Fwww.linkedin.com%2Fcompany%2Fyandex&psig=AOvVaw1zM1CtOXwHFe65EH7vzV36&ust=1558785983157740");
                final ImageView imgView = (ImageView)findViewById(R.id.imgView);
                imgView.post(new Runnable() {
                    @Override
                    public void run() {
                        imgView.setImageBitmap(bmp);
                    }
                });
            }
        });
        threadExample.start();
    }


}
