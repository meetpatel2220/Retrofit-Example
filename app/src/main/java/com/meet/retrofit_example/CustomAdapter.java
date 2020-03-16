package com.meet.retrofit_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{


    private List<RetroPhoto> datalist;
    private Context context;

    public CustomAdapter(List<RetroPhoto> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }



    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.custom_row,parent,false);

        return new CustomAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {

        holder.txtTitle.setText(datalist.get(position).getTitle());
        Picasso.Builder builder=new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(datalist.get(position).getThumbnailUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.covorImage);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        TextView txtTitle;
        private ImageView covorImage;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
             mView=itemView;

             txtTitle=mView.findViewById(R.id.txt);
             covorImage=mView.findViewById(R.id.img);


            }
    }

}
