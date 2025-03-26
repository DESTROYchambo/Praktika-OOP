package ex3;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Інтерфейс для відображення обчислень робота з файлами
 *
 * @author Oleksandr
 */
public interface View {

    ArrayList<Item2d> getItems();

    /**
     * Початок
     */
    void viewHeader();

    /**
     * Закінчення
     */
    public void viewFooter();

    /**
     * Відображає всю інформацію
     */
    void viewShow();

    /**
     * Виконує ініціалізацію
     */
    void viewInit();

    /**
     * Зберігання у файл
     *
     * @throws IOException при помилці
     */
    void saveTo() throws IOException;

    /**
     * Відновлення з файцлу
     *
     * @throws IOException при помилці
     */
    void loadFrom() throws IOException, ClassNotFoundException;

}
