package schedulers;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class SubscribeOnObserveOn {

    public static void main(String[] args) {

        List<Beer> beers = loadCellar();  // populate the beer collection

        Observable<Beer> observableBeers = null;

        observableBeers.from(beers)
                .subscribeOn(Schedulers.computation())  // push data on computation thread
                .doOnNext(beer -> log(beer))            // Side effect: Log on computation thread
                .observeOn(Schedulers.io())             // Process on another io thread
                .subscribe(beer -> matureBeer(beer));

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

    // Populate beer collection
    static List<Beer> loadCellar() {
        List<Beer> beerStock = new ArrayList<>();

        beerStock.add(new Beer("Stella", "Belgium", 7.75f));
        beerStock.add(new Beer("Sam Adams", "USA", 7.00f));
        beerStock.add(new Beer("Obolon", "Ukraine", 4.00f));
        beerStock.add(new Beer("Bud Light", "USA", 5.00f));
        beerStock.add(new Beer("Yuengling", "USA", 5.50f));
        beerStock.add(new Beer("Leffe Blonde", "Belgium", 8.75f));
        beerStock.add(new Beer("Chimay Blue", "Belgium", 10.00f));
        beerStock.add(new Beer("Brooklyn Lager", "USA", 8.25f));

        return beerStock;
    }
}
