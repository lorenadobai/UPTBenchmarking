package testbench;

import logging.ILog;
import logging.ConsoleLogger;
import timing.ITimer;
import timing.Timer;
import timing.TimeConverter;
import bech.IBenchmark;
import bech.CPUDigitsOfPI;


class TestbenchDigitsOfPi{
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new CPUDigitsOfPI();
        TimeConverter newTime = new TimeConverter(); 


        bench.initialize(30000);

        timer.start();
        bench.run();
        long time = timer.stop();

        log.write("Finished in " + newTime.convert(time, "seconds") + "s\n");
        log.close();
        bench.clean();
    }
}