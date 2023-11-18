package com.example.sport_project;

import java.io.File;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        HelloApplication.main(args);

        String executablePath = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        // Переходим к родительской директории (бин-директории)
        String binDirectory = new File(executablePath).getParent();

        // Путь к директории data относительно исполняемого файла
        String relativePath = "database";
        String dataDirectory = Paths.get(binDirectory, relativePath).toString();

        // Устанавливаем текущую директорию
        System.setProperty("user.dir", dataDirectory);

    }
}
