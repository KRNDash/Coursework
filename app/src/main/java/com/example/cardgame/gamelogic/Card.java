package com.example.cardgame.gamelogic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;

import com.example.cardgame.MainActivity;
import com.example.cardgame.R;

public class Card  {
    private ImageButton card;

    //Цвет карточки (скрытый)
    private String color = "FF0000";

    // картинка карточки
    private int image = R.drawable.ic_apple;

    // фон карточки с картинкой
    private String defImageColor = "#F2F2F2";

    //Цвет рубашки
    private String defColor = "#000000";

    // открыта/закрыта
    private boolean check;

    // назначить цвет
    public void setColor(String color) {
        this.color = color;
    }

    // назначить картинку
    public void setImage(int image) {
        this.image = image;
    }

    // получить цвет
    public String getColor() {
        return this.color;
    }

    // получить картинку
    public int getImage() {
        return this.image;
    }

    // установить цвет рубашки
    public void setDefColor(String defColor) {
        this.defColor = defColor;
    }

    //КОНСТРУКТОР
    public Card(ImageButton btn, String def) {
        card = btn;
        card.setOnClickListener(btnListener);

        setDefColor(def);
        card.setBackgroundColor(Color.parseColor(defColor));
    }

    //Обработка нажатия на карточку
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //ObjectAnimator имеет упрощённый интерфейс для анимации свойств View
            //Поворот карточки (открытие)
            final ObjectAnimator oa1 = ObjectAnimator.ofFloat(card, "scaleX", 1f, 0f);
            //Поворот карточки (закрытие)
            final ObjectAnimator oa2 = ObjectAnimator.ofFloat(card, "scaleX", 0f, 1f);

            //Имитация реального переворота карточки
            oa1.setInterpolator(new DecelerateInterpolator());
            oa2.setInterpolator(new AccelerateDecelerateInterpolator());


            oa1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);

                    if (!IsOpen()) {
                        OpenCard();
                    } else {
                        CloseCard();
                    }
                    oa2.start();
                }
            });
            oa1.start();
        }
    };


    //ОТКРЫТЬ КАРТОЧКУ
    public void OpenCard() {
        check = true;
        switch (MainActivity.choiceTheme) {
            case 1: {
                SetColor();
                break;
            }
            case 2: {
                SetNum();
                break;
            }
            case 3: {
                SetLetter();
                break;
            }
            case 4: {
                SetImage ();
                break;
            }
        }
        GameField.compareCards(this);
    }

    //ЗАКРЫТЬ КАРТОЧКУ
    public void CloseCard() {
        check = false;
        card.setBackgroundColor(Color.parseColor(defColor));
        card.setImageDrawable(null);
    }



    //НАЗНАЧИТЬ ЦВЕТ
    public void SetColor () {
        card.setBackgroundColor(Color.parseColor(color));
    }

    //НАЗНАЧИТЬ ЦИФРУ
    public void SetNum () {
        card.setBackgroundColor(Color.parseColor(defImageColor));
        card.setImageResource(image);
    }

    //НАЗНАЧИТЬ БУКВУ
    public void SetLetter () {
        card.setBackgroundColor(Color.parseColor(defImageColor));
        card.setImageResource(image);
    }

    //НАЗНАЧИТЬ КАРТИНКУ
    public void SetImage () {
        card.setBackgroundColor(Color.parseColor(defImageColor));
        card.setImageResource(image);
    }



    //Невидимость
    public void setInvisible () {
        card.setVisibility(View.INVISIBLE);
    }

    //Видимость
    public void setVisible () {
        card.setVisibility(View.VISIBLE);
    }

    //Проверка на открытие
    public boolean IsOpen() {
        return check;
    }

    //Неактивна
    public void setDisabled() {
        card.setEnabled(false);
    }

    //Активна
    public void setEnabled() {
        card.setEnabled(true);
    }
}
