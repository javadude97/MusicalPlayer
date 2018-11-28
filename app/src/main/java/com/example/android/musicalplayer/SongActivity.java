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

        // Create a list that includes the artist name and the song title here.
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Michael Jackson", "The Lady in My Life", R.drawable.thriller_michael_jackson, R.raw.number_one));
        songs.add(new Song("Atlantic Starr", "Masterpiece", R.drawable.atlantic_starr, R.raw.number_two));
        songs.add(new Song("Janet Jackson", "Escapade", R.drawable.janet_jackson, R.raw.number_three));
        songs.add(new Song("Mike and the Mechanics", "The Living Years", R.drawable.mike_and_the_mechanics, R.raw.number_four));
        songs.add(new Song("Cathy Dennis", "Touch Me (All Night Long)", R.drawable.cathy_dennis, R.raw.number_five));
        songs.add(new Song("Akon", "Chammak Challo", R.drawable.akon, R.raw.number_six));
        songs.add(new Song("Toni Braxton", "Make My Heart", R.drawable.toni_braxton, R.raw.number_seven));
        songs.add(new Song("Lee Ann Womack", "I Hope You Dance", R.drawable.lee_ann_womack, R.raw.number_eight));
        songs.add(new Song("Keith Urban", "Defying Gravity", R.drawable.keith_urban, R.raw.number_nine));
        songs.add(new Song("Billy Joel", "The Stranger", R.drawable.billy_joel, R.raw.number_ten));

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