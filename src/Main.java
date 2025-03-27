package ex4;

import ex3.*;

/**
 * Основний клас з меню
 *
 * @author Oleksandr
 */
public class Main extends ex3.main {

    public Main(View view) {
        super(view);
    }

    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }

}
