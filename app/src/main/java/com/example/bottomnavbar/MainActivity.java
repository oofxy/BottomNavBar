package com.example.bottomnavbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.bottomnavbar.Fragments.BangunDatarFragment;
import com.example.bottomnavbar.Fragments.BangunRuangFragment;
import com.example.bottomnavbar.Fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    /*ArrayList<Model> modelBangunDatar = new ArrayList<>();
    ArrayList<Model> modelBangunRuang = new ArrayList<>();*/

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavBar);
        frameLayout = findViewById(R.id.frameLayout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.navBangunDatar){
                    loadFragment(new BangunDatarFragment(), false);

                } else if (itemId == R.id.navBangunRuang){
                    loadFragment(new BangunRuangFragment(), false);

                } else {
                    loadFragment(new ProfileFragment(), false);
                }

                return true;
            }
        });
        loadFragment(new BangunDatarFragment(), true);
    }
    private void loadFragment(Fragment fragment, boolean isAppInitialized){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized){
            fragmentTransaction.add(R.id.frameLayout, fragment);
        } else{
            fragmentTransaction.replace(R.id.frameLayout, fragment);
        }

        fragmentTransaction.commit();
    }

}