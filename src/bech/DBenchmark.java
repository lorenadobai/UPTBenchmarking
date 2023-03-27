package bech;

import java.util.Random;

public class DBenchmark implements IBenchmark
{
	private int n;
	private int[] array;
	
	public void run() {
		boolean isSorted;
        int sortedPortion = 1;
        do{
            isSorted = true;
            for(int i = 0; i < this.n - sortedPortion; i++) {
                if(array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    isSorted = false;
                }
            }
            sortedPortion++;
        }while(!isSorted);
	}

	public void clean() {

	}

	public void cancel() {

	}

	public void run(Object... params) {
		 boolean isSorted;
	        int sortedPortion = 1;
	        do{
	            isSorted = true;
	            for(int i = 0; i < this.n - sortedPortion; i++) {
	                if(array[i] > array[i+1]) {
	                    int temp = array[i];
	                    array[i] = array[i+1];
	                    array[i+1] = temp;
	                    isSorted = false;
	                }
	            }
	            sortedPortion++;
	        }while(!isSorted);
	}

	public void initialize(Object... params) {
		 Random random = new Random();
	        this.n = (Integer) params[0];
	        this.array = new int[n];

	        for(int i = 0; i < n; i++) {
	            array[i] = random.nextInt();
	        }
	}

	@Override
	public void warmup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}
	
}