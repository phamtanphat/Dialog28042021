package com.example.dialog28042021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mBtnAlertDialog;
    int mIndex = -1;
    String mResult = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAlertDialog = findViewById(R.id.buttonAlertDialog);

        String ten = "Pham Tan Phat";

        Log.d("BBB",ten.substring(5,ten.length()));

        mBtnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResult = "";
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Chọn món ăn chính");

                builder.setIcon(R.mipmap.ic_launcher);
                builder.setCancelable(false);

                // Multiple choice
                String[] foodNames = {"Mỳ ý", "Pizza", "Gà rán", "Thịt nướng"};
                boolean[] arrChecked = {false , false , false ,false};

                builder.setMultiChoiceItems(foodNames, arrChecked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                    }
                });
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for (int j = 0; j < arrChecked.length ; j++) {
                            if (arrChecked[j]){
                                mResult += foodNames[j] +  " ,";
                            }
                        }

                        if (mResult.isEmpty()){
                            Toast.makeText(MainActivity.this, "Người dùng chưa chọn món", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Bạn đã chọn món " + mResult.substring(0,mResult.length() - 2), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                builder.show();
            }
        });
    }
}