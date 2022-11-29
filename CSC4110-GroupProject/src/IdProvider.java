public class IdProvider {
    private static IdProvider instance = null;

    public static IdProvider getInstance() {
        if(instance == null){
            instance = new IdProvider();
        }
        return instance;
    }

    private int nextId = 100000;

    public int getUniqueId(){
        if(nextId < 0){
            throw new IllegalStateException("Out if IDs!");
        }
        int uniqueId = nextId;
        nextId++;

        return uniqueId;
    }
}
