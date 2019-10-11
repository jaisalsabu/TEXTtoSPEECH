package com.example.tos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText txt1;
    Button btn;
    TextToSpeech txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.editText2);
        btn = findViewById(R.id.button);

        txt = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    txt.setLanguage(Locale.UK);

                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tospeak = txt1.getText().toString();
                Toast.makeText(getApplicationContext(), tospeak, Toast.LENGTH_SHORT).show();
                txt.speak(tospeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    public void onPause() {
        if (txt != null) {
            txt.stop();
            txt.shutdown();
        }
        super.onPause();
    }
}

