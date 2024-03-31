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
/*
        modelBangunDatar.add(new Model("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAGFBMVEX///8AAABQUFBNTU1TU1NjY2MXFxfu7u4stZ7VAAABdklEQVR4nO3du20EMRQEQe19pPwzlie/DeoGi6oABmyA/vv6AgAAAAAAAAAA4J5+3s/Hguf751Dh+1rxPlT4/HTYn+ehwsd1fb8+/UUfr+/repwrfB2aLl5HC09NFwefofCfKNycLhRuThcKN6cLhZvThcLN6ULh5nShcHO6ULg5XSjcnC4Ubk4XCjenC4Wb04XCzelC4eZ0oXBzulC4OV0o3JwuFG5OFwo3pwuFm9OFws3pQuHmdKFwc7pQuDldKNycLhRuThcKN6cLhZvThcLN6ULh5nShcHO6ULg5XSjcnC4Ubk4XCjenC4Wb04XCzelC4eZ0oXBzulC4OV0o3JwuFG5OFwo3pwuFm9OFws3pQuHmdKFwc7pQuDldKNycLhRuThcKN6cLhZvThcLN6ULh5nShcHO6ULg5XSjcnC4Ubk4XCjenC4Wb04XCzelC4eZ0oXBzujhbeP8blje/Q3r/W7L3vwd8/5vOAAAAAAAAAAAAfNovofQM/S+mDJYAAAAASUVORK5CYII=",
                "Square"));

        modelBangunDatar.add(new Model("https://cdn.hinative.com/attached_images/227294/6dc8f7299914e3487a9cc6b03d96d28c4bd41fc4/large.jpg?1515275179",
                "Rectangle"));

        modelBangunDatar.add(new Model("https://i.pinimg.com/736x/e8/b1/6f/e8b16fedd714bad03028e982735585bd.jpg",
                "Circle"));

        modelBangunDatar.add(new Model("https://prattandlarson.com/wp-content/uploads/2020/12/PF-ETR6.jpg",
                "Triangle"));



        modelBangunRuang.add(new Model("https://vt-vtwa-assets.varsitytutors.com/vt-vtwa/uploads/problem_question_image/image/1346/Cube__PSF_.png",
                "Cube"));

        modelBangunRuang.add(new Model("https://i.pinimg.com/736x/6f/e1/3e/6fe13e1883f40e66b166ad1645d24507.jpg",
                "Pyramid"));

        modelBangunRuang.add(new Model("https://cdn.mathblog.com/wp-content/uploads/2017/03/conebnw-300x300.jpeg",
                "Cone"));

        modelBangunRuang.add(new Model("https://study.com/cimages/multimages/16/imagecylinder.png",
                "Cylinder"));*/



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