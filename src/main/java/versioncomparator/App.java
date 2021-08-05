package versioncomparator;

import versioncomparator.formatchecker.FormatChecker;
import versioncomparator.versionchecker.VersionChecker;

import java.util.Scanner;

public class App {

    private static int result = 0;

    public static void main(String[] args) {
        String terminateApplication = "S";
        int result = 0;

        while (terminateApplication.toUpperCase().equals("S")) {
            Scanner scanner = new Scanner(System.in);
            FormatChecker formatChecker = new FormatChecker(scanner);
            System.out.println("Inserire la prima versione da controllare:");
            String firstUserInput = formatChecker.executeCheck();
            System.out.println("Inserire la seconda versione da controllare:");
            String secondUserInput = formatChecker.executeCheck();
            VersionChecker application = new VersionChecker(firstUserInput, secondUserInput);
            application.checkVersions();
            App.result = application.printResult();
            System.out.println("\nPer eseguire un'altra comparazione inserire 'S' o premere invio per terminare l'applicazione.");
            terminateApplication = scanner.nextLine();
        }
    }

    public static int mainTest() {
        main(new String[0]);
        return App.result;
    }
}
