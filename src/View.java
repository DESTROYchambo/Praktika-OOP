package ex5;

import java.io.IOException;


/**
 * Інтерфейс для відображення обчислень, робота з файлами
 *
 * @author Oleksandr
 */
public interface View {



    /**
     * Початок
     */
    void viewHeader();
    /**
     * Тіло
     */
    void viewMain();

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
