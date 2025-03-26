package ex3;

import java.io.*;
import java.util.*;

/**
 * Головний клас Демонстрація роботи програми
 *
 * @author Oleksandr
 */
public class main {

    static Scanner scan = new Scanner(System.in);
    /**
     * Об'єкт класу {@linkplain View} для відображення результатів.
     */
    private View view;

    /**
     * Конструктор мейн класу.
     */
    public main(View view) {
        this.view = view;
    }

    protected void menu() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String choice = null;
        /**
         * Головне меню програми
         */
        System.out.println(">---------| MENU |-----------<");
        System.out.println("'q'uit, 'n'ew, 's'ave, 'v'iew: ");
        System.out.println(">--------| CHOISE |----------<");

        do {

            try {
                System.out.print("-----------> ");
                choice = in.readLine();
                if (choice.isEmpty()) {
                    continue;
                }
            } catch (IOException e) {
                System.out.println("err " + e);
                return;
            }

            switch (choice.charAt(0)) {

                case 'q' -> {
                    System.out.println("quitting");
                }

                case 'n' -> {
                    System.out.println("generating(1-13)");
                    view.viewInit();
                    view.viewShow();
                }
                case 's' -> {
                    System.out.println("saving");
                    try {
                        view.saveTo();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    view.viewShow();
                }

                case 'v' -> {
                    System.out.println("loading from file");
                    try {
                        view.loadFrom();
                        System.out.println("success");
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    view.viewShow();
                }

                default ->
                    System.out.println("err");
            }

        } while (choice.charAt(0) != 'q');

    }

    public static void main(String[] args) {
        main Main = new main(new ViewableResult().getView());
        Main.menu();
    }
}
