package Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HodUsera implements Hod {
    @Autowired
    private FirstHod h1;

    public int[] useraHod (int[] array, boolean typeGameCross, boolean typeGameNulss, int nomerHodaUsera) {
       if (typeGameCross && nomerHodaUsera > 0 && array[nomerHodaUsera] == 0) array[nomerHodaUsera] = 1;
       else if (typeGameNulss && nomerHodaUsera > 0 && array[nomerHodaUsera] == 0 && h1.sdelanHod(array) == 1)
           array[nomerHodaUsera] = 20;
       return array;
   }

}
