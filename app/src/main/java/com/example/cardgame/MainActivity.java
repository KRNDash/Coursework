package com.example.cardgame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    //кнопки цветов рубашки карточек
    public Button button; //серый
    public Button button13; //синий
    public Button button14; //красный
    public Button button15; //зеленый

    public RadioButton rb4; // цвета
    public RadioButton rb5; // цифры
    public RadioButton rb6; // буквы
    public RadioButton rb7; // картинки

    public RadioGroup rg1; // уровни
    public RadioGroup rg2; // вид карточек

    public RadioButton rbE; // легкий
    public RadioButton rbM; // средний
    public RadioButton rbH; // сложный

    Button start;
    public static String defColor = "#ABABAB";

    public static byte choiceTheme = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);

        rg1.clearCheck();
        rg2.clearCheck();

        rg1.setOnCheckedChangeListener(listener1);
        rg2.setOnCheckedChangeListener(listener2);

        // уровни
        rbE = findViewById(R.id.easy);
        rbM = findViewById(R.id.medium);
        rbH = findViewById(R.id.hard);

        // вид карточек
        rb4 = findViewById(R.id.radioButton4);
        rb4.setChecked(true);
        rb5 = findViewById(R.id.radioButton5);
        rb6 = findViewById(R.id.radioButton6);
        rb7 = findViewById(R.id.radioButton7);


        // выбор цвета карточек
        button = findViewById(R.id.button);
        button.setEnabled(false);

        button.setText("+");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defColor = "#ABABAB";
                button.setEnabled(false);
                button13.setEnabled(true);
                button14.setEnabled(true);
                button15.setEnabled(true);

                button.setText("+");
                button13.setText("");
                button14.setText("");
                button15.setText("");

            }
        });

        button13 = findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defColor = "#374164";
                button13.setEnabled(false);
                button.setEnabled(true);
                button14.setEnabled(true);
                button15.setEnabled(true);

                button13.setText("+");
                button.setText("");
                button14.setText("");
                button15.setText("");
            }
        });
        button14 = findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defColor = "#6D2A2A";
                button14.setEnabled(false);
                button.setEnabled(true);
                button13.setEnabled(true);
                button15.setEnabled(true);

                button14.setText("+");
                button.setText("");
                button13.setText("");
                button15.setText("");
            }
        });

        button15 = findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defColor = "#376451";
                button15.setEnabled(false);
                button.setEnabled(true);
                button13.setEnabled(true);
                button14.setEnabled(true);

                button15.setText("+");
                button13.setText("");
                button14.setText("");
                button.setText("");
            }
        });

        start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb4.isChecked()) {
                    choiceTheme = 1;
                }
                else if (rb5.isChecked()) {
                    choiceTheme = 2;
                }
                else if (rb6.isChecked()) {
                    choiceTheme = 3;
                }
                else if (rb7.isChecked()) {
                    choiceTheme = 4;
                }

                if (rbE.isChecked()) {
                    GameActivity.size = 12;
                }
                else if(rbM.isChecked()) {
                    GameActivity.size = 16;
                }
                else if(rbH.isChecked()) {
                    GameActivity.size = 20;
                }
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(intent);
            }
        });
    }


    private RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rg2.setOnCheckedChangeListener(null);
                rg2.clearCheck();
                rg2.setOnCheckedChangeListener(listener2);
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rg1.setOnCheckedChangeListener(null);
                rg1.clearCheck();
                rg1.setOnCheckedChangeListener(listener1);
            }
        }
    };
}