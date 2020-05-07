public class RecursionExponent {

    public double findExponent(double value, int exponent) {
        if (exponent == 1) {
            return value;
        } else if (exponent > 1) {
            return recursionPositivExponentHelper(value, value, --exponent);
        } else if (exponent == -1) {
            return 1/value;
        } else if(exponent < -1) {
            return recursionNegativExponentHelper(1/value, 1/value, ++exponent);
        } else {
            return 1;
        }
    }

    public double recursionPositivExponentHelper(double value, double prevRezult, int exponent) {
        double result = prevRezult * value ;
        if(exponent > 1 ) {
            return recursionPositivExponentHelper(value, result, --exponent);
        } else {
            return result;
        }
    }

    public double recursionNegativExponentHelper(double value, double prevRezult, int exponent) {
        double result = prevRezult * value;
        if(exponent < -1 ) {
            return recursionNegativExponentHelper(value, result, ++exponent);
        } else {
            return result;
        }
    }
}
