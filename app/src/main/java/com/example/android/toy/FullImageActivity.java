package com.example.android.toy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.android.toy.Fragments.BodyFragment;
import com.example.android.toy.Fragments.BodyPartFragment;

public class FullImageActivity extends AppCompatActivity {

    private  int headIndex, bodyIndex, legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        headIndex = bundle.getInt("head");
        bodyIndex = bundle.getInt("body");
        legIndex = bundle.getInt("leg");

        if (savedInstanceState == null){

            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setImageIds(AndroidImageAssets.getHeads());
            headFragment.setListIndex(headIndex);

            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            bodyFragment.setListIndex(bodyIndex);

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageIds(AndroidImageAssets.getLegs());
            legFragment.setListIndex(legIndex);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container,headFragment)
                    .add(R.id.body_container, bodyFragment)
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }
    }
}
