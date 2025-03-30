
package ex5;


/**
 *
 * @author Oleksandr
 */
public class ChangeItemCommand implements Command {

    private Item2d item;

    private double offset;

    public Item2d setItem(Item2d item) {
        return this.item = item;
    }

    public Item2d getItem() {
        return item;
    }

    /**
     * параметр для зміни значень
     *
     * @param offset параметр для зміни
     * @return параметр для зміни
     */
    public double setOffset(double offset) {
        return this.offset = offset;
    }

    public double getOffset() {
        return offset;
    }

    @Override
    public void execute() {
        item.setSpeed(item.getParSpeed() * offset);
    }
}
