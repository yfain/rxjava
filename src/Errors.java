import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Errors {
    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println(LocalTime.now());

        ScheduledExecutorService timeService = Executors
                .newSingleThreadScheduledExecutor();

        timeService.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
    }

/*
    Observable.create(subscriber -> {
        try {
            subscriber.onNext("Hello World!");
            subscriber.onCompleted();
        } catch (Exception e) {
            subscriber.onError(e);
        }
    }).subscribe(System.out::println);*/

}