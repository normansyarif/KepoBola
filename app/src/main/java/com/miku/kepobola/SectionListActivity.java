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
                    case 1:
                        fileContent = "bola.html";
                        titleContent = "BOLA";
                        break;
                    case 2:
                        fileContent = "pemain.html";
                        titleContent = "PEMAIN";
                        break;
                    case 3:
                        fileContent = "perlengkapan_pemain.html";
                        titleContent = "PERLENGKAPAN PEMAIN";
                        break;
                    case 4:
                        fileContent = "wasit.html";
                        titleContent = "WASIT";
                        break;
                    case 5:
                        fileContent = "other_official.html";
                        titleContent = "OFISIAL PERTANDINGAN LAIN";
                        break;
                    case 6:
                        fileContent = "lama_pertandingan.html";
                        titleContent = "LAMANYA PERTANDINGAN";
                        break;
                    case 7:
                        fileContent = "Mulai_pertandingan.html";
                        titleContent = "MEMULAI DAN MEMULAI KEMBALI PERMAINAN";
                        break;
                    case 8:
                        fileContent = "bola_luardalam.html";
                        titleContent = "BOLA DI DALAM DAN DI LUAR LAPANGAN";
                        break;
                    case 9:
                        fileContent = "hasil_pertandingan.html";
                        titleContent = "MENENTUKAN PEMENANG PERTANDINGAN";
                        break;
                    case 10:
                        fileContent = "offside.html";
                        titleContent = "OFSAID";
                        break;
                    case 11:
                        fileContent = "pelanggaran.html";
                        titleContent = "PELANGGARAN DAN KELAKUAN YANG TIDAK SOPAN";
                        break;
                    case 12:
                        fileContent = "tendangan_bebas.html";
                        titleContent = "TENDANGAN BEBAS";
                        break;
                    case 13:
                        fileContent = "pinalti.html";
                        titleContent = "TENDANGAN PINALTI";
                        break;
                    case 14:
                        fileContent = "lemparan_dalam.html";
                        titleContent = "LEMPARAN KEDALAM";
                        break;
                    case 15:
                        fileContent = "tendangan_gawang.html";
                        titleContent = "TENDANGAN GAWANG";
                        break;
                    case 16:
                        fileContent = "tendangan_sudut.html";
                        titleContent = "TENDANGAN SUDUT";
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
