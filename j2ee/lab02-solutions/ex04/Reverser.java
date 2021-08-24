package j2ee.lab02.ex04;

public class Reverser {
    public static void main(String[] args) {
        //int[] x = {10, 30, 18, 24, 33, 65, 52, 21};
        int[] x = {10, 30, 18, 24, 20, 33, 65, 52, 21};
        //This mean following
        // x = new int[8];
        // x[0]=10; x[1]=30; x[2]=18; and so on
        int n = x.length, n2 = n / 2, tmp;
        System.out.println("Original Array: " + array2string(x,n));
        for (int i=0; i < n2; i++) {
            tmp = x[i];
            x[i] = x[n-1-i];
            x[n-1-i] = tmp;
        }
        System.out.println("Reversed Array: " + array2string(x,n));
    }
    private static String array2string(int[] x, int n) {
        String str = "[" + x[0] ;
        for (int i=1; i < n; i++) {
            str += ", " + x[i];
        }
        str += "]";
        return str;
    }
}
