package com.example.android.musicalplayer;

/**
 * {@link Song} contains the artist name, the song title, and an image for album cover.
 */
public class Song {

    /** Name of the artist */
    private String mArtistName;

    /** Title of the song */
    private String mSongTitle;

    /** Audio resource ID for the song */
    private int mAudioResourceId;

    /** Image resource ID for the album cover */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this album */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Song object.
     *
     * @param artistName is the name of the artist
     * @param songTitle is the title of the song
     * @param audioResourceId is the resource ID for the audio file associated with the song.
     */
    public Song(String artistName, String songTitle, int audioResourceId) {
        mArtistName = artistName;
        mSongTitle = songTitle;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Create a new Song object with addition of image resource.
     *
     * @param artistName is the name of the artist
     * @param songTitle is the title of the song
     * @param imageResourceId is the drawable resource ID for the image associated with the album cover
     * @param audioResourceId is the resource ID for the audio file associated with the song.
     */
    public Song(String artistName, String songTitle, int imageResourceId,
                int audioResourceId) {
        mArtistName = artistName;
        mSongTitle = songTitle;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the name of the artist.
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the title of the song.
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Return the image resource ID of the album cover.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this album .
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return the audio resource ID of the song.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}