package com.example.secondapp.controller;
<<<<<<< HEAD
=======
import android.support.annotation.NonNull;
>>>>>>> 1752f8efd25e40c3c14ec5f0c3fdd8e2fde03c71
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
import android.os.Bundle;
import android.view.MenuItem;
import com.example.secondapp.controller.fragments.AboutUsActivity;
=======
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.secondapp.controller.AboutUsActivity;
>>>>>>> 1752f8efd25e40c3c14ec5f0c3fdd8e2fde03c71
import com.example.secondapp.R;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout draw;
    private ActionBarDrawerToggle mToogle;
    private NavigationView nevigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupDrawerContent(nevigation);
    }

    private void findViews()
    {
        draw = (DrawerLayout)findViewById(R.id.drawer);
        nevigation = (NavigationView)findViewById(R.id.nevigation);
        mToogle = new ActionBarDrawerToggle(this,draw,R.string.open,R.string.close);
        draw.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupDrawerContent(NavigationView navigationV) {
        navigationV.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.aboutUs:
                fragmentClass = AboutUsActivity.class;
                break;
            default:
                fragmentClass = null;
        }

        if (fragmentClass != null) {
            try {

                fragment = (Fragment)fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fargment, fragment).commit();
            menuItem.setChecked(true);
            setTitle(menuItem.getTitle());
            draw.closeDrawers();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(mToogle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
