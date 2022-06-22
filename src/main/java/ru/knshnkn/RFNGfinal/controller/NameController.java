package ru.knshnkn.RFNGfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.knshnkn.RFNGfinal.serivce.NameParams;
import ru.knshnkn.RFNGfinal.serivce.NameService;

@Controller
public class NameController {
    // Сколько имён хотим сгенерировать
    final int NAME_COUNTER = 5;

    // 
    @Autowired
    NameService nameService;

    // Возвращаем generator.html на HTTP GET-запрос по /generator
    @GetMapping("/generator")
    public String showGenerator(Model model) {

        // Создаём объект NameParams (параметры имени) и загружаем в модель.
        model.addAttribute("nameParams", new NameParams());
        return "generator";
    }

    // Получаем POST-запрос с параметрами для настройки объекта NameParams
    @PostMapping
    public String generate(@ModelAttribute("nameParams") NameParams nameParams, Model model) {
        model.addAttribute("nameParams", nameParams);

        if (nameParams.getGender() != null && nameParams.getRace() != null) {
            model.addAttribute("generatedNames", nameService.getRandomNames(nameParams, NAME_COUNTER));
        }
        else {
            model.addAttribute("generatedNames", "Ошибка! Не отмечены пол или раса!");
        }
        return "generator";
    }
}
