package ex7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Клас графічного інтерфейсу
 *
 * @author Oleksandr
 */
public class EnergyFrame extends JFrame {

    private JTextField massField;
    private JTextField velocityField;
    private JTextField energyField;
    private JTextField binaryField;
    private JTable resultsTable;
    private DefaultTableModel tableModel;
    private List<EnergyResult> results;
    private Stack<List<EnergyResult>> historyStack;

    public EnergyFrame() {
        // Ініціалізація списку результатів
        results = new ArrayList<>();
        historyStack = new Stack<>();
        loadSavedResults();

        // Налаштування головного вікна
        setTitle("Кінетична енергія тіла");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(createInputPanel(), BorderLayout.NORTH);
        mainPanel.add(createResultsTable(), BorderLayout.CENTER);
        mainPanel.add(createButtonsPanel(), BorderLayout.SOUTH);
        add(mainPanel);
    }

    private void saveState() {
        historyStack.push(new ArrayList<>(results));
    }

    private void undoLastAction() {
        if (!historyStack.isEmpty()) {
            results = new ArrayList<>(historyStack.pop());
            refreshTable();
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (EnergyResult result : results) {
            tableModel.addRow(result.toTableRow());
        }
    }

    /**
     * Створення панелі для введення даних.
     *
     * @return панель з полями введення
     */
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        panel.add(new JLabel("Massa:"));
        massField = new JTextField();
        panel.add(massField);

        panel.add(new JLabel("Velocity:"));
        velocityField = new JTextField();
        panel.add(velocityField);

        panel.add(new JLabel("Kinetic Energy:"));
        energyField = new JTextField();
        energyField.setEditable(false);
        panel.add(energyField);

        panel.add(new JLabel("Binary:"));
        binaryField = new JTextField();
        binaryField.setEditable(false);
        panel.add(binaryField);

        return panel;
    }

    /**
     * Створення таблиці для відображення результатів.
     *
     * @return компонент JScrollPane з таблицею
     */
    private JScrollPane createResultsTable() {
        // Заголовки таблиці
        String[] columns = {"Massa", "Velocity", "KinEnergy", "Binary"};
        tableModel = new DefaultTableModel(columns, 0);
        resultsTable = new JTable(tableModel);

        // Заповнення таблиці збереженими результатами
        for (EnergyResult result : results) {
            tableModel.addRow(result.toTableRow());
        }

        return new JScrollPane(resultsTable);
    }

    /**
     * Створює панель з кнопками управління.
     *
     * @return панель з кнопками
     */
    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 5, 5, 5));

        JButton calculateButton = new JButton("Обчислити");
        calculateButton.addActionListener(this::calculateAction);
        panel.add(calculateButton);

        JButton generateButton = new JButton("Згенерувати");
        generateButton.addActionListener(this::generateAction);
        panel.add(generateButton);

        JButton saveButton = new JButton("Зберегти");
        saveButton.addActionListener(this::saveAction);
        panel.add(saveButton);

        JButton loadButton = new JButton("Відновити");
        loadButton.addActionListener(this::loadAction);
        panel.add(loadButton);

        JButton undoButton = new JButton("Видалити останнє");
        undoButton.addActionListener(e -> undoLastAction());
        panel.add(undoButton);

        return panel;
    }

    /**
     * "Обчислити".
     *
     * @param e подія ActionEvent
     */
    private void calculateAction(ActionEvent e) {
        try {
            saveState();

            double mass = KineticEnergyCalculator.parseInput(massField.getText());
            double velocity = KineticEnergyCalculator.parseInput(velocityField.getText());

            if (mass <= 0 || velocity <= 0) {
                JOptionPane.showMessageDialog(this, "Маса та швидкість повинні бути більше нуля!",
                        "Помилка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double energy = KineticEnergyCalculator.calculateKineticEnergy(mass, velocity);
            String binary = KineticEnergyCalculator.toBinaryString(energy);

            energyField.setText(String.format("%.2f", energy));
            binaryField.setText(binary);

            EnergyResult result = new EnergyResult(mass, velocity, energy, binary);
            results.add(result);
            tableModel.addRow(result.toTableRow());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Будь ласка, введіть коректні числові значення!\n" + ex.getMessage(),
                    "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * "Згенерувати параметри".
     *
     * @param e подія ActionEvent
     */
    private void generateAction(ActionEvent e) {
        double mass = KineticEnergyCalculator.generateRandomMass();
        double velocity = KineticEnergyCalculator.generateRandomVelocity();

        massField.setText(String.format("%.2f", mass));
        velocityField.setText(String.format("%.2f", velocity));
    }

    /**
     * "Зберегти результати".
     *
     * @param e подія ActionEvent
     */
    private void saveAction(ActionEvent e) {
        try {
            FileHandler.saveResults(results);
            JOptionPane.showMessageDialog(this, "Saved",
                    "DONE", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Save ERROR: " + ex.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadAction(ActionEvent e) {
        try {
            List<EnergyResult> loadedResults = FileHandler.loadResults();
            results.clear();
            results.addAll(loadedResults);

            tableModel.setRowCount(0);
            for (EnergyResult result : results) {
                tableModel.addRow(result.toTableRow());
            }

            JOptionPane.showMessageDialog(this, "Restored",
                    "Done", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Restore ERROR: " + ex.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * "Видалити останній результат".
     *
     * @param e подія ActionEvent
     */
    private void deleteAction(ActionEvent e) {
        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(this, "nothing to delete",
                    "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int lastRow = results.size() - 1;
        results.remove(lastRow);
        tableModel.removeRow(lastRow);
    }

    /**
     * Завантажує збережені результати з файлу.
     */
    private void loadSavedResults() {
        try {
            List<EnergyResult> savedResults = FileHandler.loadResults();
            results.addAll(savedResults);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Restore ERROR: " + e.getMessage(),
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }

}
