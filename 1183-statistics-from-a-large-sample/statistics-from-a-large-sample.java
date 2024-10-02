class Solution {
    public double[] sampleStats(int[] count) {
        double[] stat = new double[5];
        
        // Find minimum value (stat[0])
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                stat[0] = i;
                break;
            }
        }

        // Find maximum value (stat[1])
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] != 0) {
                stat[1] = i;
                break;
            }
        }

        // Use long for sum to avoid overflow
        long sum = 0;
        int countVal = 0;
        int maxFreq = -1, maxIndex = -1;
        for (int i = 0; i < count.length; i++) {
            sum += (long)i * count[i];  // Cast i to long to avoid overflow
            countVal += count[i];
            if (count[i] > maxFreq) {
                maxFreq = count[i];
                maxIndex = i;
            }
        }
        stat[2] = (double) sum / countVal;  // Mean
        stat[4] = maxIndex;                 // Mode

        // Find median
        boolean isEven = (countVal % 2 == 0);
        int medianPos1 = (countVal + 1) / 2;   // Position for median if odd
        int medianPos2 = isEven ? medianPos1 + 1 : medianPos1; // For even, use two middle values

        int cumulativeCount = 0;
        int median1 = -1, median2 = -1;
        
        for (int i = 0; i < count.length; i++) {
            cumulativeCount += count[i];

            // Find the first median position
            if (median1 == -1 && cumulativeCount >= medianPos1) {
                median1 = i;
            }

            // Find the second median position for even case
            if (cumulativeCount >= medianPos2) {
                median2 = i;
                break;
            }
        }

        // Calculate median value based on whether countVal is odd or even
        stat[3] = isEven ? (median1 + median2) / 2.0 : median1;

        return stat;
    }
}
