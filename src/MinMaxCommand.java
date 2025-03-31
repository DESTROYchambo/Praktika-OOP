package ex6;

import java.util.concurrent.TimeUnit;
import ex5.Item2d;
import ex5.ViewResult;
import ex5.Command;

/**
 * Реалізація обчислення мінімального та максимального значення
 * @author Oleksandr
 */
public class MinMaxCommand implements Command {

    private int resultMin = -1;

    private int resultMax = -1;

    private int progress = 0;

    private ViewResult viewResult;

    public ViewResult getViewResult() {
        return viewResult;
    }

    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    public MinMaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * Возвращает результат
     *
     * @return поле {@linkplain MinMaxCommand#resultMin}
     */
    public int getResultMin() {
        return resultMin;
    }

    /**
     * Возвращает результат
     *
     * @return поле {@linkplain MinMaxCommand#resultMax}
     */
    public int getResultMax() {
        return resultMax;
    }

    /**
     * Проверяет готовность результата
     *
     * @return false - если результат найден, иначе - true
     */
    public boolean running() {
        return progress < 100;
    }

    @Override
    public void execute() {
        progress = 0;
        System.out.println("MinMax executed...");
        int idx = 0, size = viewResult.getItems().size();
        for (Item2d item : viewResult.getItems()) {
            if (item.getKinEnergy() < 0) {
                if ((resultMax == -1)
                        || (viewResult.getItems().get(resultMax).getKinEnergy() < item.getKinEnergy())) {
                    resultMax = idx;
                }
            } else {
                if ((resultMin == -1) || (viewResult.getItems().get(resultMin).getKinEnergy() > item.getKinEnergy())) {
                    resultMin = idx;
                }
            }
            idx++;
            progress = idx * 100 / size;
            
        }
        System.out.print("MinMax done. ");
        if (resultMin > -1) {
            System.out.print("Min positive #" + resultMin + " found: " + String.format("%.2f.",
                    viewResult.getItems().get(resultMin).getKinEnergy()));
        } else {
            System.out.print("Min positive not found.");
        }
        if (resultMax > -1) {
            System.out.println(" Max negative #" + resultMax + " found: "
                    + String.format("%.2f.",
                            viewResult.getItems().get(resultMax).getKinEnergy()));
        }else{
            System.out.println(" Max negative item not found.");
        }
        progress =100;
    }
}
