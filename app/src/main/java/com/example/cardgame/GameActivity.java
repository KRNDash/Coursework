package com.example.cardgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.cardgame.gamelogic.GameField;

public class GameActivity extends AppCompatActivity {

    //размер по умолчанию
    public static int size = 12;

    // объект класс-группы карточного поля
    public GameField gameField;

    //Массив кнопок для инициализации
    private ImageButton[] btn;

    //отступ между кнопками
    private int indent = 10;

    //Кнопка перезапуска
    public static Button btnReload;

    //Кнопка назад
    public static ImageButton btnBack;

    //Кол-во очков игрока
    public static TextView pointsCounterT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        cardInit();
        gameField = new GameField(size);
        gameField.setBtn(btn);
        gameField.cardSetInit();

        pointsCounterT = findViewById(R.id.textView);

        // кнопка назад
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            gameField.pointsCounter = 0;
            pointsCounterT.setText("0");
            finish();
        });

        //кнопка заново (скрыта по умолчанию)
        btnReload = findViewById(R.id.btnReload);
        btnReload.setVisibility(View.GONE);

        btnReload.setOnClickListener(v -> {
            gameField.pointsCounter = 0;
            pointsCounterT.setText(String.valueOf(gameField.pointsCounter));

            // скрываем все карточки
            for (int i = 0; i < size; i++) {
                gameField.cardSet.get(i).CloseCard();
                gameField.cardSet.get(i).setEnabled();
                gameField.cardSet.get(i).setVisible();
            }
            // перезагадываем картинки
            gameField.ClearFields();
            gameField.cardSetInit();

            btnReload.setVisibility(View.GONE);
        });
    }

    // инициализируем кнопки на виде
    public void cardInit() {
        this.btn = new ImageButton[size];
        for (int i = 0; i < 20; i++) {
            String buttonID = "button" + (i + 1);
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            if (i < size) {
                btn[i] = findViewById(resourceID);
                btn[i].setPadding(indent, indent,indent, indent);
            }
            else {
                // ненужные кнопки скрываем
                ImageButton b = findViewById(resourceID);
                b.setVisibility(View.GONE);
            }
        }
    }
}