package com.github.ignacy123.projectvocabulary;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ignacy on 12.11.15.
 */
public class ApplicationTest {


    @Test
    public void printsMenu() throws IOException {
        Application application = new Application();
        String output = application.run();
        assertThat(output, is("1. Zarejestruj\n0. Koniec\n"));

    }
}
