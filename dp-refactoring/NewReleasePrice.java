public class NewReleasePrice extends Price{

    public int getPriceCode() {

        return Movie.NEW_RELEASE;

    }

    @Override
    public double getCharge(int daysRented) {

        //determine amounts for each line

        double result = 0;

            result += daysRented * 3;

        return result;

    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;
        if (daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
