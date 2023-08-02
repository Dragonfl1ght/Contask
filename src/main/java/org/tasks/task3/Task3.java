package org.tasks.task3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Task3 {
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            File[] files = new File[args.length];
            for (int i = 0; i < args.length; i++) {
                files[i] = new File(args[i]);
                assert files[i].exists();
            }
            String test_json = new String(Files.readAllBytes(Path.of(files[0].getPath())));
            String value_json = new String(Files.readAllBytes(Path.of(files[1].getPath())));
            JsonHashParser js = new JsonHashParser(test_json, value_json);
            js.setValues();
            Path path
                    = Paths.get("report.json");
            Files.writeString(path, js.getJsonResponse(),
                    StandardCharsets.UTF_8);
        } else {
            System.out.println("Аргументы заданы неверно");
        }
    }
}