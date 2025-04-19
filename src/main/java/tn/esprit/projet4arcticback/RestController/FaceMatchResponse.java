package tn.esprit.projet4arcticback.RestController;

public class FaceMatchResponse {
    private boolean match;
    private double distance;

    // Getters and setters
    public boolean isMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
