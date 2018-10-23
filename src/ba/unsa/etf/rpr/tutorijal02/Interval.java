package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka, krajnjaTacka;
    private boolean pripadnostPocetneTacke, pripadnostKrajnjeTacke;
    public Interval() { this(0,0,false,false); }
    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pripadnostPocetneTacke, boolean pripadnostKrajnjeTacke) throws IllegalArgumentException {
        if (pocetnaTacka > krajnjaTacka) throw new IllegalArgumentException("Neispravni parametri!");
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pripadnostPocetneTacke = pripadnostPocetneTacke;
        this.pripadnostKrajnjeTacke = pripadnostKrajnjeTacke;
    }
    
}
