package com.rest.restapi.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.rest.restapi.R;
import com.rest.restapi.Result;
import com.rest.restapi.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Result> movieList;
    private Result result;
    Context context;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public void addALL(List<Result> results) {
        this.movieList = results;
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        TextView txtTitle;
        private ImageView coverImage;

        public MovieViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.title);
            coverImage = mView.findViewById(R.id.coverImage);
        }
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.txtTitle.setText(movieList.get(position).getTitle());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        String img = movieList.get(position).getPosterPath();
        builder.build().load(RetrofitClient.API_KEY_IMG.concat(img))
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);
    }

    @Override
    public int getItemCount() {
        if (movieList == null)
            return 0;
        else return movieList.size();
    }
}
