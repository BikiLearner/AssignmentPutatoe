package com.example.newputatoeassingment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerHomeAdapter extends RecyclerView.Adapter<RecyclerHomeAdapter.ViewHolder> {
    private final ArrayList<ImageData> imageDataArrayList;
    private final Context context;

    public RecyclerHomeAdapter(Context context, ArrayList<ImageData> imageDataArrayList) {
        this.imageDataArrayList = imageDataArrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_home_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageData imageData=imageDataArrayList.get(position);
        holder.setData(imageData,context);
    }

    @Override
    public int getItemCount() {
        return imageDataArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageButton imageButton;
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageButton=itemView.findViewById(R.id.action_image);
            textView=itemView.findViewById(R.id.title);
        }
        public void setData(ImageData imageData,Context context){
            Glide.with(context).load(imageData.getImage()).into(imageButton);
            textView.setText(imageData.getTitle());
        }
    }
}
