package com.example.hesham.musiccloud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        ArrayList<MusicType> song = new ArrayList<MusicType>();

        song.add(new MusicType("English", "Classic", R.drawable.arabictype2));
        song.add(new MusicType("LALA_LAND", "Moive", R.drawable.lalaland));
        song.add(new MusicType("Spacetoon", "Cartoon", R.drawable.spacetoon));
        song.add(new MusicType("Bioshock", "Games", R.drawable.bioshock_collection));

        ArrayAdaptor x = new ArrayAdaptor(this, song);

        ListView listView = (ListView) findViewById(R.id.list123);
        listView.setAdapter(x);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Intent x = new Intent(MainActivity.this, Unforgatable.class);
                    startActivity(x);
                } else if (position == 1) {
                    Intent x = new Intent(MainActivity.this, sun.class);
                    startActivity(x);
                } else if (position == 2) {
                    Intent x = new Intent(MainActivity.this, Remi.class);
                    startActivity(x);
                } else if (position == 3) {
                    Intent x = new Intent(MainActivity.this, Bioshock.class);
                    startActivity(x);
                }

            }
        });


    }
}
