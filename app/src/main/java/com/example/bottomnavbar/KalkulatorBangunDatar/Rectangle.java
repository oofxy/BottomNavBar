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

public class Rectangle extends AppCompatActivity {
    EditText tbPanjang, tbLebar;
    Button btnCountRectngle;
    TextView tvResultRectangle, btnBack;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rectangle);

        tbPanjang = findViewById(R.id.tbPanjang);
        tbLebar = findViewById(R.id.tbLebar);
        btnCountRectngle = findViewById(R.id.btnCountRectngle);
        tvResultRectangle = findViewById(R.id.tvResultRectangle);
        btnBack = findViewById(R.id.btnBackRectangle);
        img = findViewById(R.id.imgRectangle);

        Glide.with(this)
                        .load("https://images.vexels.com/media/users/3/139257/isolated/preview/b8fa8f291632f8fe68842e4fb100d8e0-square-rectangle-shape.png")
                                .into(img);

        btnCountRectngle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  pString = tbPanjang.getText().toString();
                String  lString = tbLebar.getText().toString();

                if (pString.isEmpty() || lString.isEmpty()){
                    Toast.makeText(Rectangle.this,"Jangan kosongkan editText!",Toast.LENGTH_LONG).show();
                } else {
                    double p = Double.parseDouble(pString);
                    double l = Double.parseDouble(lString);

                    if (p>l){
                        double hasil = p*l;
                        tvResultRectangle.setText(String.valueOf(hasil));
                    } else {
                        Toast.makeText(Rectangle.this,"Nilai dari panjang tidak boleh lebih kecil dari pada lebar!", Toast.LENGTH_LONG).show();
                    }
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
