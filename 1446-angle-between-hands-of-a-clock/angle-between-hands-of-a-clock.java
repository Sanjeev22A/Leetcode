class Solution {
    double oneHrDeg=30.0;
    double convertMinuteToHourDegMovement(int minutes){
        return (double)minutes/60.0*oneHrDeg;
    }
    double convertToAngle(double h){
        return (h*oneHrDeg)%360;
    }
    public double angleClock(int hour, int minutes) {
        double minutePosition=(double)minutes/5.0;
        double minuteAngle=convertToAngle(minutePosition);
        double hourAngle=convertToAngle((double)hour);
        hourAngle+=convertMinuteToHourDegMovement(minutes);

        double diff=minuteAngle>hourAngle?minuteAngle-hourAngle:hourAngle-minuteAngle;
        double diffComplement=360.0-diff;
        return Math.min(diff,diffComplement);
    }
}