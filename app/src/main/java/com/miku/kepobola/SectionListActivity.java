package com.miku.kepobola;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SectionListActivity extends AppCompatActivity {

    String[] listArray={"Lapangan Permainan",
            "Bola",
            "Pemain",
            "Perlengkapan Pemain",
            "Wasit",
            "Ofisial Pertandingan Lain",
            "Lamanya Pertandingan",
            "Memulai dan memulai kembali permainan",
            "Bola di dalam dan di luar permainan",
            "Menentukan pemenang pertandingan",
            "Ofsaid",
            "Pelanggaran dan kelakuan yang tidak sopan",
            "Tendangan bebas",
            "Tendangan pinalti",
            "Lemparan kedalam",
            "Tendangan gawang",
            "Tendangan sudut"};

    ListView listview;
    String fileContent;
    String titleContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Daftar Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listArray);
        listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        fileContent = "lapangan_permainan.html";
                        titleContent = "LAPANGAN PERMAINAN";
                        break;
                    case 10:
                        fileContent = "offside.html";
                        titleContent = "OFSAID";
                        break;
                    default:
                        fileContent = "lapangan_permainan.html";
                        titleContent = "Lapangan Permainan";
                        break;
                }

                Intent intent = new Intent(SectionListActivity.this, ContentActivity.class);
                intent.putExtra("fileContent",  fileContent);
                intent.putExtra("titleContent", titleContent);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
