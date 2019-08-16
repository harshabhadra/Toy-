package com.example.android.toy.Fragments;

import android.content.Context;
import android.os.Bundle;
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

public class BodyFragment extends Fragment implements HeadAdapter.OnImageItemClickListener {

    private static final String TAG = BodyFragment.class.getSimpleName();
    OnImageClick click;

    public interface OnImageClick{
        void onBodyImageClick(int i);
    }
    public BodyFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.shape_list, container, false);

        RecyclerView headRecycler = rootView.findViewById(R.id.shape_recycler);
        headRecycler.setHasFixedSize(true);
        HeadAdapter headAdapter = new HeadAdapter(getContext(), BodyFragment.this, AndroidImageAssets.getBodies());
        headRecycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        headRecycler.setAdapter(headAdapter);

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

        click.onBodyImageClick(position);
    }
}
