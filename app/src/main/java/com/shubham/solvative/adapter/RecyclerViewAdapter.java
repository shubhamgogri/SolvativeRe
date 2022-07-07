package com.shubham.solvative.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shubham.solvative.R;
import com.shubham.solvative.model.Artwork;

import java.text.MessageFormat;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {

    Context ctx;
    List<Artwork> artworkList;

    public RecyclerViewAdapter(Context ctx, List<Artwork> artworkList) {
        this.ctx = ctx;
        this.artworkList = artworkList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Artwork artwork = artworkList.get(position);
        holder.fiscalYear.setText(MessageFormat.format("Fical Year: {0}", artwork.getFiscal_year()));
        holder.title.setText(MessageFormat.format("Title: {0}", artwork.getTitle()));
        holder.artDisplay.setText(MessageFormat.format("Art Display: {0}", artwork.getArtist_display()));
        holder.artID.setText(MessageFormat.format("Art Id: {0}", artwork.getArtist_id()));

    }

    @Override
    public int getItemCount() {
        return artworkList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView artID;
        TextView artDisplay;
        TextView fiscalYear;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            artID = itemView.findViewById(R.id.artistId);
            title = itemView.findViewById(R.id.artistTitle);
            artDisplay = itemView.findViewById(R.id.artistDisplay);
            fiscalYear = itemView.findViewById(R.id.fiscalYear);
        }
    }
}
