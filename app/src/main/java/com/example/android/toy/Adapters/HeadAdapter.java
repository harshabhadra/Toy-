package com.example.android.toy.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.toy.R;

import java.util.ArrayList;
import java.util.List;

public class HeadAdapter extends RecyclerView.Adapter <HeadAdapter.HeadViewHolder> {

    LayoutInflater inflater;
    List<Integer>imageList = new ArrayList<>();
    OnImageItemClickListener listener;

    public interface OnImageItemClickListener{
        void onClick(int position);
    }

    public HeadAdapter(Context context,OnImageItemClickListener listener, List<Integer> imageList) {

        inflater = LayoutInflater.from(context);
        this.listener = listener;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public HeadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HeadViewHolder(inflater.inflate(R.layout.shapes, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HeadViewHolder holder, int position) {

        if (imageList != null){
            holder.imageView.setImageResource(imageList.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    class HeadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView imageView ;

    public HeadViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.shape_image);
        itemView.setOnClickListener(this);
    }


        @Override
        public void onClick(View view) {

        int position = getAdapterPosition();
        listener.onClick(position);
        }
    }
}
