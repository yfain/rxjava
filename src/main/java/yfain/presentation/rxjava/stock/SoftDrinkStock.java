package yfain.presentation.rxjava.stock;

import yfain.presentation.rxjava.drink.Drink;
import yfain.presentation.rxjava.drink.SoftDrink;

import java.util.ArrayList;

/**
 * Created by ievgenii on 22.02.17.
 */
public class SoftDrinkStock extends ArrayList<SoftDrink> {
    {
        add(new SoftDrink("Lemonade", "Ukraine", 1.00f));
        add(new SoftDrink("Pepsi", "USA", 2.00f));
        add(new SoftDrink("Fanta", "USA", 3.00f));

    }
}
