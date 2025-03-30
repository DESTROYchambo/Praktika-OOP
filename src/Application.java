package ex5;

/**
 * Клас формує і відображає шаблон Singleton
 * @author Oleksandr
 */
public class Application {

    private static Application instance = new Application();

    private Application() {
    }

    public static Application getInstance() {
        return instance;
    }

    /**
     * Об'єкт, який реалізує {@linkplain View}
     */
    private View view = new ViewableTable().getView();

    /**
     * Об'єкт класy {@linkplain Menu}; макрокоманда
     */
    private Menu menu = new Menu();

    /**
     * Обробка команд
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new Undo(view));
        menu.execute();
    }
}
