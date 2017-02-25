package yfain.presentation.rxjava;

import rx.Observable;
import rx.Subscriber;
import yfain.presentation.rxjava.drink.Beer;
import yfain.presentation.rxjava.stock.BeerStock;

public class BeerServer {

    private static BeerStock beerStock = new BeerStock();


    public static Observable<Beer> getData(){

        System.out.println("*** Getting beers from the main data source ***");

        // Create an observable passing subscriber (implements Observer)
        // provided by the client

        Observable.OnSubscribe<Beer> onSubscribe = subscriber -> {
            beerStock.forEach(beer -> BeerServer.subscribeBeer(subscriber, beer));
            subscriber.onCompleted();
        };

        return Observable.create(onSubscribe);
    }

    static void subscribeBeer(Subscriber<? super Beer> subscriber, Beer beer) {
        subscriber.onNext(beer);

        try {
            Thread.sleep(500); // Emulating delay in getting data
        } catch (InterruptedException e) {
            subscriber.onError(new Throwable("Error in getting beer info"));
        }
    }
}
