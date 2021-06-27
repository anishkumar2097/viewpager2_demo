package com.example.viewpager2_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPagerverical,viewPagerhorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPagerhorizontal=findViewById(R.id.view_pager_horizontal);
        viewPagerverical=findViewById(R.id.view_pager_vertical);
        CustomAdapter adapter=new CustomAdapter(this);
        viewPagerverical.setAdapter(adapter);
        viewPagerhorizontal.setClipChildren(false);
        viewPagerhorizontal.setClipToPadding(false);
        viewPagerhorizontal.setOffscreenPageLimit(3);
        viewPagerhorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        viewPagerhorizontal.setAdapter(adapter);

        CompositePageTransformer transformer=new CompositePageTransformer();
                transformer.addTransformer(new MarginPageTransformer(8));
                transformer.addTransformer(new ViewPager2.PageTransformer() {
                    @Override
                    public void transformPage(@NonNull View page, float position) {
                        float v=1-Math.abs(position);
                        page.setScaleY(0.8f+v*0.2f);
                    }
                });
                viewPagerhorizontal.setPageTransformer(transformer);
    }
}