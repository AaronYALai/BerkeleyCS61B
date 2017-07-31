public class Larger{
    /** fffff */
    public static double larger(int x, int y){
        if (x < y){
            return 0.5;
        }
        return 0.7;
    }

    public static void main(String[] args){
        System.out.println(larger(-5, 10));
    }
}
