import java.util.Date;

public class vegetables extends itemProfile{
    @Override
    public void setItemID(int itemID) {
        super.setItemID(itemID++);
    }
}
