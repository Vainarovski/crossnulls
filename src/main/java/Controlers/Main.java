package Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;


@Controller
@RequestMapping("/in")
public class Main {
    @Autowired
    private FirstHod h1;
    @Autowired
    private EstHod h2;
    @Autowired
    private CheckUserHod us;
    @Autowired
//    @Qualifier("randomHod")
    private HodCPU h3;
    @Autowired
//    @Qualifier("useraHod")
    private HodUsera u;
    @Autowired
    private CheckWins winCh;


    private int[] array = new int[10];

    private String name = "", ret = "pages/crossnull";
    final Random r = new Random();
    boolean typeGameCross = false;
    boolean typeGameNulss = false;


    @RequestMapping(path = "/crossnull", method = RequestMethod.POST)
    public String helloPost(HttpServletRequest request) {

        int nomerHodaUsera = 0;
        String typeGameName = "", typeGame = "";


        //проверка введённого имя пользователя
        if (request.getParameter("nick") != null)
            name = request.getParameter("nick");

        //проверка введённого типа игры
        if (request.getParameter("gameType") != null) {
            typeGame = request.getParameter("gameType");
            if (typeGame.equals("1")) {
                typeGameCross = true;
            } else if (typeGame.equals("2")) {
                typeGameNulss = true;
            }
        }

        //вывод имени пользователя и типа игры
        if (typeGameCross) typeGameName = "крестиками";
        else if (typeGameNulss) typeGameName = "ноликами";

        request.setAttribute("gameVS", "Рандом играет с " + name);
        request.setAttribute("typeGame", name + " играет " + typeGameName);

        // проверка состояния игры
        boolean checkWinCross = array[0] == 3;
        boolean checkWinNulls = array[0] == 4;
        boolean netHodaCPU = false;

        if (!checkWinCross && !checkWinNulls) {
            //начало хода
            array[0] = 1;
            //куда походил пользователь
            for (int i = 1; i < 10; i++) {
                if (request.getParameter("button" + i) != null) {
                    nomerHodaUsera = i;
                }
            }
            //проверка хода пользователя
            boolean goodUsHod = us.goodHod(array, nomerHodaUsera) == 1 && nomerHodaUsera > 0;

            //установка хода пользователя
            array = u.useraHod(array, typeGameCross, typeGameNulss, nomerHodaUsera);

            // проверка победы
            array = winCh.winsChech(array);

            //случайный ход компьютера
            boolean firstHod = h1.nesdelanHod(array) == 1;
            boolean estHod = h2.estPole(nomerHodaUsera, array) == 1;
            array = h3.randomHod(array, nomerHodaUsera, typeGameCross, typeGameNulss, firstHod, estHod, goodUsHod);

            // проверка победы
            array = winCh.winsChech(array);
        }
        //сброс доски
        if (request.getParameter("button10") != null) {
            for (int i = 0; i < 10; i++) array[i] = 0;
        }

        //сброс игры
        if (request.getParameter("button11") != null) {
            for (int i = 0; i < 10; i++) array[i] = 0;
            typeGameCross = false;
            typeGameNulss = false;
            ret = "index";
        }
        // вывод состояния
        for (int i = 1; i < 10; i++) {
            switch (array[i]) {
                case 1:
                    request.setAttribute("pole" + i, "X");
                    break;
                case 11:
                    request.setAttribute("pole" + i, "<s>X</s>");
                    break;
                case 20:
                    request.setAttribute("pole" + i, "0");
                    break;
                case 22:
                    request.setAttribute("pole" + i, "<s>0</s>");
                    break;
                default:
                    request.setAttribute("pole" + i, "&nbsp;");
            }
        }
        if (array[0] == 3) request.setAttribute("win1", "ПОБЕДА КРЕСТИКОВ");
        if (array[0] == 4) request.setAttribute("win2", "ПОБЕДА НОЛИКОВ");

//        //косоль о пост запросе
//        System.out.println("пришёл ПОСТ запрос");
        return ret;
//		return "/WEB-INF/pages/nick.jsp";
    }

    public int[] setArray(int[] array) {
        this.array = array;
        return array;
    }

//    @RequestMapping(path = "/hello", method = RequestMethod.GET)
//    public String helloGet(HttpServletRequest request) {
//        String nick = request.getParameter("nick");
//        request.setAttribute("helloMessage", "Hello " + nick);
//        System.out.println("пришёл get запрос");
//        return "pages/nick-get";
////		return "/WEB-INF/pages/nick.jsp";
//    }
}


//    int[][] wins;wins= new int[2][2];
////        1, 2, 3,
//        wins[0][0] =  1;
//        wins[0][1] =  1;
//        wins[0][2] =  1;
////        1, 4, 7,
//        wins[0][0] =  1;
//        wins[1][0] =  1;
//        wins[2][0] =  1;
////        3, 6, 9,
//        wins[2][2] =  1;
//        wins[0][0] =  1;
//        wins[0][0] =  1;
////        7, 8, 9,
//        wins[0][0] =  1;
//        wins[0][0] =  1;
//        wins[0][0] =  1;
////       4, 5, 6,
//        wins[0][0] =  1;
//        wins[0][0] =  1;
//        wins[0][0] =  1;
////       1, 5, 9,
//        wins[0][0] =  1;
//        wins[0][0] =  1;
//        wins[0][0] =  1;
////       3, 5, 7,
//        wins[0][0] =  1;
//        wins[0][0] =  1;
//        wins[0][0] =  1;
////       2, 5, 8};
//        wins[0][0] =  1;
//        wins[0][0] =  1;
//        wins[0][0] =  1;
