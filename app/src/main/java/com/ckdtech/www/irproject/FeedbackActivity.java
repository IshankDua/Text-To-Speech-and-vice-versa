package com.ckdtech.www.irproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

        RatingBar ratingBar;
	    TextView textView;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
        	        super.onCreate(savedInstanceState);
        	        setContentView(R.layout.feedback_activity);

        	        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        	        textView = (TextView) findViewById(R.id.textView);




        	    }

        	    public void onSubmit(View view) {
					float ratingValue = ratingBar.getRating();

					if (ratingValue < 2) {
						textView.setText("Rating: " + ratingValue + "\nIs it that worse?");
					} else if (ratingValue <= 3 && ratingValue >= 2) {
						textView.setText("Rating: " + ratingValue + "\nWe will try to be better !");
					} else if (ratingValue > 3 && ratingValue <= 4) {
						textView.setText("Rating: " + ratingValue + "\nThat means you are having a good time here :)");
					} else if (ratingValue > 4) {
						textView.setText("Rating: " + ratingValue + "\nWow! We will keep up the good work ;)");

						float[] p = {+ratingValue};
					}

					Intent a = new Intent(Intent.ACTION_SEND);
					a.setData(Uri.parse("email"));
					String[] s = {"onlinetrainingbyish@gmail.com"};
					a.putExtra(Intent.EXTRA_EMAIL, s);
					a.putExtra(Intent.EXTRA_SUBJECT, "Feedback For The App");
					a.putExtra(Intent.EXTRA_TEXT, "Your Rating Value is = "+ratingValue);


					a.setType("message/rfc822");
					Intent chooser = Intent.createChooser(a, "Launch The Email");
					startActivity(chooser);

				}




        	}