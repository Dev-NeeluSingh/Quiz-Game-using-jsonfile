package com.example.guessthename;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import java.text.DecimalFormat;

public class LevelsActivity extends Activity implements View.OnClickListener {
    CardView cd1, cd2, cd3, cd4, cd5, cd6, cd7, cd8, cd9, cd10, cd11, cd12, cd13, cd14, cd15, cd16, cd17, cd18, cd19, cd20, cd21, cd22, cd23, cd24, cd25;
    SharedPreferences sf;
    Intent intent = new Intent();
    TextView curLevel;
    int n = 0, p = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels_layout);
        cd1 = findViewById(R.id.cd1);
        cd2 = findViewById(R.id.cd2);
        cd3 = findViewById(R.id.cd3);
        cd4 = findViewById(R.id.cd4);
        cd5 = findViewById(R.id.cd5);
        cd6 = findViewById(R.id.cd6);
        cd7 = findViewById(R.id.cd7);
        cd8 = findViewById(R.id.cd8);
        cd9 = findViewById(R.id.cd9);
        cd10 = findViewById(R.id.cd10);
        cd11 = findViewById(R.id.cd11);
        cd12 = findViewById(R.id.cd12);
        cd13 = findViewById(R.id.cd13);
        cd14 = findViewById(R.id.cd14);
        cd15 = findViewById(R.id.cd15);
        cd16 = findViewById(R.id.cd16);
        cd17 = findViewById(R.id.cd17);
        cd18 = findViewById(R.id.cd18);
        cd19 = findViewById(R.id.cd19);
        cd20 = findViewById(R.id.cd20);
        cd21 = findViewById(R.id.cd21);
        cd22 = findViewById(R.id.cd22);
        cd23 = findViewById(R.id.cd23);
        cd24 = findViewById(R.id.cd24);
        cd25 = findViewById(R.id.cd25);

        cd1.setOnClickListener(this);
        cd2.setOnClickListener(this);
        cd3.setOnClickListener(this);
        cd4.setOnClickListener(this);
        cd5.setOnClickListener(this);
        cd6.setOnClickListener(this);
        cd7.setOnClickListener(this);
        cd8.setOnClickListener(this);
        cd9.setOnClickListener(this);
        cd10.setOnClickListener(this);
        cd11.setOnClickListener(this);
        cd12.setOnClickListener(this);
        cd13.setOnClickListener(this);
        cd14.setOnClickListener(this);
        cd15.setOnClickListener(this);
        cd16.setOnClickListener(this);
        cd17.setOnClickListener(this);
        cd18.setOnClickListener(this);
        cd19.setOnClickListener(this);
        cd20.setOnClickListener(this);
        cd21.setOnClickListener(this);
        cd22.setOnClickListener(this);
        cd23.setOnClickListener(this);
        cd24.setOnClickListener(this);
        cd25.setOnClickListener(this);

        curLevel = findViewById(R.id.curLevel);

        sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
        setUnEnable();
        switch (getIntent().getStringExtra("topic")) {
            case "cars":
                cars();
                break;
            case "foods":
                foods();
                break;
            case "electrics":
                electrics();
                break;
            case "bikes":
                bikes();
                break;
            default:
                Toast.makeText(LevelsActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().setStatusBarColor(getResources().getColor(R.color.yellow));
    }

    public void setUnEnable() {
        cd2.setEnabled(false);
        cd3.setEnabled(false);
        cd4.setEnabled(false);
        cd5.setEnabled(false);
        cd6.setEnabled(false);
        cd7.setEnabled(false);
        cd8.setEnabled(false);
        cd9.setEnabled(false);
        cd10.setEnabled(false);

        cd11.setEnabled(false);
        cd12.setEnabled(false);
        cd13.setEnabled(false);
        cd14.setEnabled(false);
        cd15.setEnabled(false);
        cd16.setEnabled(false);
        cd17.setEnabled(false);
        cd18.setEnabled(false);
        cd19.setEnabled(false);
        cd20.setEnabled(false);

        cd21.setEnabled(false);
        cd22.setEnabled(false);
        cd23.setEnabled(false);
        cd24.setEnabled(false);
        cd25.setEnabled(false);
    }

    private void bikes() {
        CardView[] myCards = {cd1, cd2, cd3, cd4, cd5, cd6, cd7, cd8, cd9, cd10, cd11, cd12, cd13, cd14, cd15, cd16, cd17, cd18, cd19, cd20, cd21, cd22, cd23, cd24, cd25};
        if (sf.getString("bikes", "0").equals("")) {
            Toast.makeText(LevelsActivity.this, "Error", Toast.LENGTH_SHORT).show();
        } else {
            try {
                p = Integer.parseInt(sf.getString("bikes", "0"));
                for (n = 0; n < p; n++) {
                    CardView tempCard = myCards[n];
                    tempCard.setCardBackgroundColor(0xFF7CB342);
                    curLevel.setText(new DecimalFormat("00").format(p));
                    tempCard.setEnabled(true);
                }
            } catch (Exception e) {
                Toast.makeText(LevelsActivity.this, "Please restart game", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void electrics() {
        CardView[] myCards = {cd1, cd2, cd3, cd4, cd5, cd6, cd7, cd8, cd9, cd10, cd11, cd12, cd13, cd14, cd15, cd16, cd17, cd18, cd19, cd20, cd21, cd22, cd23, cd24, cd25};
        if (sf.getString("electrics", "0").equals("")) {
            Toast.makeText(LevelsActivity.this, "Error", Toast.LENGTH_SHORT).show();
        } else {
            try {
                p = Integer.parseInt(sf.getString("electrics", "0"));
                for (n = 0; n < p; n++) {
                    CardView tempCard = myCards[n];
                    tempCard.setCardBackgroundColor(0xFF7CB342);
                    curLevel.setText(new DecimalFormat("00").format(p));
                    tempCard.setEnabled(true);
                }
            } catch (Exception e) {
                Toast.makeText(LevelsActivity.this, "Please restart game", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void foods() {
        CardView[] myCards = {cd1, cd2, cd3, cd4, cd5, cd6, cd7, cd8, cd9, cd10, cd11, cd12, cd13, cd14, cd15, cd16, cd17, cd18, cd19, cd20, cd21, cd22, cd23, cd24, cd25};
        if (sf.getString("foods", "0").equals("")) {
            Toast.makeText(LevelsActivity.this, "Error", Toast.LENGTH_SHORT).show();
        } else {
            try {
                p = Integer.parseInt(sf.getString("foods", "0"));
                for (n = 0; n < p; n++) {
                    CardView tempCard = myCards[n];
                    tempCard.setCardBackgroundColor(0xFF7CB342);
                    curLevel.setText(new DecimalFormat("00").format(p));
                    tempCard.setEnabled(true);
                }
            } catch (Exception e) {
                Toast.makeText(LevelsActivity.this, "Please restart game", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void cars() {
        CardView[] myCards = {cd1, cd2, cd3, cd4, cd5, cd6, cd7, cd8, cd9, cd10, cd11, cd12, cd13, cd14, cd15, cd16, cd17, cd18, cd19, cd20, cd21, cd22, cd23, cd24, cd25};
        if (sf.getString("cars", "").equals("")) {
            Toast.makeText(LevelsActivity.this, "Error", Toast.LENGTH_SHORT).show();
        } else {
            try {
                p = Integer.parseInt(sf.getString("cars", ""));
                for (n = 0; n < p; n++) {
                    CardView tempCard = myCards[n];
                    tempCard.setCardBackgroundColor(0xFF7CB342);
                    curLevel.setText(new DecimalFormat("00").format(p));
                    tempCard.setEnabled(true);
                }
            } catch (Exception e) {
                Log.i("error", e.toString());
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.cd1) {
            toSend("0");
        } else if (view.getId() == R.id.cd2) {
            toSend("1");
        } else if (view.getId() == R.id.cd3) {
            toSend("2");
        } else if (view.getId() == R.id.cd4) {
            toSend("3");
        } else if (view.getId() == R.id.cd5) {
            toSend("4");
        } else if (view.getId() == R.id.cd6) {
            toSend("5");
        } else if (view.getId() == R.id.cd7) {
            toSend("6");
        } else if (view.getId() == R.id.cd8) {
            toSend("7");
        } else if (view.getId() == R.id.cd9) {
            toSend("8");
        } else if (view.getId() == R.id.cd10) {
            toSend("9");
        } else if (view.getId() == R.id.cd11) {
            toSend("10");
        } else if (view.getId() == R.id.cd12) {
            toSend("11");
        } else if (view.getId() == R.id.cd13) {
            toSend("12");
        } else if (view.getId() == R.id.cd14) {
            toSend("13");
        } else if (view.getId() == R.id.cd15) {
            toSend("14");
        } else if (view.getId() == R.id.cd16) {
            toSend("15");
        } else if (view.getId() == R.id.cd17) {
            toSend("16");
        } else if (view.getId() == R.id.cd18) {
            toSend("17");
        } else if (view.getId() == R.id.cd19) {
            toSend("18");
        } else if (view.getId() == R.id.cd20) {
            toSend("19");
        } else if (view.getId() == R.id.cd21) {
            toSend("20");
        } else if (view.getId() == R.id.cd22) {
            toSend("21");
        } else if (view.getId() == R.id.cd23) {
            toSend("22");
        } else if (view.getId() == R.id.cd24) {
            toSend("23");
        } else if (view.getId() == R.id.cd25) {
            toSend("24");
        }
    }

    public void toSend(String toPlay) {
        intent.setClass(LevelsActivity.this, PlaygroundActivity.class);
        intent.putExtra("topic", getIntent().getStringExtra("topic"));
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("toPlay", toPlay);
        startActivity(intent);
    }

}
