package by.makavchik.projectspring.controller;

import by.makavchik.projectspring.dto.NewPersonDto;
import by.makavchik.projectspring.entity.Person;
import by.makavchik.projectspring.exception.NoSuchEntityException;
import by.makavchik.projectspring.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping
public class PersonControoler {
    private final PersonService personService;

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @Autowired
    public PersonControoler(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping(value = {"/", "/index"})
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView("index");
        model.addAttribute("message", message);
        log.info("index was called");
        return modelAndView;
    }

    @GetMapping(value = {"/PersonList"})
    public ModelAndView personList(Model model) {
        List<Person> persons = personService.getAllPerson();
        ModelAndView modelAndView = new ModelAndView("/PersonList");
        model.addAttribute("persons", persons);
        log.info("personList was called");
        return modelAndView;

    }

    @GetMapping(value = {"/addPerson"})
    public ModelAndView showAddPersonPage(Model model) {
        NewPersonDto personForm = new NewPersonDto();
        ModelAndView modelAndView = new ModelAndView("addPerson");
        model.addAttribute("personForm", personForm);
        return modelAndView;
    }

    @PostMapping(value = {"/addPerson"})
    public ModelAndView savePerson(Model model,
                                   @Valid @ModelAttribute("personForm")
                                           NewPersonDto newPersonDto,
                                   Errors errors) {

        ModelAndView modelAndView = new ModelAndView();
        if (errors.hasErrors()) {
            modelAndView.setViewName("addPerson");
        } else {
            modelAndView.setViewName("PersonList");
            personService.addNewPerson(new Person(newPersonDto.getPersonId(),
                    newPersonDto.getFirstName(), newPersonDto.getLastName(),
                    newPersonDto.getStreet(), newPersonDto.getCity(), newPersonDto.getZip(),
                    newPersonDto.getEmail(), newPersonDto.getBirthday(), newPersonDto.getPhone()));
            model.addAttribute("persons", personService.getAllPerson());
            log.info("/addPerson - POST was called");
        }
        return modelAndView;
    }

    @GetMapping(value = {"/editPerson/{id}"})
    public ModelAndView editPage(@PathVariable("id") Long id) throws NoSuchEntityException {
        Person person = personService.getById(id).orElseThrow(() -> new
                NoSuchEntityException("Person not found"));
        ModelAndView modelAndView = new ModelAndView("editPerson", "person", person);
        return modelAndView;
    }

    @PostMapping(value = {"/editPerson"})
    public ModelAndView editPerson(@Valid @ModelAttribute("person") Person person,
                                   Errors errors) {
        personService.editPerson(person);
        ModelAndView modelAndView = new ModelAndView("redirect:/index");
        return modelAndView;
    }

}
