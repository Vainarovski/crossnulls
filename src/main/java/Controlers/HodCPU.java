package Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class HodCPU implements Hod {

    public int[] randomHod(int[] array, int nomerHodaUsera, boolean typeGameCross, boolean typeGameNulss, boolean firstHod, boolean estHod, boolean goodUsHod) {
        int t;
        Random r = new Random();

        if (firstHod || goodUsHod)
            if ((estHod && typeGameCross) || typeGameNulss)
                while (array[0] == 1) {
                    t = r.nextInt(9) + 1;

                    boolean chek1 = (array[t] == 0 && typeGameCross && t != nomerHodaUsera);
//                boolean chek2 = (array[t] == 0 && typeGameCross && t != nomerHodaUsera && firstHod);
                    boolean chek3 = (array[t] == 0 && typeGameNulss && firstHod);
                    boolean chek4 = (array[t] == 0 && typeGameNulss && t != nomerHodaUsera && goodUsHod);

                    if (chek1) {
                        array[t] = 20;
                        array[0] = 2;
                    } else if (chek3 || chek4) {
                        array[t] = 1;
                        array[0] = 2;
                    }
                }
        return array;
    }
}