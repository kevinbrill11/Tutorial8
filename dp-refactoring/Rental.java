import util.DateRange;

class Rental {
    private final Movie movie;

    private int _daysRented;
    public Rental(Movie movie, DateRange dateRange) {
        this.movie = movie;
        _daysRented = (int)((dateRange.getEnd().getTime() - dateRange.getStart().getTime()) / (1000 * 60 * 60 * 24));
    }
    public int getDaysRented() {
        return _daysRented;
    }

    public String getTitle() {
        return movie.getTitle();
    }
    
    public int getPriceCode() {
        return movie.getPriceCode();
    }

    public double getCharge() {
        double thisAmount = 0;
        switch (getPriceCode()) {
        case Movie.REGULAR:
            thisAmount += 2;
            if (getDaysRented() > 2) {
                thisAmount += (getDaysRented() - 2) * 1.5;
            }
            break;
        case Movie.NEW_RELEASE:
            thisAmount += getDaysRented() * 3;
            break;
        case Movie.CHILDRENS:
            thisAmount += 1.5;
            if (getDaysRented() > 3) {
                thisAmount += (getDaysRented() - 3) * 1.5;
            }
            break;
        }
        return thisAmount;
    }
    public int getFrequentRenterPoints() {
        // add frequent renter points
        // add bonus for a two day new release rental
        int frequentRenterPoints = 0;
        if ((this.getPriceCode() == Movie.NEW_RELEASE)
                && this.getDaysRented() > 1) frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
