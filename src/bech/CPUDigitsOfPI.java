package bech;

import java.math.BigDecimal;
public class CPUDigitsOfPI implements IBenchmark{

	private int precision;
	public BigDecimal result;
	   
	public void initialize(Object... params) {
		precision = (Integer) params[0];
	}
	
	public void run() {
		result = approxPi();
		//System.out.println(result);
	}
	
	public void run(Object... params) {
		int options = (Integer) params[0];
		switch (options) {
		case 1:
			result = approxPi();
			//System.out.println(result);
		break;
		
		case 2:
			System.out.println("Hello!");
		break;
		
		default: 
			throw new IllegalArgumentException("Invalid Argument!");
		}
	}
	
	public void clean() {
		
	}
	
	public void cancel() {
		
	}

	
	
	@SuppressWarnings("deprecation")
	public BigDecimal approxPi() {
		BigDecimal[] ar = new BigDecimal[precision];
        BigDecimal[] br = new BigDecimal[precision];
        BigDecimal[] tr = new BigDecimal[precision];
        BigDecimal[] pr = new BigDecimal[precision];

        for (int i = 1; i < precision; i++) {
            // initializing first value of all arrays
            ar[0] = BigDecimal.ONE;
            br[0] = BigDecimal.ONE.divide(BigDecimal.valueOf(Math.sqrt(2)), precision, BigDecimal.ROUND_HALF_UP);
            tr[0] = BigDecimal.ONE.divide(BigDecimal.valueOf(4), precision, BigDecimal.ROUND_HALF_UP);
            pr[0] = BigDecimal.ONE;

            ar[i] = (ar[i - 1].add(br[i - 1])).divide(BigDecimal.valueOf(2), precision, BigDecimal.ROUND_HALF_UP);

            br[i] = BigDecimal.valueOf(Math.sqrt(ar[i - 1].multiply(br[i - 1]).doubleValue()));

            BigDecimal subtract = ar[i - 1].subtract(ar[i]);
            tr[i] = tr[i - 1].subtract(pr[i - 1].multiply(subtract).multiply(subtract))
                    .setScale(precision, BigDecimal.ROUND_HALF_UP);

            pr[i] = pr[i - 1].multiply(BigDecimal.valueOf(2));
        }

        BigDecimal pi = (ar[precision - 1].add(br[precision - 1])).pow(2).divide(tr[precision - 1].multiply(BigDecimal.valueOf(4)), precision,
                BigDecimal.ROUND_HALF_UP);
        return pi;
	}
	
	
	
	 public void warmup() {
	        for(int i = 0; i < 10; i++) {
	            this.result = approxPi();
	        }
	    }

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	
}