package com.erwinpaisal.muslimapps.activity.JadwalKajianFeature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.erwinpaisal.muslimapps.R;

public class FloatingHelpActivity extends AppCompatActivity {

    private RelativeLayout bgLinear;
    private TextView etSecret;
    private TextView tvHelp;
    private LinearLayout llHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_help);
        initView();
        initClick();
    }

    private void initView() {

        bgLinear = (RelativeLayout) findViewById(R.id.bgLinear);
        etSecret = (TextView) findViewById(R.id.etSecret);
        tvHelp = (TextView) findViewById(R.id.tvHelp);
        llHelp = (LinearLayout) findViewById(R.id.llHelp);
    }

    private void initClick() {
        bgLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tvHelp.setText(Html.fromHtml("<html>\n" +
                "            <body>\n" +
                "                <b>Tema Kajian</b><br>Tema / Judul Kajian<br><br>\n" +
                "                <b>Detail Tema</b><br>Deskripsi singkat Tema<br><br>\n" +
                "                <b>Pemateri</b><br>Nama Pemateri<br><br>\n" +
                "                <b>Detail Pemateri</b><br>Biografi singkat Pemateri<br><br>\n" +
                "                <b>Link Google Maps</b><br>Opsional, link Lokasi dari Google Maps<br><br>\n" +
                "                <b>Kajian Untuk</b><br>Untuk Umum, Ikhwan atau Akhwat<br><br>\n" +
                "                <br>\n" +
                "                Setelah semua langkah selesai, silakan tunggu pihak AFN untuk mengkonfirmasi Jadwal Kajian yang telah diajukan<br>\n" +
                "            </body>\n" +
                "        </html>"));

        llHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
