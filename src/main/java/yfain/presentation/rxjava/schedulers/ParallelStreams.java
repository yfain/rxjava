package yfain.presentation.rxjava.schedulers;

import rx.schedulers.Schedulers;
import rx.Observable;
import yfain.presentation.rxjava.drink.Beer;
import yfain.presentation.rxjava.stock.BeerStock;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreams {
    public static void main(String[] args) {

        List<Beer> beers = new BeerStock();  // populate the beer collection

        Observable<Beer> observableBeers = Observable.from(beers);

        observableBeers
                .flatMap(beer -> Observable.just(beer)
                               .subscribeOn(Schedulers.computation())  // new thread for each observable
                               .map(ParallelStreams::matureBeer)
                 )

                .subscribe(ParallelStreams::log);


        // Just to keep the program running
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void log(Beer beer) {
        System.out.println("Subscriber got " +
                beer.name + " on  " +
                Thread.currentThread().getName());
    }

    private static Beer matureBeer(Beer beer){
        try {
            System.out.println("** Maturing " + beer.name +
                    " on " + Thread.currentThread().getName());

            Thread.sleep((int)(Math.random()*500));
            return beer;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
