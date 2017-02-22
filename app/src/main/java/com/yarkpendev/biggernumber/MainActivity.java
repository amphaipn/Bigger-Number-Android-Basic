package com.yarkpendev.biggernumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btnLeft, btnRight;
    private TextView txtPoint;
    private int PointNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRight);
        txtPoint = (TextView) findViewById(R.id.txtPoint);
        txtPoint.setText(PointNumber + "");
        createRandomNumber();
    }

    private void createRandomNumber() {
        int left, right;
        Random rd = new Random();
        left = rd.nextInt(9) + 1;
        do {
            right = rd.nextInt(9) + 1;
        }
        while (left == right);
        btnLeft.setText(String.valueOf(left));
        btnRight.setText(right + "");
    }

    //xu ly su kien ben trai
    public void OnclickLeftButton(View view) {
        int left, right;
        left = Integer.parseInt(btnLeft.getText().toString());
        right = Integer.parseInt(btnRight.getText().toString());
        if (left > right) {
            PointNumber++;
            Toast.makeText(this, "đúng", Toast.LENGTH_SHORT).show();
        } else {
            PointNumber--;
            Toast.makeText(this, "sai", Toast.LENGTH_SHORT).show();
        }
        txtPoint.setText(txtPoint + "");
        createRandomNumber();
    }

    public void OnclickRightButton(View view) {
        int left, right;
        left = Integer.parseInt(btnLeft.getText().toString());
        right = Integer.parseInt(btnRight.getText().toString());
        if (left < right) {
            PointNumber++;
            Toast.makeText(this, "Dung", Toast.LENGTH_SHORT).show();
        } else {
            PointNumber--;
            Toast.makeText(this, "Sai", Toast.LENGTH_SHORT).show();
        }
        txtPoint.setText(txtPoint + "");
        createRandomNumber();
    }

}
