package ru.knshnkn.RFNGfinal.serivce;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Класс для генерации имён
@Component
public class NameService {
    // Нужные имена достаём файлов, которые хранятся в папке на хостине по URL
    private final String NAME_FOLDER = "ДОБАВИТЬ СЮДА ССЫЛКУ";

    // Достаём строки с данными, исходя из параметров и типа (имя или фамилия), и возвращаем случайную
    public String getRandomLineFromFile(NameParams nameParams, NameTypes nameType) {
        List<String> readLines = new ArrayList<>();

        String urlPath = NAME_FOLDER
                + nameParams.getRace()
                + "_"
                + nameType.getType()
                + "names.txt";

        try (Scanner s = new Scanner(new URL(urlPath).openStream())) {
            while (s.hasNextLine()) {
                readLines.add(s.nextLine());
            }
        }

        catch (IOException ex) {
            System.out.println(ex);
        }

        return readLines.get((int) (Math.random() * readLines.size()));
    }

    // Формируем нужное количество имён (counter) в форме списка, запрашивая случайные имя и фамилию
    public List<String> getRandomNames(NameParams nameParams, int counter) {
        List<String> resultNames = new ArrayList<>();
        for (int i = 0; i < counter; i++) {
            resultNames.add(getRandomLineFromFile(nameParams, NameTypes.FIRST_NAME) +
                    (nameParams.getGender().equals("female") ? "а " : " ") +
                    getRandomLineFromFile(nameParams, NameTypes.LAST_NAME));
        }

        return resultNames;
    }
}
