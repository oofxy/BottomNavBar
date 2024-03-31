package com.example.bottomnavbar.KalkulatorBangunRuang;

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
import com.example.bottomnavbar.R;

public class Cone extends AppCompatActivity {
    EditText tbRadius, tbGenerator;
    TextView tvResult;
    Button btnCount, btnBack;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cone);

        tbRadius = findViewById(R.id.tbRadius);
        tbGenerator = findViewById(R.id.tbGenerator);
        tvResult = findViewById(R.id.tvResultCone);
        btnCount = findViewById(R.id.btnCountCone);
        btnBack = findViewById(R.id.btnBackCone);
        img = findViewById(R.id.imgCone);

        Glide.with(this)
                        .load("https://core-ruangguru.s3.amazonaws.com/assets/ruang_belajar/questions/q_g7u1vl4857.png")
                                .into(img);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rString = tbRadius.getText().toString();
                String sString = tbGenerator.getText().toString();

                if (rString.isEmpty() || sString.isEmpty()){
                    Toast.makeText(Cone.this,"Jangan kosongkan editText!",Toast.LENGTH_LONG).show();
                } else {
                    double r = Double.parseDouble(rString);
                    double s = Double.parseDouble(sString);

                    double hasil = 3.14 * r * (s+r);
                    tvResult.setText(String.valueOf(hasil));
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
