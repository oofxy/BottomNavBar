package com.example.bottomnavbar.KalkulatorBangunRuang;

import android.os.Bundle;
import android.provider.MediaStore;
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

public class Cube extends AppCompatActivity {
    EditText tbSide;
    TextView tvResultcube;
    Button btnCountCube, btnBack;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cube);

        tbSide = findViewById(R.id.tbSide);
        tvResultcube = findViewById(R.id.tvResultCube);
        btnCountCube = findViewById(R.id.btnCountCube);
        btnBack = findViewById(R.id.btnBackCube);
        img = findViewById(R.id.imgCube);

        Glide.with(this)
                        .load("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Necker_cube.svg/1200px-Necker_cube.svg.png")
                                .into(img);

        btnCountCube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sString =tbSide.getText().toString();

                if (sString.isEmpty()){
                    Toast.makeText(Cube.this,"Jangan kosongkan editText!",Toast.LENGTH_LONG).show();
                } else{
                    double s = Double.parseDouble(sString);
                    double hasil = (s * s) * 6;
                    tvResultcube.setText(String.valueOf(hasil));
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
