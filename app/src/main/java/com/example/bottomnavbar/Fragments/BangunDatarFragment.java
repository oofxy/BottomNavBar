package com.example.bottomnavbar.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bottomnavbar.BangunDatarAdapter;
import com.example.bottomnavbar.KalkulatorBangunDatar.Circle;
import com.example.bottomnavbar.KalkulatorBangunDatar.Rectangle;
import com.example.bottomnavbar.KalkulatorBangunDatar.Square;
import com.example.bottomnavbar.KalkulatorBangunDatar.Triangle;
import com.example.bottomnavbar.Model;
import com.example.bottomnavbar.R;

import java.util.ArrayList;

public class BangunDatarFragment extends Fragment implements BangunDatarAdapter.ItemClickListener{
    ArrayList<Model> modelBangunDatar = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_bangun_datar, container, false);

        RecyclerView rvBangunDatar = rootView.findViewById(R.id.rvBangunDatar);

        modelBangunDatar.add(new Model("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAGFBMVEX///8AAABQUFBNTU1TU1NjY2MXFxfu7u4stZ7VAAABdklEQVR4nO3du20EMRQEQe19pPwzlie/DeoGi6oABmyA/vv6AgAAAAAAAAAA4J5+3s/Hguf751Dh+1rxPlT4/HTYn+ehwsd1fb8+/UUfr+/repwrfB2aLl5HC09NFwefofCfKNycLhRuThcKN6cLhZvThcLN6ULh5nShcHO6ULg5XSjcnC4Ubk4XCjenC4Wb04XCzelC4eZ0oXBzulC4OV0o3JwuFG5OFwo3pwuFm9OFws3pQuHmdKFwc7pQuDldKNycLhRuThcKN6cLhZvThcLN6ULh5nShcHO6ULg5XSjcnC4Ubk4XCjenC4Wb04XCzelC4eZ0oXBzulC4OV0o3JwuFG5OFwo3pwuFm9OFws3pQuHmdKFwc7pQuDldKNycLhRuThcKN6cLhZvThcLN6ULh5nShcHO6ULg5XSjcnC4Ubk4XCjenC4Wb04XCzelC4eZ0oXBzujhbeP8blje/Q3r/W7L3vwd8/5vOAAAAAAAAAAAAfNovofQM/S+mDJYAAAAASUVORK5CYII=",
                "Square"));

        modelBangunDatar.add(new Model("https://media.istockphoto.com/id/1439837596/photo/blank-tv-or-picture-frame-with-copy-space.webp?b=1&s=170667a&w=0&k=20&c=OZmkq3tJ1nXJ_DzOsTHQlnMi8VVZX6EZrJP8Mb1V844=",
                "Rectangle"));

        modelBangunDatar.add(new Model("https://i.pinimg.com/736x/e8/b1/6f/e8b16fedd714bad03028e982735585bd.jpg",
                "Circle"));

        modelBangunDatar.add(new Model("https://prattandlarson.com/wp-content/uploads/2020/12/PF-ETR6.jpg",
                "Triangle"));

        rvBangunDatar.setLayoutManager(new LinearLayoutManager(getActivity()));
        BangunDatarAdapter adapter = new BangunDatarAdapter(getContext(), modelBangunDatar);
        adapter.setClickListener(this);
        rvBangunDatar.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onItemClick(View view, int position) {
        // Handle item clicks here
        String option = modelBangunDatar.get(position).getNama();

        if ("Square".equals(option)){
            startActivity(new Intent(getActivity(), Square.class));
        } else if ("Rectangle".equals(option)){
            startActivity(new Intent(getActivity(), Rectangle.class));
        } else if ("Circle".equals(option)) {
            startActivity(new Intent(getActivity(), Circle.class));
        } else if ("Triangle".equals(option)) {
            startActivity(new Intent(getActivity(), Triangle.class));
        }
    }
}