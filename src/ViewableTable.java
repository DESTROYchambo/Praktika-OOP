package ex5;


/**
 * Factory Method
 * створює об'єкт {@linkplain ViewTable}
 * @author Oleksandr
 */
public class ViewableTable extends ViewableResult {

    @Override
    public View getView() {
        return new ViewTable();
    }
}
