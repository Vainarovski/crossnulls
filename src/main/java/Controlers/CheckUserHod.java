package Controlers;

import org.springframework.stereotype.Component;

@Component
public class CheckUserHod {
    public Integer goodHod(int[] array, int nomerHodaUsera) {
        //проверка первого хода
        for (int i = 1; i < 10; i++) {
            if (nomerHodaUsera == i && array[i] > 0) return 0;
        }
        return 1;
    }
}
