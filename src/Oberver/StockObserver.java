package Oberver;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class StockObserver implements IitemObserver {
    private double quantity;
    @Override
    public void update() {
            printMessage();
        }
    public void printMessage(){
        System.out.println("Two or more items are out of stock!");
    }
}

