package com.example.bottomnavbar.KalkulatorBangunDatar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.bottomnavbar.KalkulatorBangunRuang.Block;
import com.example.bottomnavbar.R;

public class Circle extends AppCompatActivity {
    EditText tbDiameter;
    Button btnCountCircle;
    TextView tvResultCircle, btnBack;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle);

        tbDiameter = findViewById(R.id.tbDiameter);
        btnCountCircle = findViewById(R.id.btnCountCircle);
        tvResultCircle = findViewById(R.id.tvResultCircle);
        btnBack = findViewById(R.id.btnBackCircle);
        img = findViewById(R.id.imgCircle);

        Glide.with(this)
                        .load("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Circle_%28transparent%29.png/800px-Circle_%28transparent%29.png")
                                .into(img);


        btnCountCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dString = tbDiameter.getText().toString();

                if (dString.isEmpty()){
                    Toast.makeText(Circle.this,"Jangan kosongkan editText!",Toast.LENGTH_LONG).show();
                } else {

                    double d = Double.parseDouble(dString);
                    double hasil = d * 3.14;

                    tvResultCircle.setText(String.valueOf(hasil));
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
