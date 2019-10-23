public class DemoSingleton implements Serializable {

    private volatile static DemoSingleton instance = null;

    private DemoSingleton() {
        //Default constructor private to block object creations
    }

    public static synchronized DemoSingleton getInstance() {
        if (instance == null) {
            instance = new DemoSingleton();
        }
        return instance;
    }

    //saving singleton breaking because of serialization
    protected Object readResolve() {
        return instance;
    }

    private int randomField = 10;

    public int getRandomField() {
        return randomField;
    }

    public void setRandomField(int i) {
        this.randomField = i;
    }
}