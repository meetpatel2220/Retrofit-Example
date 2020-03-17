package com.meet.retrofit_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class MainActivity extends AppCompatActivity {

//    TextView textView;
//    ImageView imageView;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
//        textView = findViewById( R.id.t1 );
//        imageView = findViewById( R.id.img );

        recyclerView=findViewById(R.id.t1);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        Retrofit retrofit = new Retrofit.Builder().baseUrl( Api.BASE_URL )
                .addConverterFactory( GsonConverterFactory.create() ).build();

        Api api = retrofit.create( Api.class );
        Call<List<Hero>> call = api.getHeroes();

        call.enqueue( new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroes = response.body();


                    recyclerView.setAdapter(new PostAdapter(MainActivity.this,heroes));

//                    String content = "";
//                    content += "name: " + hero.getName() + "\n";
//                    content += "realname: " + hero.getRealname() + "\n";
//                    content += "team: " + hero.getTeam() + "\n";
//                    content += "firstappearance: " + hero.getFirstappearance() + "\n";
//                    content += "creadtedby: " + hero.getCreadtedby() + "\n";
//                    content += "publisher: " + hero.getPublisher() + "\n";
//                    content += "imageurl: " + hero.getImageurl() + "\n";
//                    content += "bio: " + hero.getBio() + "\n\n";
//                   // textView.append( content );

               //     Picasso.get().load( hero.getImageurl() ).into( imageView );
                }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText( MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT ).show();
            }
        } );
    }
}