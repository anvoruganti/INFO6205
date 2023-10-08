package edu.neu.coe.info6205.sort.elementary;

import java.util.ArrayList;
import java.util.Random;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;

public class InsertionSortBenchmark {
	
    static Random random = new Random();
    static InsertionSort<Integer> insertionSort = new InsertionSort<>();

	public static void main(String[] args) {
		int[] N = new int[] {1000,2000,4000,8000};
        for (int n:N) {	
        	System.out.println("N: " + n);	
            benchmarkChecks("Ordered", getInputArray(n, "Ordered"));
            benchmarkChecks("Partially Ordered", getInputArray(n, "Partial"));
            benchmarkChecks("Random", getInputArray(n, "Random"));
            benchmarkChecks("Reverse Ordered", getInputArray(n, "Reverse"));
        }
	}
	
	public static void benchmarkChecks(String description, Integer[] inputArray) {
		Benchmark<Boolean> benchmark = new Benchmark_Timer<>(description, (func) -> {
            insertionSort.sort(inputArray.clone(), 0, inputArray.length);
        });
        double result = benchmark.run(true, 100);
        System.out.printf("Time(in ms) for %s: %.3f%n", description, result); 
	}
	
	public static Integer[] getInputArray(int n, String type) {
		ArrayList<Integer> arr = new ArrayList<>();
		
		switch(type) {
		case "Ordered": 
			for (int i=0; i < n; i++) {
				arr.add(i+1);	
			}
			break;
		case "Partial":
			for (int i=0; i < n; i++) {
	            if (i > n/2) {
	            	arr.add(random.nextInt(n));
	            } else {
	            	arr.add(i);
	            }
	        }
			break;
		case "Random": 
			for (int i=0; i < n; i++) {
				arr.add(random.nextInt(n));	
	        }
			break;
		case "Reverse": 
			for (int i=0; i < n; i++) {
				arr.add(n-i);	
	        }
			break;
		default: 
			for (int i=0; i < n; i++) {
				arr.add(i+1);	//Ordered
			}
			break;
		}
		
		Integer[] result = arr.toArray(new Integer[arr.size()]);
        return result;
	}
}
