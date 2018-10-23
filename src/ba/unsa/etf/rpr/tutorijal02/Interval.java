package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka, krajnjaTacka;
    private boolean pripadnostPocetneTacke, pripadnostKrajnjeTacke;

    public Interval() {
        this(0, 0, false, false);
    }

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pripadnostPocetneTacke, boolean pripadnostKrajnjeTacke) throws IllegalArgumentException {
        if (pocetnaTacka > krajnjaTacka) throw new IllegalArgumentException("Neispravni parametri!");
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pripadnostPocetneTacke = pripadnostPocetneTacke;
        this.pripadnostKrajnjeTacke = pripadnostKrajnjeTacke;
    }

    public double getPocetnaTacka() {
        return pocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public boolean isPripadnostPocetneTacke() {
        return pripadnostPocetneTacke;
    }

    public boolean isPripadnostKrajnjeTacke() {
        return pripadnostKrajnjeTacke;
    }

    public void setPocetnaTacka(double pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
    }

    public void setKrajnjaTacka(double krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
    }

    public void setPripadnostPocetneTacke(boolean pripadnostPocetneTacke) {
        this.pripadnostPocetneTacke = pripadnostPocetneTacke;
    }

    public void setPripadnostKrajnjeTacke(boolean pripadnostKrajnjeTacke) {
        this.pripadnostKrajnjeTacke = pripadnostKrajnjeTacke;
    }

    public boolean isNull() {
        if (this.getKrajnjaTacka() == 0 && this.getPocetnaTacka() == 0 && !pripadnostPocetneTacke && !pripadnostKrajnjeTacke)
            return true;
        return false;
    }

    public boolean isIn(double vrijednostTacke) {
        if (this.getPocetnaTacka() < vrijednostTacke && vrijednostTacke < this.getKrajnjaTacka())
            return true;
        return false;
    }
}
