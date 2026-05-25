class Solution {
    public double[] convertTemperature(double celsius) {
        // Omjee is the GOAT
        double kel = celsius + 273.15;
        double far = (celsius * 1.80) + 32.00;
        double[] res = new double[2];
        res[0]=kel;
        res[1]=far;
        return res;
    }
}