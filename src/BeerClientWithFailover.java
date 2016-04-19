/**
 * Created by yfain11 on 4/19/16.
 */
import rx.Observable;

public class BeerClientWithFailover {
    public static void main(String[] args) {

        Observable<Beer> beerData = BeerServerWithFailover.getData(); // get data from main server

        beerData
            .onErrorResumeNext(err -> {
                System.out.println("!!! Switching to an alternative data source because of : "+ err.getMessage());
                return BeerServerWithFailover.getDataFromAnotherServer();})   // get data from alternative server

            .subscribe(
                // Implementing the observer
                beer -> System.out.println(beer),
                (error) -> System.err.println("Client received: " + error.getMessage()),
                () -> System.out.println("*** The stream is over ***")
        );
    }
}