package ru.alishev.springcourse.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surnsme", required = false) String surname
    ) {

        //All parameters
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
        System.out.println("Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam("a") int a,
                                 @RequestParam("b") int b,
                                 @RequestParam("action") String action, Model model) {
        double x;
        switch (action) {
            case "multiplication":
               x = a * b;
                break;
            case "division":
                x = a / (double)b;
                break;
            case "addition":
                x = a + b;
                break;
            case "subtraction":
                x = a-b;
            default:
                x = 0;
                break;
        }


        model.addAttribute("calc",x);

        return "first/calculator";
    }
}

