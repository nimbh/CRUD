package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.dao.PersonDAO;
import spring.models.Person;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final PersonDAO personDAO;

    @Autowired
    public AdminController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String admin_page(Model model, @ModelAttribute("person")Person person){
        model.addAttribute("people", personDAO.index());
        return "admin/admin_page";
    }

    @PatchMapping("/add")
    public String add_admin(@ModelAttribute("person")Person person){
        System.out.println(person.getId());

        return "redirect:/people";
    }
}
