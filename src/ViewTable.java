package ex4;

import ex3.*;
import java.util.*;

/**
 * Клас показує результати 
 * обчислень у виді таблиці
 * @author Oleksandr
 */
public class ViewTable extends ViewResult {

    private static final int DEF_WIDTH = 47;
    private int width;

    public ViewTable() {
        width = DEF_WIDTH;
    }

    public ViewTable(int width) {
        this.width = width;
    }

    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }

    public int setWidth(int width) {
        return this.width = width;
    }

    public int getWidth(int width) {
        return width;
    }

    private void separator() {
        for (int i = width; i > 0; i--) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Заголовок таблиці 
     */
    private void outHeader() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s%2$d%s%2$d%s",
                "%", (width - 9) / 4, "s | %", "s | %", "s | %", "s | \n");
        System.out.printf(fmt.toString(), CentrGSP("Massa", 9), CentrGSP("Speed", 9), CentrGSP("KinEn", 9), CentrGSP("Binary", 9));
    }

    /**
     * Тіло таблиці 
     */
    private void outBody() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s%2$d%s%2$d%s",
                "%", (width - 9) / 4, ".2f | %", ".2f | %", ".2f | %", "s | \n");
        for (Item2d item : getItems()) {
            System.out.printf(fmt.toString(),
                    item.getParMassa(),
                    item.getParSpeed(),
                    item.getKinEnergy(),
                    item.getParBinary());
        }
    }
    /**
     * центрування заголовку
     * @param slovo слово для центрування у стовпці
     * @param width ширина стовпця
     * @return новий вміст стовпця
     */
    private String CentrGSP(String slovo, int width) {
        if (slovo.length() >= width) {
            return slovo;
        }
        int leftPadding = (width - slovo.length()) / 2;
        int rightPadding = width - slovo.length() - leftPadding;
        return " ".repeat(leftPadding) + slovo + " ".repeat(rightPadding);
    }

    public final void init(int width) { // method overloading
        this.width = width;
        viewInit();

    }

    public final void init(int width, double stepX) { // method overloading
        this.width = width;
        init((int) stepX);
    }

    @Override
    public void init(double massa, double speed) { // method overriding
        System.out.print("Initialization... ");
        super.init(massa, speed);
        System.out.println("Done. ");
    }

    /**
     * Вывод элемента таблиці
     */
    @Override
    public void viewHeader() {
        outHeader();
        separator();
    }

    /**
     * Вывод элемента таблиці
     */
    @Override
    public void viewMain() {
        outBody();
    }

    /**
     * Вывод элемента таблиці
     */
    @Override
    public void viewFooter() {
        separator();
    }
}
