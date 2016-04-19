/**
 * Created by yfain11 on 4/9/16.
 */
import rx.Observable;

import java.util.ArrayList;
import java.util.List;

public class HelloObservable {

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

        Observable<Beer> observableBeer = null;

        System.out.println("== Observable creation from an Iterable");

        observableBeer = Observable.from(beers);

        observableBeer.subscribe(
                beer -> System.out.println(beer)    // onNext handler
        );
    }
}
