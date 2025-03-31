package ex6;

import java.util.concurrent.TimeUnit;
import ex5.ViewResult;
import ex5.Command;

/**
 *  Обчислення максимального значення
 * @author Oleksandr
 */
public class MaxCommand implements Command {

    private int result = -1;

    private int progress = 0;

    private ViewResult viewResult;

    public ViewResult getViewResult() {
        return viewResult;
    }

    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    public MaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    public int getResult() {
        return result;
    }

    public boolean running() {
        return progress < 100;
    }

    @Override
    public void execute() {
        progress = 0;
        System.out.println("Max executed...");
        int size = viewResult.getItems().size();
        result = 0;
        for (int idx = 1; idx < size; idx++) {
            if (viewResult.getItems().get(result).getKinEnergy()
                    < viewResult.getItems().get(idx).getKinEnergy()) {
                result = idx;
            }
            progress = idx * 100 / size;
            if (idx % (size / 3) == 0) {
                System.out.println("Max " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(3000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.println("Max done. Item #" + result
                + " found: " + viewResult.getItems().get(result));

        progress = 100;

    }
}
