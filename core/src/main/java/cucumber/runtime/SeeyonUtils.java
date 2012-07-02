package cucumber.runtime;

import gherkin.formatter.model.Result;
import gherkin.formatter.model.Step;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-10
 * Time: 下午2:43
 * To change this template use File | Settings | File Templates.
 */
public class SeeyonUtils {

    public static void main(String[] arg) {
        SeeyonUtils u = new SeeyonUtils();
        long millis = 111000;
        System.out.println(u.getDurationSeconds(millis));
        System.out.println(u.getDurationMills(millis));


    }

    public void printDuration(String name, long start, long end) {
        if (end == 0 && start == 0) {
            System.out.println("\r\n[" + name + "] start.");
        } else {
            System.out.println("\r\n[" + name + "] ended in "
                    + getDurationSeconds(end - start));
        }
    }

    public void printStepStatus(Step _step, Result _result) {
        String keyword = _step.getKeyword().trim();
        String name = _step.getName().trim();
        if (_result == null) {
            System.out.println("\r\n[" + keyword + ": " + name + "] start.");
        } else {
            long durationMillis = _result.getDuration() == null ? 0 : _result.getDuration() / 1000000L;
            if (_result.getErrorMessage() != null) {
                System.out.println("\r\n" + _result.getErrorMessage());
            }
            System.out.println("\r\n[" + keyword + ": " + name + "] "
                    + _result.getStatus() + " in "
                    + getDurationSeconds(durationMillis));
        }
    }

    public String getDurationMills(long millis) {
        return String.format("%d min %d sec %d ms",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)),
                TimeUnit.MILLISECONDS.toMillis(millis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millis))
        ) + ".";
    }

    public String getDurationSeconds(long millis) {
        return String.format("%d min %d sec",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))) + ".";
    }

}


