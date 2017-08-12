package com.example.viniciusvianna.smavc_paciente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class Sobre extends AppCompatActivity {

    private TextView tvSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        tvSobre = (TextView) findViewById(R.id.sobre);
        tvSobre.setText(getString(R.string.sobre));

    }
}
