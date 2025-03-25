package ex2;

import java.io.*;
import java.util.Scanner;

/**
 * клас для тестування коректності результатів обчислень та
 * серіалізації/десеріалізації
 *
 * @author Oleksandr
 */
public class task3 implements Serializable {

    private static final long serialVersionUID = 1L;
    String filename = "dump2.txt";
    static Scanner scan = new Scanner(System.in);

    private double a;
    private double b;
    private double result;

    public task3(double a, double b) {
        this.a = a;
        this.b = b;
        this.result = calculate();
    }

    /**
     * обчислення формули
     *
     * @return результат обчислення
     */
    private double calculate() {
        return Math.pow(a, 2) - (a * b);
    }

    /**
     * програма не працює без цього конструктора
     */
    public task3() {
        super();
    }

    @Override
    public String toString() {
        return "Result{x=" + a + ", y=" + b + ", result=" + result + "}\n";
    }

    public void main() {
        /**
         * запис інформації від користувача
         */
        System.out.print("write a: ");
        double a = scan.nextDouble();
        System.out.print("write b: ");
        double b = scan.nextDouble();

        task3 result = new task3(a, b);
        System.out.println("----------------");
        System.out.println("do serializ ");
        System.out.print(result);

        /**
         * серіалізація
         */
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(result);
            System.out.println("file: " + filename);
            System.out.println("----------------");
        } catch (IOException i) {
            i.printStackTrace();
        }
        /**
         * десеріалізація
         */
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            task3 NEWresult = (task3) in.readObject();
            System.out.println("posle serializ ");
            System.out.println(NEWresult);
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }

    }
}
