package bech;

import bech.IBenchmark;

public class CPUFixedVsFloatingPoint implements IBenchmark {

	private double result;
	private int size;

	@Override
	public void initialize(Object ... params) {
		this.size = (Integer)params[0];	
	}

	@Override
	public void warmup() {
		for (int i = 0; i < size; ++i) {
			result =i/256 ; // fixed
			result =(i/256.0) ; // floating
		}
	}

	@Override
	@Deprecated	
	public void run() {
	}

	public void IArithmeticTest(){
		int j=0,k=0,l=0;
		int [] num= { 0, 1, 2, 3 };
		int [] res = null;
		for(int i=0;i<size;i++)
		{
			j = num[1] * (k - j) * (l - k);
			k = num[3] * k - (l - j) * k;
			l = (l - k) * (num[2] + j);
			res[l - 2] = j + k + l;
			res[k - 2] = j * k * l;
		}
	}
	
	public void BranchingTest()
	{
		
	}
	
	@Override
	public void run(Object ...options) {
		//result = 0;
		
		//switch ((NumberRepresentation) options[0]) {
		//case FLOATING:
		//	for (int i = 0; i < size; ++i)
			//	result +=(i/256.0); /**/
			//break;
		//case FIXED:
			//for (int i = 0; i < size; ++i)				
				//result +=i/256; /**/
		//	break;
		//default:
			//break;
		//}
	}
	
	@Override
	public void cancel() {
		
	}

	@Override
	public void clean() {
	}

	@Override
	public String getResult() {
		return String.valueOf(result);
	}


}