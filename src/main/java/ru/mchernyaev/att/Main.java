package ru.mchernyaev.att;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        var controller = ApplicationController.getDefault();
        try {
            controller.run(args);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
