package com.example.android.toy.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.toy.Adapters.HeadAdapter;
import com.example.android.toy.AndroidImageAssets;
import com.example.android.toy.R;

public class HeadFragment extends Fragment implements HeadAdapter.OnImageItemClickListener {


    private static final String TAG = HeadFragment.class.getSimpleName();

    OnImageClick click;

    public interface OnImageClick{
        void onHeadImageClick(int i);
    }

    public HeadFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.shape_list, container, false);

        RecyclerView headRecycler = rootView.findViewById(R.id.shape_recycler);
        headRecycler.setHasFixedSize(true);
        HeadAdapter headAdapter = new HeadAdapter(getContext(),HeadFragment.this, AndroidImageAssets.getHeads());
        headRecycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        headRecycler.setAdapter(headAdapter);


        Log.e(TAG,"Head Fragment created");
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            click = (OnImageClick)context;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(int position) {

        click.onHeadImageClick(position);
    }
}
