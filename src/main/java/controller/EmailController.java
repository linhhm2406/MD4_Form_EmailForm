package controller;

import model.EmailConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {

    @GetMapping("/form")
    public String showForm(Model model){
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");

        List<Integer> sizeList = new ArrayList<>();
        sizeList.add(5);
        sizeList.add(10);
        sizeList.add(15);
        sizeList.add(25);
        sizeList.add(50);
        sizeList.add(100);

        model.addAttribute("emailConfig",new EmailConfig());
        model.addAttribute("languageList",languageList);
        model.addAttribute("sizeList",sizeList);

        return "setting";
    }

    @PostMapping("/saveSetting")
    public ModelAndView showSettingInfo(@ModelAttribute EmailConfig emailConfig){
        return new ModelAndView("setting-info","emailConfig",emailConfig);
    }
}
