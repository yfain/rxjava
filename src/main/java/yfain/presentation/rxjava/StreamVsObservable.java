package yfain.presentation.rxjava; /**
 * Created by yfain11 on 4/9/16.
 */
import rx.Observable;
import yfain.presentation.rxjava.drink.Beer;
import yfain.presentation.rxjava.stock.BeerStock;

public class StreamVsObservable {

    private static BeerStock beerStock = new BeerStock();

    public static void main(String[] args) {

        // === Java 8 Stream
        System.out.println("\n== Iterating over Java 8 Stream");

        beerStock.stream()
                .skip(1)
                .limit(3)
                .filter(StreamVsObservable::isMadeInUSA)
                .map(StreamVsObservable::mapWithPrice)
                .forEach(System.out::println);

        // === RxJava Observable

        Observable<Beer> observableBeer = null;

        System.out.println("\n== Subscribing to Observable ");

        observableBeer = Observable.from(beerStock);

        observableBeer
                .skip(1)
                .take(3)
                .filter(StreamVsObservable::isMadeInUSA)
                .map(StreamVsObservable::mapWithPrice)
                .subscribe(
                        beer -> System.out.println(beer),
                        err -> System.out.println(err),
                        () -> System.out.println("Streaming is complete")
        );
    }

    static boolean isMadeInUSA(Beer beer){
        return "USA".equals(beer.country);
    }

    static String mapWithPrice(Beer beer) {
        return beer.name + ": $" + beer.price;
    }
}
