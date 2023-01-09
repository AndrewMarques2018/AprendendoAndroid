package com.andrewmarques.android.framesliders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.andrewmarques.android.framesliders.databinding.ActivityMainBinding;

public class MainActivity extends FragmentActivity {

    private ActivityMainBinding binding;
    private ViewPager2 viewPager2;
    private FragmentStateAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager2 = binding.pager;
        pagerAdapter = new ScreenSliderPageAdapter(this);
        viewPager2.setAdapter(pagerAdapter);
        viewPager2.setPageTransformer(new ZoomOutPageTransformer());
    }

    private class ScreenSliderPageAdapter extends FragmentStateAdapter {

        public ScreenSliderPageAdapter(MainActivity mainActivity) {
            super(mainActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return new FragmentSlider1();
                case 1:
                    return new FragmentSlider2();
                case 2:
                    return new FragmentSlider3();
                default:
                return null;
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }

    private class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.50f;

        @Override
        public void transformPage(@NonNull View page, float position) {
            int pageWidth = page.getWidth();
            int pageHeigth = page.getHeight();

            if(position <= -1){
                page.setAlpha(0f);
            }else if(position <= 1){
                float scaleFactor = Math.max(MIN_SCALE, 1-Math.abs(position));
                float vertMargin = pageHeigth*(1-scaleFactor)/2;
                float horiMargin = pageWidth*(1-scaleFactor)/2;

                if(position < 0){
                    page.setTranslationX(horiMargin-vertMargin/2);
                }else{
                    page.setTranslationX(-horiMargin+vertMargin/2);
                }
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
                page.setAlpha(MIN_ALPHA+(scaleFactor-MIN_SCALE)/(1-MIN_SCALE)*(1-MIN_SCALE));
            }
            else {
                page.setAlpha(0f);
            }
        }
    }
}