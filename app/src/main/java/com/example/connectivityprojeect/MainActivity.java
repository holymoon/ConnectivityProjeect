package com.example.connectivityprojeect;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result = findViewById(R.id.tv_result);
    }
    public void net_test(View view){
        ConnectivityManager manager =(ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        if(manager != null){
          android.net.NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
          if(activeNetwork != null){
              if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
                  tv_result.setText("Wifi");

              }else if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                  tv_result.setText("Mobile Data");
              }
          }else{
              tv_result.setText("No Internet");
          }
        }

    }
}
