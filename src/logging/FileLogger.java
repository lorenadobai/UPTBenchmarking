package logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class FileLogger implements ILog
{
	private PrintWriter pw;

	private BufferedWriter writer;
	public FileLogger(String filename) {
	       try {
	           writer = new BufferedWriter(new FileWriter(filename));
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
    }
	 
	public void write(long l) {
		try {
            writer.write(String.valueOf(l));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void write(String s) {
		try {
            writer.write(s);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void write(Object... values) {
		StringBuilder builder = new StringBuilder();
        for (Object value : values) {
            builder.append(value.toString()).append(" ");
        }
        try {
            writer.write(builder.toString().trim());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void close() {
		try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void writeTime(long value, TimeUnit unit) {
		pw.println(String.valueOf(TimeUnit.toTimeUnit(value, unit)));
	}

	@Override
	public void writeTime(String string, long value, TimeUnit unit) {
		pw.println(string + " " + TimeUnit.toTimeUnit(value, unit));
	}

	
	
	
}