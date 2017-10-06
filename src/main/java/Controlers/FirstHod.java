
package Controlers;

        import org.springframework.stereotype.Component;

@Component
public class FirstHod {
    public Integer sdelanHod( int[] array) {
        //проверка первого хода
        for (int i = 1; i < 10; i++) {
            if (array[i] > 0) return 1;
        }
        return 0;
    }
}
