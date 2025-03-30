
package ex5;


/**
 *  Консольна команда відображення обчислень
 * @author Oleksandr
 */
public class ViewConsoleCommand implements ConsoleCommand {

    private View view;

    public ViewConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'v';
    }

    @Override
    public String toString() {
        return "'v'iew";
    }

    public void execute() {
        System.out.println("View current.");
        view.viewShow();
    }

}
