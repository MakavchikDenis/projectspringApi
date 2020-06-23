package by.makavchik.projectspring.controller;


import by.makavchik.projectspring.form.PersonForm;
import by.makavchik.projectspring.model.Person;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class MainController {
    private static List<Person> persons = new ArrayList<Person>();
    static {
        persons.add(new Person("Olga", "Pertova"));
        persons.add(new Person("Nikolai", "Ivanov"));
    }

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        model.addAttribute("message", message);
        return modelAndView;
    }

    @RequestMapping(value = {"/PersonList"},method = RequestMethod.GET)
    public ModelAndView persomList (Model model){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("PersonList");
        model.addAttribute("persons",persons);
        return modelAndView;
    }

    @RequestMapping (value = {"/addPerson"},method = RequestMethod.GET)
    public ModelAndView add (Model model){
        ModelAndView modelAndView=new ModelAndView("addPerson");
        PersonForm personForm= new PersonForm();
        model.addAttribute("personForm",personForm);
        return modelAndView;
    }

    @RequestMapping (value = {"/addPerson"}, method = RequestMethod.POST)
    public ModelAndView exc (Model model, @ModelAttribute ("personForm") PersonForm personForm){
        ModelAndView modelAndView=new ModelAndView();
        String firstname=personForm.getFirstName();
        String lastname = personForm.getLastName();
        if(firstname != null && firstname.length() > 0
                && lastname != null && lastname.length() > 0){
            persons.add(new Person(firstname,lastname));
            modelAndView.setViewName("PersonList");
            model.addAttribute("persons",persons);
            return modelAndView;
        }
        else {
            model.addAttribute("errorMessage",errorMessage);
            modelAndView.setViewName("addPerson");
            return modelAndView;
        }
    }
}
