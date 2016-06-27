package com.example.ruslan.udacity_second_project;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailActivityFragment extends Fragment {
    @BindView(R.id.text_year) TextView text_date;
    @BindView(R.id.text_vote) TextView text_vote;
    @BindView(R.id.text_title) TextView text_title;
    @BindView(R.id.text_overview) TextView text_overview;
    @BindView(R.id.imageView) ImageView imageView;
    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this,view);
        final String EXTRA_VALUE = "EXTRA";
        String baseApiPoster ="http://image.tmdb.org/t/p/w185/";
        Movie movie =(Movie)getActivity().getIntent().getParcelableExtra(EXTRA_VALUE);
        if (movie != null) {
            text_date.setText(movie.getRelease_date());
            text_vote.setText(movie.getVote_average()+"/10");
            text_title.setText(movie.getTitle());
            text_overview.setText(movie.getOverview());
            Picasso.with(getActivity())
                    .load(baseApiPoster + movie.getPoster_path())
                    .placeholder(R.drawable.waiting)
                    .error(R.drawable.index)
                    .into(imageView);
        }
        return view;
    }

}
