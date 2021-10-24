package j2ee.lab02.ex04;

public class CSVExtractor {
    public static void main(String[] args) {
        String str = "3.5, 12.9, 18.7, 121.54";
        String[] sx = str.split(",");
        int n = sx.length;
        double[] x = new double[n];
        for(int i=0; i < n; i++) {
            x[i] = Double.parseDouble(sx[i]);
        }
        for(int i=0; i < n; i++) {
            System.out.println("" + x[i]);
        }
    }
}
