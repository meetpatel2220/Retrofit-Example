package com.meet.retrofit_example;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.http.Url;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.Postviewholder> {

   private Context context;
   private List<Hero> hero;

    public PostAdapter(Context context, List<Hero> hero) {
        this.context = context;
        this.hero = hero;
    }

    @NonNull
    @Override
    public Postviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.custom_row,parent,false);


        return new Postviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Postviewholder holder, int position) {

        holder.t1.setText(hero.get(position).getBio());

        String x=hero.get(position).getImageurl();
     Picasso.get().load(x).into(holder.img);


    }


    @Override
    public int getItemCount() {
        return hero.size();
    }

    public class Postviewholder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView t1;

        public Postviewholder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img);
            t1=itemView.findViewById(R.id.txt);



        }
    }



}
