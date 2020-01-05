package com.example.cook_able;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //using a thread and halt screen for 2 seconds.
        SharedPreferences sharedPreferences = getSharedPreferences("User",MODE_PRIVATE);
        String Username= sharedPreferences.getString("username" ,"");
        String Password =sharedPreferences.getString("Password","");

        if (Username.equals("admin") && Password.equals("admin")){
            Toast.makeText(SplashScreenActivity.this, "Succesfull",Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(SplashScreenActivity.this, MainActivity.class );
            startActivity(intent);

        }
        else {

            //Toast.makeText(SplashScreenActivity.this, "Succesfull",Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreenActivity.this,LoginActivity.     class);
                    startActivity(intent);
                    finish();
                }
            },2000);
        }

    }


}


