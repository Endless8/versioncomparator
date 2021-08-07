package versioncomparator.checker;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FormatAndVersionChecker {
    private String firstVersion;
    private String secondVersion;
    private Scanner scanner;

    public FormatAndVersionChecker() {
        scanner = new Scanner(System.in);
    }

    public String checkVersionFormat() {
        String version = scanner.nextLine();
        boolean isFormatValid = formatCheck(version);

        while(!isFormatValid) {
            System.out.println("Formato errato. Inserire un formato valido (Es: 1.0.1 o 1.0)");
            version = scanner.nextLine();
            isFormatValid = formatCheck(version);
        }

        return version;
    }

    public boolean formatCheck(String version) {
        return version.matches("(\\d+\\.\\d+|\\d+\\.\\d+\\.\\d+)");
    }

    public int checkVersions() {
        int result = 0;
        List<Integer> s1Numbers = Arrays.stream(firstVersion.split("\\."))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> s2Numbers = Arrays.stream(secondVersion.split("\\."))
                .map(Integer::parseInt).collect(Collectors.toList());

        int s1NumbersSize = s1Numbers.size();
        int s2NumbersSize = s2Numbers.size();
        int iterations = Math.max(s1NumbersSize, s2NumbersSize);

        for (int i = 0; i < iterations; i++) {
            int s1CurrentNumber = i < s1NumbersSize ? s1Numbers.get(i) : 0;
            int s2CurrentNumber = i < s2NumbersSize ? s2Numbers.get(i) : 0;

            if (s1CurrentNumber < s2CurrentNumber) {
                return 1;
            } else if (s1CurrentNumber > s2CurrentNumber) {
                return -1;
            }
        }

        return result;
    }

    public String terminateOrCompareAgain() {
        System.out.println("\nPer eseguire un'altra comparazione inserire 'S' o premere invio per terminare l'applicazione.");
        return scanner.nextLine();
    }

    public void setFirstVersion(String firstVersion) {
        this.firstVersion = firstVersion;
    }

    public void setSecondVersion(String secondVersion) {
        this.secondVersion = secondVersion;
    }
}
