package Controlers;

import org.springframework.stereotype.Component;

@Component
public class EstHod {

    public Integer estPole(int hodUser,  int[] array) {
        int hod = 1;
        //проверка пустых ячеек
        for (int i = 1; i < 10; i++) {
            if (array[i] == 0 && hodUser > 0 && hodUser != i) return 1;
        }
        return 0;
    }
}
