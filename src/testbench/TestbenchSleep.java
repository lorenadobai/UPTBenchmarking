package testbench;

import bech.IBenchmark;
import bech.Sleep;
import logging.ConsoleLogger;
import logging.ILog;
import timing.ITimer;
import timing.Timer;

public class TestbenchSleep {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new Sleep();

        final int workload = 250;

        bench.initialize(workload);
        timer.start();

        for(int i = 0; i < 12; i++) {
            timer.resume();
            bench.run();
            long time = timer.pause();
            log.write("Run " + i + ":" , time);
        }
        long time = timer.stop();

        long offset = (long) (100 * (time - workload * 10e6)/(workload * 10e6));

        log.write("Finished in " + time + " ns");
        log.write("Offset :" + offset);
        log.close();
        bench.clean();


    }
}