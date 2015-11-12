package com.github.ignacy123.projectvocabulary;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by ignacy on 11.11.15.
 */
public class Users {

    private final File userData;

    Users() {
        String homePath = System.getProperty("vocabulary.home");
        Objects.requireNonNull(homePath);
        File home = new File(homePath);
        if (!home.exists() || !home.isDirectory()) {
            throw new RuntimeException("Wrong home dir.");
        }
        userData = new File(home, "userData.txt");

    }

    private ArrayList<User> users;

    {
        users = new ArrayList<User>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void createUser(String login, String password, String email) {
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        user.setLogin(login);
        addUser(user);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(userData)));
            try {
                writer.write("WriterTest\n");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            PrintWriter print = new PrintWriter(writer);
            print.println("PrintWritertest");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {

            }
        }


    }

}
