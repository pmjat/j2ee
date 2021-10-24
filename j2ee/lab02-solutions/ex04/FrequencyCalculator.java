package j2ee.lab02.ex04;
import java.util.Random;
public class FrequencyCalculator {
    public static void main(String[] args) {
        int n = 100;
        int[] x = new int[n];

        Random rand = new Random(55);
        for(int i=0; i < n; i++)
            x[i] = rand.nextInt(11);
        
        int[] freq = calculateFrequencies(x,n);

        System.out.println("Frequencies:");
        for(int i=0; i < 11; i++)
            System.out.println( "" + i + ": " + freq[i]);
    }
    private static int[] calculateFrequencies(int[] x, int n) {
		int[] freq = new int[11];
		for(int i=0; i < 11; i++)
			freq[i] = 0;
		for(int i=0; i < n; i++)
            freq[x[i]]++;
		return freq;
    }
}
