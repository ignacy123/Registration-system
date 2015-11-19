package com.github.ignacy123.projectvocabulary;

import java.io.*;

/**
 * Created by ignacy on 12.11.15.
 */
public class Application {
    private final InputStream inputStream;
    private final PrintStream printStream;

    public Application(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;

        this.printStream = printStream;
    }

    public void run() {
        printStream.println("1. Zarejestruj");
        printStream.println("0. Koniec");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String line = reader.readLine();
            if (line.equals("0")) {
                printStream.println("Do zobaczenia!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Application application = new Application(System.in, System.out);
        application.run();
    }
}
