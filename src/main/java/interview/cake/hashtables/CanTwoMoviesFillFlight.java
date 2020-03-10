package interview.cake.hashtables;

import java.util.HashMap;
import java.util.Map;

public class CanTwoMoviesFillFlight {
    public static boolean canTwoMoviesFillFlight(int[] movieLengths,
                                                 int flightLength) {

        Map<Integer, Integer> movieLengthMap = new HashMap<>();
        for (int movieLength : movieLengths) {
            int currentCount = movieLengthMap.getOrDefault(movieLength, 0);
            movieLengthMap.put(movieLength, currentCount + 1);
        }

        for (int movieLength : movieLengthMap.keySet()) {
            int currentCount = movieLengthMap.get(movieLength);

            movieLengthMap.put(movieLength, currentCount - 1);

            int timeLeftAfterMovie = flightLength - movieLength;

            if (movieLengthMap.getOrDefault(timeLeftAfterMovie, 0) > 0) {
                return true;
            }

            movieLengthMap.put(movieLength, currentCount + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(canTwoMoviesFillFlight(new int[]{2, 4}, 1)); // false
        System.out.println(canTwoMoviesFillFlight(new int[]{2, 4}, 6)); // true
        System.out.println(canTwoMoviesFillFlight(new int[]{3, 8}, 6)); // false
        System.out.println(canTwoMoviesFillFlight(new int[]{3, 8, 3}, 6)); // true
        System.out.println(canTwoMoviesFillFlight(new int[]{1, 2, 3, 4, 5, 6}, 7)); // true
        System.out.println(canTwoMoviesFillFlight(new int[]{4, 3, 2}, 5)); // true
        System.out.println(canTwoMoviesFillFlight(new int[]{6}, 6)); // false
        System.out.println(canTwoMoviesFillFlight(new int[]{}, 6)); // false
    }
}
