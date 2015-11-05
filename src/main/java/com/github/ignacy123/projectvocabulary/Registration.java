package com.github.ignacy123.projectvocabulary;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by ignacy on 04.11.15.
 */
public class Registration {


    public static void main(String[] args) throws IOException {
        String homePath = System.getProperty("vocabulary.home");
        Objects.requireNonNull(homePath);
        File home = new File(homePath);
        if (!home.exists() || !home.isDirectory()) {
            throw new RuntimeException("Wrong home dir.");
        }
        File userData = getOrCreateUserData(home);
        String name = "";
        String password;
        String confirm;
        String email;
        int go = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Name:");
        name = reader.readLine();
        System.out.println("Password");
        password = reader.readLine();
        System.out.println("Confirm password");
        confirm = reader.readLine();
        if (password.equals(confirm)) {
            System.out.println("Email");
            email = reader.readLine();
            reader.close();
            User user = new User();
            user.setLogin(name);
            user.setPassword(password);
            user.setEmail(email);
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(userData));
            outputStream.writeObject(user);
            outputStream.flush();
            outputStream.close();
            System.out.println("saved user data to: " + userData.getAbsolutePath());
            go = 1;
        }
        if (go != 1) {
            System.out.println("Wrong password confirmation. Try again");
        }

    }

    private static File getOrCreateUserData(File home) throws IOException {
        File userData = new File(home, "userData.obj");
        if (!userData.exists()) {
            userData.createNewFile();
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(userData));
            outputStream.writeObject(new ArrayList<User>());
            outputStream.flush();
            outputStream.close();
        }
        return userData;
    }
}
