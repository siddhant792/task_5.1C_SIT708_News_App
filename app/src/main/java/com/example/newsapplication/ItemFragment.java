package com.example.newsapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemFragment extends Fragment implements VerticalNewsAdapter.OnItemClickListener, TopStoriesAdapter.OnItemClickListener{

    public static ItemFragment newInstance(String[] item) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putStringArray("item", item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        ImageView imageView = view.findViewById(R.id.imageView2);
        TextView tv_title = view.findViewById(R.id.tv_title);
        TextView tv_description = view.findViewById(R.id.tv_description);
        RecyclerView recyclerView = view.findViewById(R.id.rv_vertical_news);

        List<String[]> topStories = new ArrayList<>();

        topStories.add(new String[]{"https://pbs.twimg.com/profile_images/446356636710363136/OYIaJ1KK_400x400.png", "Echoes of Silent Whispers", "Whispers in the wind carry tales of forgotten dreams."});
        topStories.add(new String[]{"https://www.dow.org.au/wp-content/uploads/wollongongcathedral2022tile-400x400.jpg", "Forgotten Dreams Awakened", "Lost in time's embrace, dreams awaken to distant echoes."});
        topStories.add(new String[]{"https://www.jotform.com/resources/assets/icon/jotform-icon-orange-400x400.png", "Whispers in the Wind", "Whispers in the wind tell stories of ancient lands."});
        topStories.add(new String[]{"https://www.ibm.com/blogs/southeast-europe/wp-content/uploads/2019/02/securitythumbnail400x400.png", "Shadows of Forgotten Memories", "Shadows dance with memories lost in the sands."});
        topStories.add(new String[]{"https://www.nxsports.org/wp-content/uploads/2023/10/Web-400x400.jpg", "Echoes of Distant Voices", "Echoes of distant voices linger in the night."});
        topStories.add(new String[]{"https://pbs.twimg.com/profile_images/446356636710363136/OYIaJ1KK_400x400.png", "Lost in Time's Embrace", "Lost in time's embrace, souls wander through eternity."});
        topStories.add(new String[]{"https://www.dow.org.au/wp-content/uploads/wollongongcathedral2022tile-400x400.jpg", "Whispers Amongst the Shadows", "Whispers amongst the shadows reveal secrets of the past."});
        topStories.add(new String[]{"https://www.jotform.com/resources/assets/icon/jotform-icon-orange-400x400.png", "Echoes of Endless Journeys", "Echoes of endless journeys resonate across the universe."});
        topStories.add(new String[]{"https://www.ibm.com/blogs/southeast-europe/wp-content/uploads/2019/02/securitythumbnail400x400.png", "Sands of Time Lost", "Sands of time lost in the hourglass of fate."});
        topStories.add(new String[]{"https://www.nxsports.org/wp-content/uploads/2023/10/Web-400x400.jpg", "Whispers of Forgotten Echoes", "Whispers of forgotten echoes fade into the void."});

        String[] item = getArguments().getStringArray("item");
        Picasso.get().load(item[0]).into(imageView);
        tv_title.setText(item[1]);
        tv_description.setText(item[2]);

        VerticalNewsAdapter verticalNewsAdapter = new VerticalNewsAdapter(topStories, this, R.layout.news_item_horizontal);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(verticalNewsAdapter);

        return view;
    }

    @Override
    public void onItemClick(String[] item) {

    }
}