package ex7;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Клас обчислення кінетичної енергії та двійкового уявлення
 *
 * @author Oleksandr
 */
public class KineticEnergyCalculator {

    private static final DecimalFormat df = new DecimalFormat("0.00",
            new DecimalFormatSymbols(Locale.US));

    /**
     * Обчислення кінетичної енергії за заданою масою та швидкістю.
     *
     * @param mass маса
     * @param velocity швидкість
     * @return значення кінетичної енергії
     */
    public static double calculateKineticEnergy(double mass, double velocity) {
        return 0.5 * mass * velocity * velocity;
    }

    /**
     * Конвертація цілого числа у двійкове представлення.
     *
     * @param number число для конвертації
     * @return рядок з двійковим представленням числа
     */
    public static String toBinaryString(double number) {
        return Integer.toBinaryString((int) number);
    }

    /**
     * Генерація випадкового значення маси в діапазоні від 1 до 100.
     *
     * @return випадкова маса
     */
    public static double generateRandomMass() {
        return Double.parseDouble(df.format(1 + Math.random() * 99));
    }

    /**
     * Генерація випадкового значення швидкості в діапазоні від 1 до 50.
     *
     * @return випадкова швидкість
     */
    public static double generateRandomVelocity() {
        return Double.parseDouble(df.format(1 + Math.random() * 49));
    }

    public static double parseInput(String input) {
        try {
            // Замінюємо кому на крапку для коректного парсингу
            return Double.parseDouble(input.replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Format err: " + input);
        }
    }
}
