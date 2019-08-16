package com.example.android.toy;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.android.toy.Fragments.BodyFragment;
import com.example.android.toy.Fragments.BodyPartFragment;
import com.example.android.toy.Fragments.HeadFragment;
import com.example.android.toy.Fragments.LegFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements HeadFragment.OnImageClick, BodyFragment.OnImageClick, LegFragment.OnLegImageClick {

    ViewPager viewPager;
    TabLayout tabLayout;
    FloatingActionButton fab;
    Intent intent;

    boolean isTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        SimplePageAdapter pageAdapter = new SimplePageAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(viewPager);


        if (findViewById(R.id.full_image_activity) != null) {

            Toast.makeText(getApplicationContext(),"It is a tablet", Toast.LENGTH_LONG).show();
            isTwoPane = true;
            if (savedInstanceState == null) {
                BodyPartFragment headFragment = new BodyPartFragment();
                headFragment.setImageIds(AndroidImageAssets.getHeads());

                BodyPartFragment bodyFragment = new BodyPartFragment();
                bodyFragment.setImageIds(AndroidImageAssets.getBodies());

                BodyPartFragment legFragment = new BodyPartFragment();
                legFragment.setImageIds(AndroidImageAssets.getLegs());

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .add(R.id.head_container, headFragment)
                        .add(R.id.body_container, bodyFragment)
                        .add(R.id.leg_container, legFragment)
                        .commit();
            }
        } else {
            isTwoPane = false;
            intent = new Intent(MainActivity.this, FullImageActivity.class);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intent);
                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onHeadImageClick(final int i) {

        if (isTwoPane) {
            Toast.makeText(getApplicationContext(), "Click at Position: " + i, Toast.LENGTH_SHORT).show();
            BodyPartFragment fragment = new BodyPartFragment();
            fragment.setImageIds(AndroidImageAssets.getHeads());
            fragment.setListIndex(i);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.head_container, fragment).commit();
        } else {
            intent.putExtra("head", i);
            Toast.makeText(getApplicationContext(), "Position: " + i, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBodyImageClick(int i) {

        if (isTwoPane) {
            Toast.makeText(getApplicationContext(), "Click at Position: " + i, Toast.LENGTH_SHORT).show();
            BodyPartFragment fragment = new BodyPartFragment();
            fragment.setImageIds(AndroidImageAssets.getBodies());
            fragment.setListIndex(i);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.body_container, fragment).commit();
        } else {
            intent.putExtra("body", i);
            Toast.makeText(getApplicationContext(), "Position: " + i, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLegImageClick(int i) {

        if (isTwoPane) {
            Toast.makeText(getApplicationContext(), "Click at Position: " + i, Toast.LENGTH_SHORT).show();
            BodyPartFragment fragment = new BodyPartFragment();
            fragment.setImageIds(AndroidImageAssets.getLegs());
            fragment.setListIndex(i);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.leg_container, fragment).commit();
        } else {
            intent.putExtra("leg", i);
            Toast.makeText(getApplicationContext(), "Position: " + i, Toast.LENGTH_SHORT).show();
        }
    }
}
