package ex2;

import java.io.*;
import java.util.Scanner;

/**
 * клас worker зберігає дані
 *
 * @author Oleksandr
 */
class worker implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * параметри робітника
     */
    private String name;
    private transient String password;
    private transient String salary;

    public worker(String name, String password, String salary) {
        this.name = name;
        this.password = password;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{name=" + name + ", password=" + password + ", salary=" + salary + "}";
    }

}

/**
 * клас task2 виконує серіалізацію, десеріалізацію
 *
 * @author Oleksandr
 */
public class task2 {

    String filename = "worker.txt";
    static Scanner scan = new Scanner(System.in);

    public void main(String[] args) throws ClassNotFoundException {
        writeTo();
        loadFrom();
    }

    /**
     * запис інформації від користувача
     */
    private void writeTo() {
        System.out.print("write name: ");
        String name = scan.nextLine();
        System.out.print("write password: ");
        String password = scan.nextLine();
        System.out.print("write salary: ");
        String salary = scan.nextLine();

        /**
         * серіалізація
         */
        worker employee = new worker(name, password, salary);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("do serializ ");
        System.out.println(employee);
    }

    /**
     * десеріалізація
     */
    private void loadFrom() throws ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            worker INemployee = (worker) in.readObject();
            System.out.println("posle serializ ");
            System.out.println(INemployee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
