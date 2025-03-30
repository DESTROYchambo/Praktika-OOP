
package ex5;

/**
 *  Зміна елемента
 * @author Oleksandr
 */
public class ChangeConsoleCommand
        extends ChangeItemCommand
        implements ConsoleCommand {

    /**
     * Реалізація інтерфейсу {@linkplain View}
     */
    private View view;

    public View getView() {
        return view;
    }

    public View setView(View view) {
        return this.view = view;
    }

    /**
     * Ініціалізація об'єкут {@linkplain View}
     *
     * @param view об'єкт, який реалізує інтерфейс {@linkplain View}.
     */
    public ChangeConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'c';
    }

    @Override
    public String toString() {
        return "'c'hange";
    }

    @Override
    public void execute() {
        double offset = Math.random() * 100;

        System.out.println("Change item: scale factor " + offset);
        for (Item2d item : ((ViewResult) view).getItems()) {
            item.setMassa(Math.round(item.getParMassa() * offset));
            item.setSpeed(Math.round(item.getParSpeed() * offset));
            item.setKinEn(Math.round((0.5) * item.getParMassa() * Math.pow(item.getParSpeed(), 2)));
            item.setBinary(calculatekinetic2(item.getParMassa(), item.getParSpeed()));
        }
        view.viewShow();
    }

    private String calculatekinetic2(double massa, double speed) {
        int INTPART =(int) ((int) (0.5) * massa * Math.pow(speed, 2));
        String binary = Integer.toBinaryString(INTPART);
        return binary;
    }
}
