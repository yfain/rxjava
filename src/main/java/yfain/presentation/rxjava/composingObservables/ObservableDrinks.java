package yfain.presentation.rxjava.composingObservables;

import rx.Observable;
import yfain.presentation.rxjava.drink.Beer;
import yfain.presentation.rxjava.drink.Drink;
import yfain.presentation.rxjava.drink.SoftDrink;
import yfain.presentation.rxjava.stock.BeerStock;
import yfain.presentation.rxjava.stock.SoftDrinkStock;

import java.util.ArrayList;
import java.util.List;

public class ObservableDrinks {

    static List<List<? extends Drink>> drinks = new ArrayList<>();


    static List<? extends Drink> beerStock = new BeerStock();


    static List<? extends Drink> softStock = new SoftDrinkStock();


    public static Observable<List<? extends Drink>> getDrinks(){

        Observable<List<? extends Drink>> beerPallets = Observable.create(subscriber -> {

            subscriber.onNext(beerStock);   // push the beers pallet

            subscriber.onNext(softStock); // push the soft drink pallet

            subscriber.onCompleted();
        });

        return beerPallets;
    }

    public static void main(String[] args) {
        Observable<List<? extends Drink>> pallets = getDrinks();

        pallets
            .flatMap(pallet -> Observable.from(pallet))
            .subscribe(
                data -> System.out.println("Subscriber received " + data),
                (error) -> System.err.println(error),
                () -> System.out.println("*** The stream is over ***")
            );
    }
}
