package com.example.guessthename;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class PlaygroundActivity extends Activity {
    TextView quesID, qNum;
    RadioButton rb1, rb2, rb3, rb4;
    ImageView image;
    SharedPreferences sf;
    int recLevel = 0;
    HashMap<String, Object> myMap = new HashMap<>();

    ArrayList<HashMap<String, Object>> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playground_layout);

        quesID = findViewById(R.id.quesID);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        image = findViewById(R.id.image);
        qNum = findViewById(R.id.qNum);
        sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswer("rb1");
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswer("rb2");
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswer("rb3");
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswer("rb4");
            }
        });

        switch (getIntent().getStringExtra("topic")) {
            case "cars":
                quesID.setText("Q. Guess the car brand ?");
                loadJson("cars.json", PlaygroundActivity.this);
                break;
            case "bikes":
                quesID.setText("Q. Guess the bike brand ?");
                loadJson("bikes.json", PlaygroundActivity.this);
                break;
            case "foods":
                quesID.setText("Q. Guess food item's name ?");
                loadJson("foods.json", PlaygroundActivity.this);
                break;
            case "electrics":
                quesID.setText("Q. Guess the electronic brand ?");
                loadJson("electrics.json", PlaygroundActivity.this);
                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(getResources().getColor(R.color.yellow));
    }

    public void loadJson(String jsonName, Context context) {
        try {
            recLevel = Integer.parseInt(getIntent().getStringExtra("toPlay"));
            InputStream inputStream = context.getAssets().open(jsonName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            String json = sb.toString();
            myList = new Gson().fromJson(json, new TypeToken<ArrayList<HashMap<String, Object>>>() {
            }.getType());
            myMap = myList.get(recLevel);
            qNum.setText(new DecimalFormat("00").format(recLevel + 1));
            rb1.setText(myMap.get("a").toString());
            rb2.setText(myMap.get("b").toString());
            rb3.setText(myMap.get("c").toString());
            rb4.setText(myMap.get("d").toString());
            image.setImageResource(getResources().getIdentifier(myMap.get("pic").toString(), "drawable", getPackageName()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleAnswer(String choosenAns) {
        switch (choosenAns) {
            case "rb1":
                if (rb1.getText().toString().equals(myMap.get("ans").toString())) {
                    rb1.setBackgroundResource(R.drawable.corr);
                    rb1.setTextColor(0xFFFFFFFF);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            nextQues();
                        }
                    }, 800);
                    setLevel();

                } else {
                    if (rb2.getText().toString().equals(myMap.get("ans").toString())) {
                        rb2.setBackgroundResource(R.drawable.corr);
                        rb2.setTextColor(0xFFFFFFFF);

                    } else if (rb3.getText().toString().equals(myMap.get("ans").toString())) {
                        rb3.setBackgroundResource(R.drawable.corr);
                        rb3.setTextColor(0xFFFFFFFF);

                    } else if (rb4.getText().toString().equals(myMap.get("ans").toString())) {
                        rb4.setBackgroundResource(R.drawable.corr);
                        rb4.setTextColor(0xFFFFFFFF);
                    }
                    rb1.setBackgroundResource(R.drawable.wron);
                    rb1.setTextColor(0xFFFFFFFF);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            defaultLevel();
                        }
                    }, 800);
                }
                radioBtnDisable();
                break;
            case "rb2":
                if (rb2.getText().toString().equals(myMap.get("ans").toString())) {
                    rb2.setBackgroundResource(R.drawable.corr);
                    rb2.setTextColor(0xFFFFFFFF);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            nextQues();
                        }
                    }, 800);
                    setLevel();

                } else {
                    if (rb1.getText().toString().equals(myMap.get("ans").toString())) {
                        rb1.setBackgroundResource(R.drawable.corr);
                        rb1.setTextColor(0xFFFFFFFF);

                    } else if (rb3.getText().toString().equals(myMap.get("ans").toString())) {
                        rb3.setBackgroundResource(R.drawable.corr);
                        rb3.setTextColor(0xFFFFFFFF);

                    } else if (rb4.getText().toString().equals(myMap.get("ans").toString())) {
                        rb4.setBackgroundResource(R.drawable.corr);
                        rb4.setTextColor(0xFFFFFFFF);
                    }
                    rb2.setBackgroundResource(R.drawable.wron);
                    rb2.setTextColor(0xFFFFFFFF);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            defaultLevel();
                        }
                    }, 800);
                }
                radioBtnDisable();
                break;
            case "rb3":
                if (rb3.getText().toString().equals(myMap.get("ans").toString())) {
                    rb3.setBackgroundResource(R.drawable.corr);
                    rb3.setTextColor(0xFFFFFFFF);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            nextQues();
                        }
                    }, 800);
                    setLevel();

                } else {
                    if (rb2.getText().toString().equals(myMap.get("ans").toString())) {
                        rb2.setBackgroundResource(R.drawable.corr);
                        rb2.setTextColor(0xFFFFFFFF);

                    } else if (rb1.getText().toString().equals(myMap.get("ans").toString())) {
                        rb1.setBackgroundResource(R.drawable.corr);
                        rb1.setTextColor(0xFFFFFFFF);

                    } else if (rb4.getText().toString().equals(myMap.get("ans").toString())) {
                        rb4.setBackgroundResource(R.drawable.corr);
                        rb4.setTextColor(0xFFFFFFFF);
                    }
                    rb3.setBackgroundResource(R.drawable.wron);
                    rb3.setTextColor(0xFFFFFFFF);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            defaultLevel();
                        }
                    }, 800);
                }
                radioBtnDisable();
                break;
            case "rb4":
                if (rb4.getText().toString().equals(myMap.get("ans").toString())) {
                    rb4.setBackgroundResource(R.drawable.corr);
                    rb4.setTextColor(0xFFFFFFFF);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            nextQues();
                        }
                    }, 800);
                    setLevel();

                } else {
                    if (rb2.getText().toString().equals(myMap.get("ans").toString())) {
                        rb2.setBackgroundResource(R.drawable.corr);
                        rb2.setTextColor(0xFFFFFFFF);

                    } else if (rb3.getText().toString().equals(myMap.get("ans").toString())) {
                        rb3.setBackgroundResource(R.drawable.corr);
                        rb3.setTextColor(0xFFFFFFFF);

                    } else if (rb1.getText().toString().equals(myMap.get("ans").toString())) {
                        rb1.setBackgroundResource(R.drawable.corr);
                        rb1.setTextColor(0xFFFFFFFF);
                    }
                    rb4.setBackgroundResource(R.drawable.wron);
                    rb4.setTextColor(0xFFFFFFFF);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            defaultLevel();
                        }
                    }, 800);
                }
                radioBtnDisable();
                break;
        }
    }

    public void setLevel() {
        switch (getIntent().getStringExtra("topic")) {
            case "cars":
                sf.edit().putString("cars", myMap.get("level").toString()).apply();
                break;
            case "foods":
                sf.edit().putString("foods", myMap.get("level").toString()).apply();
                break;
            case "electrics":
                sf.edit().putString("electrics", myMap.get("level").toString()).apply();
                break;
            case "bikes":
                sf.edit().putString("bikes", myMap.get("level").toString()).apply();
                break;
        }
    }

    public void defaultLevel() {
        recLevel = 0;
        rb1.setBackgroundResource(R.drawable.one);
        rb2.setBackgroundResource(R.drawable.one);
        rb3.setBackgroundResource(R.drawable.one);
        rb4.setBackgroundResource(R.drawable.one);
        rb1.setTextColor(0xFF000000);
        rb2.setTextColor(0xFF000000);
        rb3.setTextColor(0xFF000000);
        rb4.setTextColor(0xFF000000);

        myMap = myList.get(recLevel);
        qNum.setText(new DecimalFormat("00").format(recLevel + 1));
        rb1.setText(myMap.get("a").toString());
        rb2.setText(myMap.get("b").toString());
        rb3.setText(myMap.get("c").toString());
        rb4.setText(myMap.get("d").toString());
        image.setImageResource(getResources().getIdentifier(myMap.get("pic").toString(), "drawable", getPackageName()));

        rb1.setEnabled(true);
        rb2.setEnabled(true);
        rb3.setEnabled(true);
        rb4.setEnabled(true);

        switch (getIntent().getStringExtra("topic")) {
            case "cars":
                sf.edit().putString("cars", "0").apply();
                break;
            case "foods":
                sf.edit().putString("foods", "0").apply();
                break;
            case "electrics":
                sf.edit().putString("electrics", "0").apply();
                break;
            case "bikes":
                sf.edit().putString("bikes", "0").apply();
                break;
        }
    }

    public void radioBtnDisable() {
        rb1.setEnabled(false);
        rb2.setEnabled(false);
        rb3.setEnabled(false);
        rb4.setEnabled(false);
    }

    public void nextQues() {
        if (recLevel < 24) {
            recLevel += 1;
            myMap = myList.get(recLevel);
            rb1.setText(myMap.get("a").toString());
            rb2.setText(myMap.get("b").toString());
            rb3.setText(myMap.get("c").toString());
            rb4.setText(myMap.get("d").toString());
            qNum.setText(new DecimalFormat("00").format(recLevel + 1));
            image.setImageResource(getResources().getIdentifier(myMap.get("pic").toString(), "drawable", getPackageName()));


            rb1.setBackgroundResource(R.drawable.one);
            rb2.setBackgroundResource(R.drawable.one);
            rb3.setBackgroundResource(R.drawable.one);
            rb4.setBackgroundResource(R.drawable.one);
            rb1.setTextColor(0xFF000000);
            rb2.setTextColor(0xFF000000);
            rb3.setTextColor(0xFF000000);
            rb4.setTextColor(0xFF000000);

            rb1.setEnabled(true);
            rb2.setEnabled(true);
            rb3.setEnabled(true);
            rb4.setEnabled(true);
        } else if (recLevel == 24) {
            recLevel = 24;
            myDialog();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.setClass(PlaygroundActivity.this, TopicActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void myDialog() {
        Dialog dialog = new Dialog(PlaygroundActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog);
        dialog.setCanceledOnTouchOutside(true);
        TextView text1 = dialog.findViewById(R.id.dialog_Text);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent();
                intent.setClass(PlaygroundActivity.this, TopicActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
        dialog.show();
    }
}