public class PurchaseIdProvider {
    private static PurchaseIdProvider instance = null;

    public static PurchaseIdProvider getInstance() {
        if(instance == null){
            instance = new PurchaseIdProvider();
        }
        return instance;
    }

    private int nextId = 500000;

    public int getUniqueId(){
        if(nextId > 999999){
            throw new IllegalStateException("Out if IDs!");
        }
        int uniqueId = nextId;
        nextId++;

        return uniqueId;
    }
}
