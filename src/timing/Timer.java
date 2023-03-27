package timing;

public class Timer implements ITimer
{
	private long elapsedTime = 0;
	private long totalTime = 0;
	public void start() {
		elapsedTime = System.nanoTime();
		totalTime = 0;
	}
	public long stop() {
		elapsedTime = System.nanoTime() - elapsedTime;
		totalTime = totalTime + elapsedTime;
		return totalTime;
	}
	public void resume() {
		elapsedTime = System.nanoTime();
	}
	public long pause() {
		elapsedTime = System.nanoTime() - elapsedTime;
		totalTime = totalTime + elapsedTime;
		return elapsedTime;
	}
}