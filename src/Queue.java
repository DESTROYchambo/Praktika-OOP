
package ex6;
import ex5.Command;
/**
 *  Інтерфейс черги завдань
 * @author Oleksandr
 */
public interface Queue {
    void put(Command cmd);
    Command take();
}
