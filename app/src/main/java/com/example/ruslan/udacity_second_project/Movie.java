package com.example.ruslan.udacity_second_project;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by ruslan on 6/27/16.
 */
public class Movie implements Parcelable {
    String title;
    String overview;
    String poster_path;
    String release_date;
    String vote_average;

    public Movie(String title, String overview, String poster_path, String release_date, String vote_average) {
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.vote_average = vote_average;
    }
    public Movie() {
    }


    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getVote_average() {
        return vote_average;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    public static final Parcelable.Creator<Movie> CREATOR = new Creator<Movie>() {
        public Movie createFromParcel(Parcel source) {
            Movie mMovie = new Movie();
            mMovie.title = source.readString();
            mMovie.overview = source.readString();
            mMovie.poster_path = source.readString();
            mMovie.release_date = source.readString();
            mMovie.vote_average = source.readString();
            return mMovie;
        }
        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(overview);
        dest.writeString(poster_path);
        dest.writeString(release_date);
        dest.writeString(vote_average);
    }
}
