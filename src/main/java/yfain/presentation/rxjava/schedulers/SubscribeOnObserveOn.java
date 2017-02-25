package yfain.presentation.rxjava.schedulers;

import rx.Observable;
import rx.schedulers.Schedulers;
import yfain.presentation.rxjava.drink.Beer;
import yfain.presentation.rxjava.stock.BeerStock;

import java.util.List;

public class SubscribeOnObserveOn {

    public static void main(String[] args) {

        List<Beer> beers = new BeerStock();// populate the beer collection

        Observable<Beer> observableBeers = null;

        observableBeers.from(beers)
                .subscribeOn(Schedulers.computation())  // push data on computation thread
                .doOnNext(SubscribeOnObserveOn::log)            // Side effect: Log on computation thread
                .observeOn(Schedulers.io())             // Process on another io thread
                .subscribe(SubscribeOnObserveOn::matureBeer);

        // Sleep just to keep the program running
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void matureBeer(Beer beer){
        try {
            System.out.println("** Maturing " + beer.name +
                    " on " + Thread.currentThread().getName());

            Thread.sleep((int)(Math.random()*500));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void log(Beer beer){
        System.out.println("===> Logging " + beer.name +
                           " on "  + Thread.currentThread().getName() );
    }
}
