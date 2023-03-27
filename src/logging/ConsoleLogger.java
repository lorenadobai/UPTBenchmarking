package logging;

public class ConsoleLogger implements ILog
{
	public void write(long l) {
		System.out.println(l);
	}
	
	public void write(String s) {
		System.out.println(s);
	}

	public void write(Object... values) {
		for(Object obj : values){
			System.out.print(obj);
		}
		System.out.println();
	}

	public void close() {
		
	}

	public void writeTime(long value, TimeUnit unit) {
		System.out.println(String.valueOf(TimeUnit.toTimeUnit(value, unit)));
	}

	@Override
	public void writeTime(String string, long value, TimeUnit unit) {
		System.out.println(string + " " + TimeUnit.toTimeUnit(value, unit));
	}
}