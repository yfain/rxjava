package yfain.presentation.rxjava;

import rx.Observable;
import rx.Subscriber;
import yfain.presentation.rxjava.drink.Beer;

public class BeerClient {
    public static void main(String[] args) {

        Observable<Beer> beerData = BeerServer.getData(); // no data coming in yet!!!

        beerData
            .subscribe(new Subscriber<Beer>() {

                // Implementing the Observer
                public void onNext(Beer beer) {
                    System.out.println(beer);
                }

                public void onError(Throwable throwable) {
                    System.err.println("Client received: " + throwable.getMessage());
                }

                public void onCompleted() {
                    System.out.println("*** The stream is over ***");
                }
        });
    }
}