package com.example.cardgame.gamelogic;

import android.view.View;
import android.widget.ImageButton;
import com.example.cardgame.GameActivity;
import com.example.cardgame.MainActivity;
import com.example.cardgame.R;
import java.util.ArrayList;
import java.util.Random;

public class GameField {
    //Массив кнопок для инициализации
    private ImageButton[] btn;

    //Список карточек
    public ArrayList<Card> cardSet = new ArrayList<>();

    //Подсчёт очков
    public static int pointsCounter = 0;

    //Поля для сравнения двух карточек
    private static Card btn1;
    private static Card btn2;
    public static int counter = 0;

    //счётчик цветов
    public int one = 0;
    public int two = 0;
    public int three = 0;
    public int four = 0;
    public int five = 0;
    public int six = 0;
    public int seven = 0;
    public int eight = 0;
    public int nine = 0;
    public int ten = 0;

    //Размеры игрового поля
    public static int fieldSize = 0;

    public void setBtn(ImageButton[] newBtn) {
        this.btn = newBtn;
    }

    //Конструктор
    public GameField(int newFieldSize) {
        pointsCounter = 0;
        fieldSize = newFieldSize;
    }

    // очистка всех полей для новой игры
    public void ClearFields() {
        one = 0;
        two = 0;
        three = 0;
        four = 0;
        five = 0;
        six = 0;
        seven = 0;
        eight = 0;
        nine = 0;
        ten = 0;

        pointsCounter = 0;
        counter = 0;
        cardSet.clear();
    }


    // выбор способа загадывания карточек
    public void cardSetInit() {
        for (int i = 0; i < fieldSize; i++) {
            cardSet.add(new Card(btn[i], MainActivity.defColor));
            switch (MainActivity.choiceTheme) {
                case 1: {
                    ChooseColor(i);
                    break;
                }
                case 2: {
                    ChooseNum(i);
                    break;
                }
                case 3: {
                    ChooseLetter(i);
                    break;
                }
                case 4: {
                    ChooseImage(i);
                    break;
                }
            }
        }
    }

    // сравнение открытых карточек
    public static void compareCards(Card btn) {
        if (counter == 0) {
            // открываем карточку 1
            btn1 = btn;
            btn1.setDisabled();
            counter++;
        } else if (counter == 1) {
            // открываем карточку 2
            btn2 = btn;
            btn2.setDisabled();
            pointsCounter++;
            counter++;
        } else if (counter == 2) {
            // открываем карточку 3
            if (CompareTypes()) {
                btn1.setInvisible();
                btn2.setInvisible();

                btn1 = btn;
                counter = 1;
            } else {
                pointsCounter--;
                btn1.CloseCard();
                btn2.CloseCard();
                btn1.setEnabled();
                btn2.setEnabled();

                btn1 = btn;
                counter = 1;
                btn1.setDisabled();
            }
            if (pointsCounter < 0) {
                pointsCounter = 0;
            }
            GameActivity.pointsCounterT.setText(String.valueOf(pointsCounter));
        }
        // финал игры
        if (pointsCounter == (fieldSize / 2)) {
            GameActivity.pointsCounterT.setText(String.valueOf(pointsCounter));
            GameActivity.btnReload.setVisibility(View.VISIBLE);
        }
    }

    // сравнение 2х карточек по цветам или картинкам
    public static boolean CompareTypes() {
        switch (MainActivity.choiceTheme) {
            //по цветам
            case 1: {
                if (btn1.getColor() == btn2.getColor()) {
                    return true;
                } else {
                    return false;
                }
            }
            // по картинкам
            case 2:
            case 3:
            case 4: {
                if (btn1.getImage() == btn2.getImage()) {
                    return true;
                } else {
                    return false;
                }
            }
            default: {
                return false;
            }
        }
    }

    // назначение цветов
    public void ChooseColor(int i) {
        Random random = new Random();
        int rand = random.nextInt(fieldSize / 2);
        switch (rand) {
            case 0: {
                if (one < 2) {
                    cardSet.get(i).setColor("#3B6DEE");
                    one++;
                } else {
                    ChooseColor(i);
                }
                break;
            }
            case 1: {
                if (two < 2) {
                    cardSet.get(i).setColor("#3D3D3D");
                    two++;
                } else {
                    ChooseColor(i);
                }
                break;
            }
            case 2: {
                if (three < 2) {
                    cardSet.get(i).setColor("#6AB74F");
                    three++;
                } else {
                    ChooseColor(i);
                }
                break;
            }
            case 3: {
                if (four < 2) {
                    cardSet.get(i).setColor("#6DD8BE");
                    four++;
                } else {
                    ChooseColor(i);
                }
                break;
            }
            case 4: {
                if (five < 2) {
                    cardSet.get(i).setColor("#884FAB");
                    five++;
                } else {
                    ChooseColor(i);
                }
                break;
            }
            case 5: {
                if (six < 2) {
                    cardSet.get(i).setColor("#B42626");
                    six++;
                } else {
                    ChooseColor(i);
                }
                break;
            }
            case 6: {
                if (seven < 2) {
                    cardSet.get(i).setColor("#CFE00E");
                    seven++;
                } else {
                    ChooseColor(i);
                }
                break;
            }
            case 7: {
                if (eight < 2) {
                    cardSet.get(i).setColor("#E15297");
                    eight++;
                } else {
                    ChooseColor(i);
                }
                break;
            }
            case 8: {
                if (nine < 2) {
                    cardSet.get(i).setColor("#FBD490");
                    nine++;
                } else {
                    ChooseColor(i);
                }
                break;
            }
            case 9: {
                if (ten < 2) {
                    cardSet.get(i).setColor("#FF6D3F");
                    ten++;
                } else {
                    ChooseColor(i);
                }
                break;
            }
        }
    }

