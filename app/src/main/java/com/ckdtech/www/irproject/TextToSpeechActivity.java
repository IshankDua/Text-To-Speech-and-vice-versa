package com.ckdtech.www.irproject;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class TextToSpeechActivity extends Activity implements TextToSpeech.OnInitListener {

	    private TextToSpeech tts;
	    private Button btnSubmit;
	    private EditText inputText;


        	    @Override
	    public void onCreate(Bundle savedInstanceState) {
        	        super.onCreate(savedInstanceState);
        	        setContentView(R.layout.texttospeech_activity);

        	        tts = new TextToSpeech(this, this);

        	        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        	        inputText = (EditText) findViewById(R.id.textInput);
        	        btnSubmit.setOnClickListener(new View.OnClickListener() {

        	            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
	            		public void onClick(View v) {
                	                voiceOutput();
                	            }
	       				 });

        	    }

        	    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                private void voiceOutput() {

        	        CharSequence text = inputText.getText();

        	        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null,"id1");
        	    }

        	    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
	    public void onInit(int status) {

        	        if (status == TextToSpeech.SUCCESS) {
            	            //set language, you can change to any built in language given we are using US language locale
            	            int result = tts.setLanguage(Locale.US);
            	            float i = 50;

            	            if (result == TextToSpeech.LANG_MISSING_DATA
            	                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                	                Toast.makeText(TextToSpeechActivity.this, "Language not supported!", Toast.LENGTH_SHORT).show();
                	            } else {
                	                btnSubmit.setEnabled(true);
                	                voiceOutput();
                	            }

            	        } else {
            	            Toast.makeText(TextToSpeechActivity.this, "Initialization failed!", Toast.LENGTH_SHORT).show();
            	        }
            }

        	    @Override
	    public void onDestroy() {
        	        //shutdown TextToSpeech
        	        if (tts != null) {
            	            tts.stop();
            	            tts.shutdown();
            	        }
        	        super.onDestroy();
        	    }


}