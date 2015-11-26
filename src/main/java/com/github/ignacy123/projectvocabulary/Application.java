package com.github.ignacy123.projectvocabulary;

import java.io.*;

/**
 * Created by ignacy on 12.11.15.
 */
public class Application {


    public String run() {


        return "1. Zarejestruj\n0. Koniec\n";
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
