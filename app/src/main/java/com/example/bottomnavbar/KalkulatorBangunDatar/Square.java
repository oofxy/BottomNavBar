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
import com.example.bottomnavbar.KalkulatorBangunRuang.Cube;
import com.example.bottomnavbar.R;

public class Square extends AppCompatActivity {
    EditText tbSisiRuang;
    Button btnHitung;
    TextView tvHasil, btnBack;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.square);

        tbSisiRuang = findViewById(R.id.tbSisi);
        btnHitung = findViewById(R.id.btnHitung);
        tvHasil = findViewById(R.id.tvHasil);
        btnBack = findViewById(R.id.btnBackSquare);
        img = findViewById(R.id.imgSquare);

        Glide.with(this)
                        .load("https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Square_-_black_simple.svg/2048px-Square_-_black_simple.svg.png")
                                .into(img);

        btnHitung.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String sString =tbSisiRuang.getText().toString();

                if (sString.isEmpty()){
                    Toast.makeText(Square.this,"Jangan kosongkan editText!",Toast.LENGTH_LONG).show();
                } else{
                    double s = Double.parseDouble(sString);
                    double hasil = s*s;
                    tvHasil.setText(String.valueOf(hasil));
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
