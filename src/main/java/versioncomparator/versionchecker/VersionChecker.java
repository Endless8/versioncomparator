package versioncomparator.versionchecker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VersionChecker {
    private String s1;
    private String s2;
    private int result;

    public VersionChecker(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public void checkVersions() {
        List<Integer> s1Numbers = Arrays.stream(s1.split("\\."))
                .map(string ->
                        Integer.parseInt(string)).collect(Collectors.toList()
                );
        List<Integer> s2Numbers = Arrays.stream(s2.split("\\."))
                .map(string ->
                        Integer.parseInt(string)).collect(Collectors.toList()
                );

        int s1NumbersSize = s1Numbers.size();
        int s2NumbersSize = s2Numbers.size();
        int iterations = s1NumbersSize > s2NumbersSize ? s1NumbersSize : s2NumbersSize;

        for (int i = 0; i < iterations; i++) {
            int s1CurrentNumber = i < s1NumbersSize ? s1Numbers.get(i) : 0;
            int s2CurrentNumber = i < s2NumbersSize ? s2Numbers.get(i) : 0;

            if (s1CurrentNumber < s2CurrentNumber) {
                result = 1;
                break;
            } else if (s1CurrentNumber > s2CurrentNumber) {
                result = -1;
                break;
            } else {
                continue;
            }
        }
    }

    public int printResult() {
        System.out.println("Il risultato della comparazione è: " + result);
        return result;
    }
}
