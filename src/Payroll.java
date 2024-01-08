public class Payroll {
    private int[] itemsSold; // number of items sold by each employee
    private double[] wages; // wages to be computed in part (b)

    /* Creates a Payroll object

       PRECONDITIONS: items != null, items.length >= 3
     */
    public Payroll(int[] items) {
      itemsSold = items;
      wages = new double[items.length];
    }
    public double[] getWages() {
        return wages;
    }

    /*  Returns the bonus threshold as described in part (a).
     */
    public double computeBonusThreshold() {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int itemAmounts = 0;
        double bonus = 0;
        for (int items : itemsSold) {
            itemAmounts += items;
            if (items > max) {
                max = items;
            }
            if (items < min) {
                min = items;
            }
        }
        itemAmounts -= max + min;
        bonus = (double) itemAmounts / (itemsSold.length - 2);
        return bonus;
    }


    /* Computes employee wages as described in part (b) and stores
       them in wages. The parameter fixedWage represents the fixed
       amount each employee is paid per day. The parameter
       perItemWage represents the amount each employee is paid per
       item sold.
     */
    public void computeWages(double fixedWage, double perItemWage) {
        double wage = 0;
        int index = 0;
        for (int items : itemsSold) {
            wage = fixedWage + (perItemWage * items);
            if (items > computeBonusThreshold()) {
                wage *= 1.1;
            }
            wages[index] = wage;
            index++;
            wage = 0;
        }
    }

}

