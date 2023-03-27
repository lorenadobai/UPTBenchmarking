package bech;


public class Sleep implements IBenchmark
{
	private long n;
	public void run() {
		try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
	}

	public void run(Object... params) {
		 int n = (Integer) params[0];
	        try {
	            Thread.sleep(n);
	        } catch (InterruptedException e) {
	            throw new RuntimeException(e);
	        }
	}

	public void initialize(Object... params) {
		 this.n = (Integer) params[0];
	}

	public void clean() {
		
	}

	public void cancel() {
	
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