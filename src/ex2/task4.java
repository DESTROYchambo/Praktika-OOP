package ex2;
import java.util.Scanner;
/**
 * Клас знаходить двійкове уявлення цілої частини 
 * значення кінетичної енергії фізичного тіла 
 * при заданих значеннях маси та швидкості.
 * @author Oleksandr
 */
public class task4 {
     Scanner scan = new Scanner(System.in);
     /**
      * визначає за формулою цілу 
      * частину кінетичної енергії
      * @param massa маса тіла
      * @param speed швидкість тіла
      * @return 
      */
     public double kinetic(double massa,double speed ){
         return (0.5)*massa*Math.pow(speed,2);
     }
     
    public void main(String[] args) {
        System.out.print("massa tila: ");
        double massa = scan.nextDouble();
        
        System.out.print("skorost tila: ");
        double speed = scan.nextDouble();
        
        double result=kinetic(massa, speed);
        System.out.println("cila chast: "+result);
        
        int INTPART= (int) result;
        String binary= Integer.toBinaryString(INTPART);
        System.out.println("dviikove: "+binary);
    }
}
