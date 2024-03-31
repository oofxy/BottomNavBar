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

public class Triangle extends AppCompatActivity {
    EditText tbBase, tbHeight;
    TextView tvResultTriangle;
    Button btnCountTriangle, btnBack;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangle);

        tbBase = findViewById(R.id.tbBase);
        tbHeight = findViewById(R.id.tbHeight);
        tvResultTriangle = findViewById(R.id.tvResultTriangle);
        btnCountTriangle = findViewById(R.id.btnCountTriangle);
        btnBack = findViewById(R.id.btnBackTriangle);
        img = findViewById(R.id.imgTriangle);

        Glide.with(this)
                        .load("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Regular_triangle.svg/1200px-Regular_triangle.svg.png")
                                .into(img);

        btnCountTriangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aString = tbBase.getText().toString();
                String tString = tbHeight.getText().toString();

                if (aString.isEmpty() || tString.isEmpty()){
                    Toast.makeText(Triangle.this,"Jangan kosongkan editText!",Toast.LENGTH_LONG).show();

                } else {
                    double a = Double.parseDouble(aString);
                    double t = Double.parseDouble(tString);
                    double hasil = (a*t)/2;
                    tvResultTriangle.setText(String.valueOf(hasil));
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
