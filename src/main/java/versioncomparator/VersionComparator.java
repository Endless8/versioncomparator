package versioncomparator;

import versioncomparator.checker.FormatAndVersionChecker;

public class VersionComparator {

    private int result;

    public void start() {
        String terminateApplication = "S";

        while (terminateApplication.toUpperCase().equals("S")) {
            FormatAndVersionChecker formatAndVersionChecker = new FormatAndVersionChecker();
            System.out.println("Inserire la prima versione da controllare:");
            String firstVersion = formatAndVersionChecker.checkVersionFormat();
            formatAndVersionChecker.setFirstVersion(firstVersion);
            System.out.println("Inserire la seconda versione da controllare:");
            String secondVersion = formatAndVersionChecker.checkVersionFormat();
            formatAndVersionChecker.setSecondVersion(secondVersion);
            formatAndVersionChecker.checkVersions();
            result = formatAndVersionChecker.checkVersions();
            System.out.println("Il risultato della comparazione è: " + result);
            terminateApplication = formatAndVersionChecker.terminateOrCompareAgain();
        }
    }

    public int getResult() {
        return result;
    }
}
