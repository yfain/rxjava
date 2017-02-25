package yfain.presentation.rxjava.stock;

import yfain.presentation.rxjava.drink.Beer;

import java.util.ArrayList;

/**
 * Created by ievgenii on 22.02.17.
 */
public class BeerStock extends ArrayList<Beer> {
    {
        add(new Beer("Obolon", "Ukraine", 4.00f));
        add(new Beer("Stella", "Belgium", 7.75f));
        add(new Beer("Sam Adams", "USA", 7.00f));
        add(new Beer("Bud Light", "USA", 5.00f));
        add(new Beer("Yuengling", "USA", 5.50f));
        add(new Beer("Leffe Blonde", "Belgium", 8.75f));
        add(new Beer("Chimay Blue", "Belgium", 10.00f));
        add(new Beer("Brooklyn Lager", "USA", 8.25f));
    }
}
