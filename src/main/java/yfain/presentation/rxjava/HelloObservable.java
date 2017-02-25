package yfain.presentation.rxjava; /**
 * Created by yfain11 on 4/9/16.
 */
import rx.Observable;
import yfain.presentation.rxjava.drink.Beer;
import yfain.presentation.rxjava.stock.BeerStock;

public class HelloObservable {

    private static BeerStock beerStock = new BeerStock();

    public static void main(String[] args) {


        Observable<Beer> observableBeer = Observable.from(beerStock);   // Create Observable from List

        observableBeer.subscribe(System.out::println);    // onNext handler
    }
}
