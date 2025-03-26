
package ex2;
import java.io.*;
import java.util.Scanner;


public class task1 implements Serializable {
    /**
     * Версія серіалізованого класу
     * для сумісності сер даних
     */
    
    private static final long serialVersionUID = 1L;
    
     /**
      * параметри для обчислення
      */
    private double a;
    private double b;
    private double result;
    
    /**
     * конструктор
     * @param a
     * @param b 
     */
    public task1(double a, double b){
        this.a=a;
        this.b=b;
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
     * повертає заданий параметр
     * @return повертає заданий параметр
     */
    public double getParA(){return a;}
    public double getParB(){return b;}
    public double getRes(){return result;}
    
    
    /**
     * рядковий вивід результату
     * @return рядок з результатом
     */
    @Override
    public String toString() {
        return "Result= " + result;
    }

   
    public static void main(String[] args) throws IOException, ClassNotFoundException{

        String filename="dump.txt";
        Scanner scan= new Scanner(System.in);
        
        /**
         * введення параметрів користувачем
         */
        System.out.print("write par A: ");
        double inA=scan.nextDouble();
        System.out.print("write par B: ");
        double inB=scan.nextDouble();
        task1 answer = new task1(inA,inB);
           
        /**
         * серіалізація даних
         * @param filename шлях до файлу
         */
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(answer);
        out.close();
        
        /**
         * десеріалізація даних і вивід
         * @param filename шлях до файлу
         */
        ObjectInputStream in= new ObjectInputStream(new FileInputStream(filename));
        task1 calc = (task1) in.readObject();
        System.out.println(calc);
}
}