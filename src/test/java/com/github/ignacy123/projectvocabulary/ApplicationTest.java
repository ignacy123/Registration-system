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
    private ByteArrayOutputStream applicationOutput;
    private PrintStream applicationInput;
    private Application application;

    @Before
    public void before() throws IOException {
        applicationOutput = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(applicationOutput);
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
        applicationInput = new PrintStream(pipedOutputStream);
        application = new Application(pipedInputStream, printStream);
    }

    @Test
    public void printsMenu() throws IOException {


        applicationInput.println("test");
        application.run();

        String output = applicationOutput.toString();
        assertThat(output, equalTo("1. Zarejestruj\n0. Koniec\n"));
    }

    @Test
    public void closesProperly() throws IOException {

        applicationInput.println("0");
        application.run();

        String output = applicationOutput.toString();
        assertThat(output, equalTo("1. Zarejestruj\n0. Koniec\nDo zobaczenia!\n"));
    }
}
