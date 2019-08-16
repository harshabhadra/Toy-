package com.example.android.toy.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.toy.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    private List<Integer>imageIds;
    private int listIndex;
    private static final String TAG = BodyFragment.class.getSimpleName();
    private static final String IMAGE_IDS = "image ids";
    private static final String IMAGE_INDEX = "image index";

    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null){
            imageIds = savedInstanceState.getIntegerArrayList(IMAGE_IDS);
            listIndex = savedInstanceState.getInt(IMAGE_INDEX);
        }
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        ImageView imageView =rootView.findViewById(R.id.body_part_image);
        if (imageIds != null){
            imageView.setImageResource(imageIds.get(listIndex));
        }

        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putIntegerArrayList(IMAGE_IDS, (ArrayList< Integer >) imageIds);
        outState.putInt(IMAGE_INDEX, listIndex);
    }

    public void setImageIds(List<Integer> imageIds) {
        this.imageIds = imageIds;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }
}
