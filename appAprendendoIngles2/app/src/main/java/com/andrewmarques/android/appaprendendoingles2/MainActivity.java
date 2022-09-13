package com.andrewmarques.android.appaprendendoingles2;

import android.os.Bundle;

import com.andrewmarques.android.appaprendendoingles2.Fragments.BichosFragment;
import com.andrewmarques.android.appaprendendoingles2.Fragments.NumerosFragment;
import com.andrewmarques.android.appaprendendoingles2.Fragments.VogaisFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.andrewmarques.android.appaprendendoingles2.ui.main.MySectionsPagerAdapter;
import com.andrewmarques.android.appaprendendoingles2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MySectionsPagerAdapter sectionsPagerAdapter = new MySectionsPagerAdapter(this, getSupportFragmentManager());
        sectionsPagerAdapter.addPage("Numeros", new NumerosFragment());
        sectionsPagerAdapter.addPage("Bichos", new BichosFragment());
        sectionsPagerAdapter.addPage("Vogais", new VogaisFragment());

        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }
}