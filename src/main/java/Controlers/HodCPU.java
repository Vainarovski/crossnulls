package Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class HodCPU implements Hod {

    public int[] randomHod(int[] array, int nomerHodaUsera, boolean typeGameCross, boolean typeGameNulss,  boolean firstHod,  boolean estHod) {
        int t;
        Random r = new Random();
        if ((estHod && typeGameCross) || typeGameNulss)
            while (array[0] == 1) {
                t = r.nextInt(9) + 1;
                if (array[t] == 0 && typeGameCross && t != nomerHodaUsera ) {
                    array[t] = 20;
                    array[0] = 2;
                } else if ((array[t] == 0 && typeGameNulss && firstHod ) ||
                           (array[t] == 0 && typeGameNulss && t != nomerHodaUsera ))
                {
                    array[t] = 1;
                    array[0] = 2;
                }
            }
    return array;
    }
}