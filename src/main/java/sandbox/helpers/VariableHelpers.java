package sandbox.helpers;

import java.util.Scanner;

public class VariableHelpers {
    protected static String readString() {
        try (var scanner = new Scanner(System.in)) {
            return scanner.next();
        }
    }

    protected static int readInt() {
        try (var scanner = new Scanner(System.in)) {
            return scanner.nextInt();
        }
    }
}