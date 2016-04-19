/**
 * Created by yfain11 on 4/9/16.
 */
import rx.Observable;

import java.util.ArrayList;
import java.util.List;

public class StreamVsObservable {

    // Populate beer collection
    static List<Beer> loadCellar(){
        List<Beer> beerStock = new ArrayList<>();

        beerStock.add(new Beer("Obolon", "Ukraine", 4.00f));
        beerStock.add(new Beer("Stella", "Belgium", 7.75f));
        beerStock.add(new Beer("Sam Adams", "USA", 7.00f));
        beerStock.add(new Beer("Bud Light", "USA", 5.00f));
        beerStock.add(new Beer("Yuengling", "USA", 5.50f));
        beerStock.add(new Beer("Leffe Blonde", "Belgium", 8.75f));
        beerStock.add(new Beer("Chimay Blue", "Belgium", 10.00f));
        beerStock.add(new Beer("Brooklyn Lager", "USA", 8.25f));

        return beerStock;
    }

    public static void main(String[] args) {

        List<Beer> beers = loadCellar();  // populate the beer collection

        // === Java 8 Stream
        System.out.println("\n== Iterating over Java 8 Stream");

        beers.stream()
                .skip(1)
                .limit(3)
                .filter(b -> "USA".equals(b.country))
                .map(b -> b.name + ": $" + b.price)
                .forEach(beer -> System.out.println(beer));

        // === RxJava Observable

        Observable<Beer> observableBeer = null;

        System.out.println("\n== Subscribing to Observable ");

        observableBeer = Observable.from(beers);

        observableBeer
                .skip(1)
                .take(3)
                .filter(b -> "USA".equals(b.country))
                .map(b -> b.name + ": $" + b.price)
                .subscribe(
                        beer -> System.out.println(beer),
                        err -> System.out.println(err),
                        () -> System.out.println("Streaming is complete")
        );
    }
}
