package com.example.dialog28042021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mBtnAlertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAlertDialog = findViewById(R.id.buttonAlertDialog);

        mBtnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Ứng dụng có phiên bản mới");
                builder.setMessage("Bạn có muốn nâng cấp ứng dụng hay không?");
                builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Bắt đầu cập nhật", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Không cập nhật", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Chưa xác định", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }
}