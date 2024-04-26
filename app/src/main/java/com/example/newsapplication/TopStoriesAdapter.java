package com.example.newsapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.UrlViewHolder> {

    private List<String[]> storiesList;
    private OnItemClickListener listener;

    public TopStoriesAdapter(List<String[]> storiesList, OnItemClickListener listener) {
        this.storiesList = storiesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UrlViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_story_item, parent, false);
        return new UrlViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UrlViewHolder holder, int position) {
        String[] item = storiesList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return storiesList.size();
    }

    public class UrlViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        ImageView img_story_item;

        public UrlViewHolder(@NonNull View itemView) {
            super(itemView);
            img_story_item = itemView.findViewById(R.id.img_story_item);
            itemView.setOnClickListener(this);
        }

        public void bind(String[] item) {
            Picasso.get().load(item[0]).into(img_story_item);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                String[] imageUrl = storiesList.get(position);
                listener.onItemClick(imageUrl);
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String[] imageUrl);
    }
}
