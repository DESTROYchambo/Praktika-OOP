package ex4;

import ex3.*;

/**
 * Factory Method
 * створює об'єкт {@linkplain ViewTable}
 * @author Oleksandr
 */
public class ViewableTable extends ex3.ViewableResult {

    @Override
    public View getView() {
        return new ViewTable();
    }
}
