package yfain.presentation.rxjava; /**
 * Created by yfain11 on 4/9/16.
 */

import rx.Observable;
import yfain.presentation.rxjava.drink.Beer;
import yfain.presentation.rxjava.stock.BeerStock;

public class ObservableErrorComplete {

    private static BeerStock beerStock = new BeerStock();

    public static void main(String[] args) {

        System.out.println("== Observable creation from an Iterable");

        Observable<Beer> observableBeer = Observable.from(beerStock);

        observableBeer.subscribe(
                beer -> System.out.println(beer),
                error -> System.err.println(error),
                () -> System.out.println("Streaming is over")
        );
    }
}
