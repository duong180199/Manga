package com.example.mangaapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.mangaapp.R;
import com.example.mangaapp.adapter.ViewPagerAdapter;
import com.example.mangaapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPagerHome.setAdapter(viewPagerAdapter);
        binding.viewPagerHome.setOffscreenPageLimit(3);
        binding.viewPagerHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        binding.botomNavigation.getMenu().findItem(R.id.menu_home).setChecked(true);
                        break;
                    case 1:
                        binding.botomNavigation.getMenu().findItem(R.id.menu_category).setChecked(true);
                        break;
                    case 2:
                        binding.botomNavigation.getMenu().findItem(R.id.menu_ranking).setChecked(true);
                        break;
                    case 3:
                        binding.botomNavigation.getMenu().findItem(R.id.menu_user).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        binding.botomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.menu_home:
                    binding.viewPagerHome.setCurrentItem(0);
                    break;
                case R.id.menu_category:
                    binding.viewPagerHome.setCurrentItem(1);
                    break;
                case R.id.menu_ranking:
                    binding.viewPagerHome.setCurrentItem(2);
                    break;
                case R.id.menu_user:
                    Intent intent = new Intent(this,LoginActivity.class);
                    startActivity(intent);
                    binding.viewPagerHome.setCurrentItem(3);
                    break;
            }
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}