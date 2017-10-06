package Controlers;

import org.springframework.stereotype.Component;

@Component
public class CheckWins {

    public int[] winsChech(int[] array) {
        // наборы выигрышных комбинаций (8 комбинаций)
        int[] wins = {1, 2, 3, 1, 4, 7, 3, 6, 9, 7, 8, 9, 4, 5, 6, 1, 5, 9, 3, 5, 7, 2, 5, 8};
        int[] winsNabor = {0, 0, 0, 0};
        int s1 = 0, s = 0, i2 = 0;
        // проверка победы
        for (int i = 0; i < 24; i++) {
            int i1 = wins[i];
            ++s1;
            //суммируем 1 или 2 в наборе (крестик или нолик)
            s += array[i1];
            //запоминаем последний набор
            winsNabor[s1] = i1;
            if (s1 == 3 && s == 3) {
                array[0] = 3;
                for (int j = 1; j <= 3; j++) {
                    i2 = winsNabor[j];
                    array[i2] = 11;
                }
                break; // победа крестиков
            }
            if (s1 == 3 && s == 60) {
                array[0] = 4;
                for (int j = 1; j <= 3; j++) {
                    i2 = winsNabor[j];
                    array[i2] = 22;
                }
                break;// победа ноликов
            }
            // сбросс суммы комбинации
            if (s1 == 3) {
                s = 0;
                s1 = 0;
            }
        }

        return array;
    }
}
