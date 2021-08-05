package versioncomparator.formatchecker;

import java.util.Scanner;

public class FormatChecker {

    private Scanner scanner;
    private String userInput;

    public FormatChecker(Scanner scanner) {
        this.scanner = scanner;
    }

    public String executeCheck() {
        userInput = scanner.nextLine();
        boolean isFormatValid = checkFormat(userInput);

        while (!isFormatValid) {
            isFormatValid = repeatCheck();
        }

        return userInput;
    }

    public boolean checkFormat(String version) {
        return version.matches("(\\d+\\.\\d+|\\d+\\.\\d+\\.\\d+)");
    }

    public boolean repeatCheck() {
        System.out.println("Formato errato. Inserire un formato valido (Es: 1.0.1 o 1.0)");
        userInput = scanner.nextLine();
        return checkFormat(userInput);
    }
}