    // назначение номеров
    public void ChooseNum(int i) {
        Random random = new Random();
        int rand = random.nextInt(fieldSize / 2);
        switch (rand) {
            case 0: {
                if (one < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__1);
                    one++;
                } else {
                    ChooseNum(i);
                }
                break;
            }
            case 1: {
                if (two < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__2);
                    two++;
                } else {
                    ChooseNum(i);
                }
                break;
            }
            case 2: {
                if (three < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__3);
                    three++;
                } else {
                    ChooseNum(i);
                }
                break;
            }
            case 3: {
                if (four < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__4);
                    four++;
                } else {
                    ChooseNum(i);
                }
                break;
            }
            case 4: {
                if (five < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__5);
                    five++;
                } else {
                    ChooseNum(i);
                }
                break;
            }
            case 5: {
                if (six < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__6);
                    six++;
                } else {
                    ChooseNum(i);
                }
                break;
            }
            case 6: {
                if (seven < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__7);
                    seven++;
                } else {
                    ChooseNum(i);
                }
                break;
            }
            case 7: {
                if (eight < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__8);
                    eight++;
                } else {
                    ChooseNum(i);
                }
                break;
            }
            case 8: {
                if (nine < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__9);
                    nine++;
                } else {
                    ChooseNum(i);
                }
                break;
            }
            case 9: {
                if (ten < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__10);
                    ten++;
                } else {
                    ChooseNum(i);
                }
                break;
            }
        }
    }

    // назначение букв
    public void ChooseLetter(int i) {
        Random random = new Random();
        int rand = random.nextInt(fieldSize / 2);
        switch (rand) {
            case 0: {
                if (one < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__a);
                    one++;
                } else {
                    ChooseLetter(i);
                }
                break;
            }
            case 1: {
                if (two < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__b);
                    two++;
                } else {
                    ChooseLetter(i);
                }
                break;
            }
            case 2: {
                if (three < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__c);
                    three++;
                } else {
                    ChooseLetter(i);
                }
                break;
            }
            case 3: {
                if (four < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__d);
                    four++;
                } else {
                    ChooseLetter(i);
                }
                break;
            }
            case 4: {
                if (five < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__e);
                    five++;
                } else {
                    ChooseLetter(i);
                }
                break;
            }
            case 5: {
                if (six < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__f);
                    six++;
                } else {
                    ChooseLetter(i);
                }
                break;
            }
            case 6: {
                if (seven < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__g);
                    seven++;
                } else {
                    ChooseLetter(i);
                }
                break;
            }
            case 7: {
                if (eight < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__h);
                    eight++;
                } else {
                    ChooseLetter(i);
                }
                break;
            }
            case 8: {
                if (nine < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__i);
                    nine++;
                } else {
                    ChooseLetter(i);
                }
                break;
            }
            case 9: {
                if (ten < 2) {
                    cardSet.get(i).setImage(R.drawable.ic__k);
                    ten++;
                } else {
                    ChooseLetter(i);
                }
                break;
            }
        }
    }

    // назначение картинок
    public void ChooseImage(int i) {
        Random random = new Random();
        int rand = random.nextInt(fieldSize / 2);
        switch (rand) {
            case 0: {
                if (one < 2) {
                    cardSet.get(i).setImage(R.drawable.ic_apple);
                    one++;
                } else {
                    ChooseImage(i);
                }
                break;
            }
            case 1: {
                if (two < 2) {
                    cardSet.get(i).setImage(R.drawable.ic_aubergine);
                    two++;
                } else {
                    ChooseImage(i);
                }
                break;
            }
            case 2: {
                if (three < 2) {
                    cardSet.get(i).setImage(R.drawable.ic_carrot);
                    three++;
                } else {
                    ChooseImage(i);
                }
                break;
            }
            case 3: {
                if (four < 2) {
                    cardSet.get(i).setImage(R.drawable.ic_chili);
                    four++;
                } else {
                    ChooseImage(i);
                }
                break;
            }
            case 4: {
                if (five < 2) {
                    cardSet.get(i).setImage(R.drawable.ic_egg);
                    five++;
                } else {
                    ChooseImage(i);
                }
                break;
            }
            case 5: {
                if (six < 2) {
                    cardSet.get(i).setImage(R.drawable.ic_fish);
                    six++;
                } else {
                    ChooseImage(i);
                }
                break;
            }
            case 6: {
                if (seven < 2) {
                    cardSet.get(i).setImage(R.drawable.ic_lemon);
                    seven++;
                } else {
                    ChooseImage(i);
                }
                break;
            }
            case 7: {
                if (eight < 2) {
                    cardSet.get(i).setImage(R.drawable.ic_milk);
                    eight++;
                } else {
                    ChooseImage(i);
                }
                break;
            }
            case 8: {
                if (nine < 2) {
                    cardSet.get(i).setImage(R.drawable.ic_orange);
                    nine++;
                } else {
                    ChooseImage(i);
                }
                break;
            }
            case 9: {
                if (ten < 2) {
                    cardSet.get(i).setImage(R.drawable.ic_salad);
                    ten++;
                } else {
                    ChooseImage(i);
                }
                break;
            }
        }
    }
}