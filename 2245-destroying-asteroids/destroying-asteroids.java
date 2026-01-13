import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long currentMass = mass;

        for (int i = 0; i < asteroids.length; i++) {
            if (currentMass >= asteroids[i]) {
                currentMass += asteroids[i];
            } else {
                return false;
            }
        }
        return true;
    }}
