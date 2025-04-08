package ex7;

/**
 * Головний клас програми та запуск графічного інтерфейсу.
 *
 * @author Oleksandr
 */
public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            EnergyFrame frame = new EnergyFrame();
            frame.setVisible(true);
        });
    }
}
