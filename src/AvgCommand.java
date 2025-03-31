package ex6;

import ex5.Item2d;
import ex5.ViewResult;
import ex5.Command;


/**
 * Обчислення середнього значення
 * @author Oleksandr
 */
public class AvgCommand implements Command {

    private double result = 0;
    private int progress = 0;

    private ViewResult viewResult;

    public ViewResult getViewResult() {
        return viewResult;
    }

    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    public AvgCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    public double getResult() {
        return result;
    }

    public boolean running() {
        return progress < 100;
    }

    @Override
    public void execute() {
        progress = 0;
        System.out.println("Average executed...");
        result = 0.0;
        int idx = 1, size = viewResult.getItems().size();
        for (Item2d item : viewResult.getItems()) {
            result += item.getKinEnergy();
            progress = idx * 100 / size;
            
        }
        result /= size;
        System.out.println("Average done. Result: " + String.format("%.2f", result));
        progress = 100;
    }
}
