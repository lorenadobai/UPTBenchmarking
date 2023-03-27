package logging;

public interface ILog {
	void write(long l);
	void write(String s);
	void write(Object... values);
	void close();
	public void writeTime(long value, TimeUnit unit);
	public void writeTime(String string, long value, TimeUnit unit);
}
