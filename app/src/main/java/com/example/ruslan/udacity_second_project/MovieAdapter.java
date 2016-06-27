package com.example.ruslan.udacity_second_project;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MovieAdapter extends ArrayAdapter<Movie> {
    Context mcontext;
    String baseApiPoster ="http://image.tmdb.org/t/p/w185/";

    public MovieAdapter(Context context,List<Movie> movies) {
        super(context, 0,movies);
        mcontext = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Movie movie = getItem(position);
        Holder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.movie_list,parent,false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }
        else {
        holder = (Holder)convertView.getTag();
        }
        Picasso.with(mcontext)
                .load(baseApiPoster + movie.getPoster_path())
                .placeholder(R.drawable.waiting)
                .error(R.drawable.index)
                .into(holder.movie_poster);
        holder.movie_title.setText(movie.getTitle());
        return convertView;

    }
    static class Holder{
        @BindView(R.id.movie_title) TextView movie_title;
        @BindView(R.id.movie_poster) ImageView movie_poster;
        public Holder(View v) {
            ButterKnife.bind(this,v);
        }
    }
}
