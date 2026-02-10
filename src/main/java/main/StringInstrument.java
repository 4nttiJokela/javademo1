package main;

public class StringInstrument extends Instrument {

    private int numberOfStrings;

    public StringInstrument (String manufacturer, int price, int numberOfStrings) {
        super(manufacturer, price);
        this.numberOfStrings = numberOfStrings;
    }

    public void tune() {
        System.out.println(manufacturer + " soittimesta viritettiin " + numberOfStrings +" kieltä!");
    }
}
