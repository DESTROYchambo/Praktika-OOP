package ex5;


import java.io.*;

/**
 * Клас містить реалізацію методів 
 * обчислення, включає в себе
 * параметри маси тіла і швидкості
 * @author Oleksandr
 */
 public class Item2d implements Serializable {

    private static final long serialVersionUID = 1L;
    private double massa, speed, kinEnergy;
    private String binary;
    
    
    /**
     * конструктор за замовчуванням
     */
    public Item2d() {
        this.massa = 0;
        this.speed = 0;
        this.kinEnergy = 0;
        this.binary = "";
    }

    /**
     * встановлення параметрів
     * @param massa маса тіла
     * @param speed швидкість тілаі
     */
    public Item2d(double massa, double speed, double kinEnergy,  String binary) {
        this.massa = massa;
        this.speed = speed;
        this.kinEnergy = kinEnergy;
        this.binary = binary;
    }
    /**
     * встановлення значень 
     * @param massa
     * @param speed
     * @param kinEnergy результат формули {@linkplain ViewResult#calculatekinetic}
     * @param binary результат формули {@linkplain ViewResult#calculatekinetic2}
     */
    public void setPar(double massa, double speed, double kinEnergy, String binary) {
        this.massa = massa;
        this.speed = speed;
        this.kinEnergy = kinEnergy;
        this.binary = binary;
    }

    /**
     * повертає масу
     *
     * @return маса тіла
     */
    public double getParMassa() {
        return massa;
    }

    /**
     * повертає швидкість
     *
     * @return швидкість тіла
     */
    public double getParSpeed() {
        return speed;
    }
    /**
     * повертає результат формули {@linkplain ViewResult#calculatekinetic}
     * @return 
     */
    public double getKinEnergy() {
        return kinEnergy;
    }
    /**
     * повертає результат формули {@linkplain ViewResult#calculatekinetic2}
     * @return 
     */
    public String getParBinary() {
        return binary;
    }
    
    public void setMassa(double massa) {
        this.massa = massa;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public void setKinEn(double kinEnergy) {
        this.kinEnergy = kinEnergy;
    }
    
    public void setBinary(String binary) {
        this.binary = binary;
    }

    @Override
    public String toString() {
        return "Massa: " + massa + ", Speed:  " + speed
                + "\n Kin Energy: " + kinEnergy + ", Binary: " + binary;
    }
}
