package com.xykj.fgy.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
                                                     @Override
                                                     public void onClick(View v) {

                                                     }

                                                 }

        );
    }

    private void startDownLoad() {
        Toast.makeText(MainActivity.this, "正在下载中", Toast.LENGTH_SHORT).show();
        Intent service = new Intent(MainActivity.this, DownLoadService.class);
        service.putExtra("downloadurl", "http://www.51yi.org/app/Volunteer.apk");
        startService(service);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 0: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startDownLoad();
                } else {
                    Toast.makeText(MainActivity.this, "SD卡下载权限被拒绝", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}
