
package ex3;

/**
 * Клас реалізації {@linkplain Viewable}
 * @author Oleksandr
 */
public class ViewableResult implements Viewable  {
    @Override
    public View getView() {
        return new ViewResult();
    }
}
