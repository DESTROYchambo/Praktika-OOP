package ex3;

import java.io.*;
import java.util.*;

/**
 * Клас відображення обчислень
 * @author Oleksandr
 */
public class ViewResult implements View {

    private static final String filename = "saves.txt";
    private static final int def = 1;

    private ArrayList<Item2d> items = new ArrayList<Item2d>();

    public ViewResult() {
        this(def);
    }

    public ArrayList<Item2d> getItems() {
        return items;
    }

    public ViewResult(int n) {
        items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Item2d());
        }
    }

    private double calculatekinetic(double massa, double speed) {
        return (0.5) * massa * Math.pow(speed, 2);
    }

    public String calculatekinetic2(double kinEnergy, double massa, double speed) {
        int INTPART = (int) calculatekinetic(massa, speed);
        String binary = Integer.toBinaryString(INTPART);
        return binary;
    }

    public void init(double massa, double speed) {
        for (Item2d item : items) {
            item.setPar(massa, speed, calculatekinetic(massa, speed), calculatekinetic2(calculatekinetic(massa, speed), massa, speed));
        }
    }

    @Override
    public void viewInit() {
        double massa = Math.round((Math.random() * 12) + 1);
        double speed = Math.round((Math.random() * 12) + 1);
        init(massa, speed);
    }

    @Override
    public void viewHeader() {
        System.out.println("SUMMARY:");
    }

    public void viewMain() {
        for (Item2d item : items) {
            System.out.println("Massa: "+item.getParMassa()+", Speed: "+item.getParSpeed());
            System.out.print("KinEnergy: "+item.getKinEnergy()+", Binary: "+item.getParBinary());
        }
        System.out.println();
    }

    @Override
    public void viewFooter() {
        System.out.println("----------------------------");
    }

    @Override
    public void viewShow() {
        viewHeader();
        viewMain();
        viewFooter();
    }

    @Override
    public void saveTo() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(items);
            out.close();
        }
    }

    @Override
    public void loadFrom() throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        items = (ArrayList<Item2d>) in.readObject();
        in.close();

    }

    
}
