package com.sha.mycart;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.sha.mycart.blur.blurbulider;

public class logoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo2);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blur);
        blurbulider blur=new blurbulider();

            blur.blur(getApplicationContext(),bitmap);

        imageView.setImageBitmap(bitmap);


    }
}
