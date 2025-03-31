package ex6;

import ex5.View;
import ex5.ViewableResult;
import ex5.ChangeConsoleCommand;
import ex5.GenerateConsoleCommand;
import ex5.Menu;
import ex5.ViewConsoleCommand;

/**
 *  Головний клас 
 * @author Oleksandr
 */
public class Main {

    private View view = new ViewableResult().getView();
    /**
     * Объект класса {@linkplain Menu}; макрокоманда (шаблон Command)
     */
    private Menu menu = new Menu();

    /**
     * Обработка команд пользователя
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));
        menu.execute();
    }

    /**
     * Выполняется при запуске программы
     *
     * @param args параметры запуска программы
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
