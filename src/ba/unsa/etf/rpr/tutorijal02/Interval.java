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
        else if (this.getPocetnaTacka() == vrijednostTacke && this.isPripadnostPocetneTacke())
            return true;
        else if (this.getKrajnjaTacka() == vrijednostTacke && this.isPripadnostKrajnjeTacke())
            return true;
        return false;
    }

    public Interval intersect(Interval i) {
        if (this.getKrajnjaTacka() < i.getPocetnaTacka()) return new Interval();
        else if (this.getPocetnaTacka() > i.getKrajnjaTacka()) return new Interval();
        else if (this.getKrajnjaTacka() == i.getPocetnaTacka()) {
            if (!this.isPripadnostKrajnjeTacke() || !i.isPripadnostPocetneTacke())
                return new Interval();
            return new Interval(this.getKrajnjaTacka(), this.getKrajnjaTacka(), true, true);
        } else if (this.getPocetnaTacka() == i.getKrajnjaTacka()) {
            if (!this.isPripadnostPocetneTacke() || !i.isPripadnostKrajnjeTacke())
                return new Interval();
            return new Interval(this.getPocetnaTacka(), this.getPocetnaTacka(), true, true);
        } else if (i.getPocetnaTacka() == this.getPocetnaTacka() && i.getKrajnjaTacka() == this.getKrajnjaTacka()) {
            if (!this.isPripadnostPocetneTacke() || !i.isPripadnostPocetneTacke()) {
                if (!this.isPripadnostKrajnjeTacke() || !i.isPripadnostKrajnjeTacke())
                    return new Interval(this.getPocetnaTacka(), this.getKrajnjaTacka(), false, false);
                else return new Interval(this.getPocetnaTacka(), this.getKrajnjaTacka(), false, true);
            } else if (this.isPripadnostPocetneTacke() && i.isPripadnostPocetneTacke()) {
                if (!this.isPripadnostKrajnjeTacke() || !i.isPripadnostKrajnjeTacke())
                    return new Interval(this.getPocetnaTacka(), this.getKrajnjaTacka(), true, false);
                else return new Interval(this.getPocetnaTacka(), this.getKrajnjaTacka(), true, true);
            }
        } else if (i.getPocetnaTacka() < this.getPocetnaTacka()) {
            if (i.getKrajnjaTacka() > this.getKrajnjaTacka())
                return new Interval(this.getPocetnaTacka(), this.getKrajnjaTacka(), this.isPripadnostPocetneTacke(), this.isPripadnostKrajnjeTacke());
            else
                return new Interval(this.getPocetnaTacka(), i.getKrajnjaTacka(), this.isPripadnostPocetneTacke(), i.isPripadnostKrajnjeTacke());
        } else if (this.getPocetnaTacka() < i.getPocetnaTacka()) {
            if (this.getKrajnjaTacka() > i.getKrajnjaTacka())
                return new Interval(i.getPocetnaTacka(), i.getKrajnjaTacka(), i.isPripadnostPocetneTacke(), i.isPripadnostKrajnjeTacke());
            else
                return new Interval(i.getPocetnaTacka(), this.getKrajnjaTacka(), i.isPripadnostPocetneTacke(), this.isPripadnostKrajnjeTacke());
        }
        return new Interval();
    }

    public static Interval intersect(Interval i1, Interval i2) {
        return i1.intersect(i2);
    }

    @Override
    public String toString() {
        if (this.isNull()) return new String("()");
        else if (this.isPripadnostPocetneTacke()) {
            if (this.isPripadnostKrajnjeTacke())
                return new String("[" + this.getPocetnaTacka() + "," + this.getKrajnjaTacka() + "]");
            return new String("[" + this.getPocetnaTacka() + "," + this.getKrajnjaTacka() + ")");
        } else {
            if (this.isPripadnostKrajnjeTacke())
                return new String("(" + this.getPocetnaTacka() + "," + this.getKrajnjaTacka() + "]");
            return new String("(" + this.getPocetnaTacka() + "," + this.getKrajnjaTacka() + ")");
        }
    }

    @Override
    public boolean equals(Object o) {
        Interval i = (Interval) o;
        if (this.getPocetnaTacka() == i.getPocetnaTacka() && this.getKrajnjaTacka() == i.getKrajnjaTacka() && this.isPripadnostPocetneTacke() == i.isPripadnostPocetneTacke() && this.isPripadnostKrajnjeTacke() == i.isPripadnostKrajnjeTacke())
            return true;
        return false;
    }
}
