package ex7;

/**
 * Клас для зберігання результатів обчислень
 *
 * @author Oleksandr
 */
public class EnergyResult {

    private double mass;
    private double velocity;
    private double energy;
    private String binaryRepresentation;

    // Геттери
    public double getMass() {
        return mass;
    }

    public double getVelocity() {
        return velocity;
    }

    public double getEnergy() {
        return energy;
    }

    public String getBinaryRepresentation() {
        return binaryRepresentation;
    }


    /**
     * Конструктор класу EnergyResult.
     *
     * @param mass маса
     * @param velocity швидкість
     * @param energy кін енергія
     * @param binaryRepresentation двійкове представлення цілої частини енергії
     */
    public EnergyResult(double mass, double velocity, double energy, String binaryRepresentation) {
        this.mass = mass;
        this.velocity = velocity;
        this.energy = energy;
        this.binaryRepresentation = binaryRepresentation;
    }

    /**
     * Рядкове представлення об'єкта в таблиці.
     *
     * @return масив значень полів об'єкта
     */
    public Object[] toTableRow() {
        return new Object[]{
            String.format("%.2f", mass),
            String.format("%.2f", velocity),
            String.format("%.2f", energy),
            binaryRepresentation,
        };
    }

    /**
     * Рядкове представлення об'єкта у файлі.
     *
     * @return рядок з даними
     */
    public String toFileString() {
        return String.format("%f,%f,%f,%s", mass, velocity, energy, binaryRepresentation);
    }

    /**
     * Створення об'єкту EnergyResult з рядка зчитаного з файлу.
     *
     * @param fileString рядок з даними
     * @return об'єкт EnergyResult
     */
    public static EnergyResult fromFileString(String fileString) {
        String[] parts = fileString.split(",");
        double mass = Double.parseDouble(parts[0]);
        double velocity = Double.parseDouble(parts[1]);
        double energy = Double.parseDouble(parts[2]);
        String binary = parts[3];
        EnergyResult result = new EnergyResult(mass, velocity, energy, binary);
        return result;
    }
}
