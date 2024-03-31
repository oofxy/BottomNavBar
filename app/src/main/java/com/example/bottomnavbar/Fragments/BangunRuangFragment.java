package com.example.bottomnavbar.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bottomnavbar.BangunRuangAdapter;
import com.example.bottomnavbar.BangunRuangAdapter;
import com.example.bottomnavbar.KalkulatorBangunRuang.Block;
import com.example.bottomnavbar.KalkulatorBangunRuang.Cone;
import com.example.bottomnavbar.KalkulatorBangunRuang.Cube;
import com.example.bottomnavbar.KalkulatorBangunRuang.Cylinder;
import com.example.bottomnavbar.Model;
import com.example.bottomnavbar.R;

import java.util.ArrayList;

public class BangunRuangFragment extends Fragment implements BangunRuangAdapter.ItemClickListener {
    ArrayList<Model> modelBangunRuang = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_bangun_ruang, container, false);

        RecyclerView rvBangunRuang = rootView.findViewById(R.id.rvBangunRuang);

        modelBangunRuang.add(new Model("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Necker_cube.svg/1200px-Necker_cube.svg.png",
                "Cube"));

        modelBangunRuang.add(new Model("https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Cuboid_simple.svg/1200px-Cuboid_simple.svg.png",
                "Block"));

        modelBangunRuang.add(new Model("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShcN0wiYkmy5y56GXThnTxfiJpo1OHxVvtSw&usqp=CAU",
                "Cone"));

        modelBangunRuang.add(new Model("https://study.com/cimages/multimages/16/imagecylinder.png",
                "Cylinder"));

        rvBangunRuang.setLayoutManager(new LinearLayoutManager(getActivity()));
        BangunRuangAdapter adapter = new BangunRuangAdapter(getContext(), modelBangunRuang);
        adapter.setClickListener(this);
        rvBangunRuang.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onItemClick(View view, int position) {
        // Handle item clicks here
        String option = modelBangunRuang.get(position).getNama();

        if ("Cube".equals(option)){
            startActivity(new Intent(getActivity(), Cube.class));
        } else if ("Block".equals(option)) {
            startActivity(new Intent(getActivity(), Block.class));
        } else if ("Cone".equals(option)) {
            startActivity(new Intent(getActivity(), Cone.class));
        } else if ("Cylinder".equals(option)) {
            startActivity(new Intent(getActivity(), Cylinder.class));
        }
    }
}