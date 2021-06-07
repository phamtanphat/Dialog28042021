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
    int mIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAlertDialog = findViewById(R.id.buttonAlertDialog);

        mBtnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Chọn món ăn chính");

                builder.setIcon(R.mipmap.ic_launcher);
                builder.setCancelable(false);

                // Single choice
                String[] foodNames = {"Mỳ ý", "Pizza", "Gà rán", "Thịt nướng"};

                builder.setSingleChoiceItems(foodNames, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mIndex = i;
                    }
                });
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (mIndex == -1){
                            Toast.makeText(MainActivity.this, "Người dùng chưa chọn món", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Bạn chọn " + foodNames[mIndex], Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                builder.show();
            }
        });
    }
}