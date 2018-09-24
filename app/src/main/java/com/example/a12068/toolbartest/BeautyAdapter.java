package com.example.a12068.toolbartest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BeautyAdapter extends RecyclerView.Adapter<BeautyAdapter.ViewHolder> {
    private Context mcontext;
    private List<BeautyPicture> mBeautyList;
    public BeautyAdapter(List<BeautyPicture> beautyPictureList){

        mBeautyList = beautyPictureList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mcontext == null) {
            mcontext = parent.getContext();
        }
        View view = LayoutInflater.from(mcontext).inflate(R.layout.beauty_picture,parent,false);

        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                BeautyPicture beautyPicture = mBeautyList.get(position);
                Intent intent = new Intent(mcontext,BeautyActivity.class);
                intent.putExtra(BeautyActivity.BEAUTY_NAME,beautyPicture.getName());
                intent.putExtra(BeautyActivity.BEAUTY_IMAGES_ID,beautyPicture.getImageId());
                mcontext.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BeautyPicture beautyPicture = mBeautyList.get(position);
        holder.textView_name.setText(beautyPicture.getName());
        Glide.with(mcontext).load(beautyPicture.getImageId()).into(holder.imageView_beauty);
    }

    @Override
    public int getItemCount() {
        return mBeautyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView_beauty;
        TextView textView_name;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            imageView_beauty = itemView.findViewById(R.id.beauty_image);
            textView_name = itemView.findViewById(R.id.beauty_name);
        }
    }
}
