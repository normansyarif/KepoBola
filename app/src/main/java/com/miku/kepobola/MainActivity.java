package com.miku.kepobola;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CardView cardProfile, cardFootball, cardPembimbing, cardPdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardProfile = findViewById(R.id.card_profile);
        cardFootball = findViewById(R.id.card_football);
        cardPembimbing = findViewById(R.id.card_pembimbing);
        cardPdf = findViewById(R.id.card_pdf);

        onClickedListener();
    }

    private void onClickedListener() {

        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        cardFootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SectionListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        cardPembimbing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileDosenActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        cardPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                copyFiletoExternalStorage(R.raw.doc, "PeraturanBola.pdf");
                readPdf();
            }
        });

    }


    private void copyFiletoExternalStorage(int resourceId, String resourceName){
        String pathSDCard = getExternalFilesDir(null) + "/" + resourceName;
        try{
            InputStream in = getResources().openRawResource(resourceId);
            FileOutputStream out = null;
            out = new FileOutputStream(pathSDCard);
            byte[] buff = new byte[1024];
            int read = 0;
            try {
                while ((read = in.read(buff)) > 0) {
                    out.write(buff, 0, read);
                }
            } finally {
                in.close();
                out.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void readPdf() {
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        File file = new File(getExternalFilesDir(null), "PeraturanBola.pdf");

        if(file.exists()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        }else {
            Toast.makeText(this, "PDF does not exist", Toast.LENGTH_SHORT).show();
        }

    }


}
