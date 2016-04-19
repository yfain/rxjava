package composingObservables;

public abstract class Drink {
    public String name;
    public String country;
    public float price;

    Drink(String name, String country,float price){
        this.name=name;
        this.country=country;
        this.price=price;
    }

    public String toString(){
        return  name + "(" + country + ")";
    }

}
