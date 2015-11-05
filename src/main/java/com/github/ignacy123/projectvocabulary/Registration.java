package com.github.ignacy123.projectvocabulary;

import java.io.*;

/**
 * Created by ignacy on 04.11.15.
 */
public class Registration {


    public static void main(String[] args) throws IOException {
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
            File userData = File.createTempFile(name + "'s data", ".txt");
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
}
