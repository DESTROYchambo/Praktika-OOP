
package ex5;

/**
 * Для відміни операції
 * @author Oleksandr
 */
public class Undo implements ConsoleCommand {

    private View view;

    public Undo(View view) {
        this.view = view;
    }
    
    @Override
    public char getKey() {
        return 'u';
    }

    @Override
    public String toString() {
        return "'u'ndo";
    }

    @Override
    public void execute() {
        System.out.println("undo last ");
        if (view instanceof ViewResult viewResult) {
            viewResult.undo();
            view.viewShow();
        } else {
            System.out.println("errorf2");
        }
    }
    
}
