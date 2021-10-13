public class Singletone {
    private static volatile Singletone instance;

    public String getA() {
        return a;
    }

    private static boolean b;
    private String a;

    private Singletone(boolean b){
        if(b){
            // 1
        }else {
            // 2
        }
        this.a = "A";
    }

    public static Singletone getInstance() {
        if (instance == null)
            instance = new Singletone();
        return instance;
    }
}
