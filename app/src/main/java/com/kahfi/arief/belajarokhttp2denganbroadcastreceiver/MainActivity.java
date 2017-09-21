package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.adapters.MyFragmentPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.viewPager)ViewPager viewPager;
    @BindView(R.id.bottomNavigationView)BottomNavigationView bottomView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        setUpForViewPager(viewPager);


        bottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                setUpMenuItem(item);

                if(item.isChecked()){
                    item.setChecked(true);
                }else{
                    item.setChecked(false);
                }

                return true;
            }
        });

    }


    private void setUpMenuItem(MenuItem item){
        switch (item.getItemId()){
            case R.id.formMenu:
                viewPager.setCurrentItem(0,true);
                break;

            case R.id.listMenu:
                viewPager.setCurrentItem(1,true);
                break;

            case R.id.deleteMenu :
                viewPager.setCurrentItem(2,true);
                break;

        }
    }

    private void setUpForViewPager(ViewPager viewPager){
        MyFragmentPager pagerAdapter = new MyFragmentPager(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }
}
