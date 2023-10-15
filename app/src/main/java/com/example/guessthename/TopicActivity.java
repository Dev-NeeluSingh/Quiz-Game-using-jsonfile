package com.example.guessthename;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class TopicActivity extends Activity {
    CardView cars, foods, electrics, bikes;
    Intent intent = new Intent();
    ImageView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_layout);
        cars = findViewById(R.id.cars);
        foods = findViewById(R.id.food);
        electrics = findViewById(R.id.electric);
        bikes = findViewById(R.id.bikes);
        menu = findViewById(R.id.menu);

        cars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(TopicActivity.this, LevelsActivity.class);
                intent.putExtra("topic", "cars");
                startActivity(intent);
            }
        });
        foods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(TopicActivity.this, LevelsActivity.class);
                intent.putExtra("topic", "foods");
                startActivity(intent);
            }
        });
        electrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(TopicActivity.this, LevelsActivity.class);
                intent.putExtra("topic", "electrics");
                startActivity(intent);
            }
        });
        bikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(TopicActivity.this, LevelsActivity.class);
                intent.putExtra("topic", "bikes");
                startActivity(intent);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rulesDialog();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(getResources().getColor(R.color.yellow));
    }

    @Override
    public void onBackPressed() {
        exitDialog();
    }

    public void exitDialog() {
        Dialog dialog = new Dialog(TopicActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.exit);
        dialog.setCanceledOnTouchOutside(true);
        TextView yes = dialog.findViewById(R.id.yes);
        TextView no = dialog.findViewById(R.id.no);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finishAffinity();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void rulesDialog() {
        Dialog dialog2 = new Dialog(TopicActivity.this);
        dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog2.setContentView(R.layout.rules);
        dialog2.setCanceledOnTouchOutside(true);
        TextView ok = dialog2.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.dismiss();
            }
        });
        dialog2.show();
    }
}
