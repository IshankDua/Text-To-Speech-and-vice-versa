package com.ckdtech.www.irproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener {

    CardView cv1;
    CardView cv2;
    CardView cv3;
    CardView cv4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_activity);

        cv1=(CardView) findViewById(R.id.cardView1);
        cv1.setOnClickListener(this);

        cv2=(CardView) findViewById(R.id.cardView2);
        cv2.setOnClickListener(this);


        cv3=(CardView) findViewById(R.id.cardView3);
        cv3.setOnClickListener(this);


        cv4=(CardView) findViewById(R.id.cardView4);
        cv4.setOnClickListener(this);
        }


         @Override
         public void onClick(View v){

             if (v.getId() == R.id.cardView1){
                 Toast.makeText(this, "Text To Speech Clicked", Toast.LENGTH_SHORT).show();
                 Intent a = new Intent(IndexActivity.this,TextToSpeechActivity.class);
                 startActivity(a);

            }

             if (v.getId() == R.id.cardView2){
                 Toast.makeText(this, "Speech To Text Clicked", Toast.LENGTH_SHORT).show();
                 Intent a = new Intent(IndexActivity.this,SpeechToTextActivity.class);
                 startActivity(a);
             }

             if (v.getId() == R.id.cardView3){
                 Toast.makeText(this, "Feedback  Clicked", Toast.LENGTH_SHORT).show();
                 Intent a = new Intent(IndexActivity.this,FeedbackActivity.class);
                 startActivity(a);
             }

             if (v.getId() == R.id.cardView4){
                 Toast.makeText(this, "Exit Clicked", Toast.LENGTH_SHORT).show();


                 cv4.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {

                         final AlertDialog.Builder builder = new AlertDialog.Builder(IndexActivity.this);
                         builder.setTitle("Exit");
                         builder.setMessage("Are You Sure you want to leave now...? ");
                         builder.setPositiveButton("Yes. Exit now!", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i){

                                 finish();

                             }
                         });
                         builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i){

                                 dialogInterface.dismiss();
                             }
                         });

                         AlertDialog dialog = builder.create();
                         dialog.show();
                     }
                 });
             }

         }
}
