package com.example.android.musicalplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        // Create a list of words
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("one", "lutti", R.drawable.number_one, R.raw.number_one));
        songs.add(new Song("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        songs.add(new Song("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        songs.add(new Song("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        songs.add(new Song("five", "massokka", R.drawable.number_five, R.raw.number_five));
        songs.add(new Song("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        songs.add(new Song("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        songs.add(new Song("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        songs.add(new Song("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        songs.add(new Song("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Song song = songs.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(SongActivity.this, song.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }

}