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

public class Cylinder extends AppCompatActivity {
    EditText tbRadius, tbHeight;
    TextView tvResult;
    Button btnCount, btnBack;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cylinder);

        tbRadius = findViewById(R.id.tbRadiusCylinder);
        tbHeight = findViewById(R.id.tbHeightCylinder);
        tvResult = findViewById(R.id.tvResultCylinder);
        btnCount = findViewById(R.id.btnCountCylinder);
        btnBack = findViewById(R.id.btnBackCylinder);
        img = findViewById(R.id.imgCylinder);

        Glide.with(this)
                        .load("https://png.pngtree.com/png-vector/20220519/ourmid/pngtree-3d-cylinder-with-simple-lines-and-dots-geometric-shape-png-image_4706084.png")
                                .into(img);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rString = tbRadius.getText().toString();
                String tString = tbHeight.getText().toString();

                if (rString.isEmpty() || tString.isEmpty()){
                    Toast.makeText(Cylinder.this,"Jangan kosongkan editText!",Toast.LENGTH_LONG).show();
                } else {
                    double r = Double.parseDouble(rString);
                    double h = Double.parseDouble(tString);
                    double hasil = 2 * 3.14 * r * h + 2 * 3.14 * (r*r);

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
