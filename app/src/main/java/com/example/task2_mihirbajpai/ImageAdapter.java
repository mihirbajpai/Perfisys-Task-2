package com.example.task2_mihirbajpai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context context;
    private int[] images;
    private int flag=0;

    public ImageAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int imageResource = images[position];
        holder.imageView.setImageResource(imageResource);

        holder.like.setImageResource(R.drawable.like_gray);

        holder.download.setOnClickListener(view -> Toast.makeText(context, "Image downloaded", Toast.LENGTH_LONG).show());

        holder.share.setOnClickListener(view -> Toast.makeText(context, "Share image", Toast.LENGTH_LONG).show());

        holder.like.setOnClickListener(view -> {
            if (flag==0){
                holder.like.setImageResource(R.drawable.like_red);
                flag=1;
            }else {
                holder.like.setImageResource(R.drawable.like_gray);
                flag=0;
            }
        });



    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageButton download, share, like;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            download = itemView.findViewById(R.id.download);
            share = itemView.findViewById(R.id.share);
            like = itemView.findViewById(R.id.like);
        }
    }
}
