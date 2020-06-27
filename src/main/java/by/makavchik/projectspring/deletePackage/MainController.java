package by.makavchik.projectspring.deletePackage;


/*
@Slf4j
@Controller
@RequestMapping
 private class MainController {
    private static List<Person> persons = new ArrayList<>();
    static {
        persons.add(new Person("Olga", "Pertova","Molod.str", "Minsk",
                "287324","petr@gmail.com","11/12/1987","47594759"));
        persons.add(new Person("Nikolai", "Ivanov","Suhar str","Minsk",
                "287324","nik@gmail.com","05/05/1986","9999999"));
    }

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @GetMapping(value = {"/", "/index"})
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        model.addAttribute("message", message);
        log.info ("index was called");
        return modelAndView;
    }

    @GetMapping(value = {"/PersonList"})
    public ModelAndView persomList (Model model){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("PersonList");
        model.addAttribute("persons",persons);
        log.info ("/personList was called");
        return modelAndView;
    }

    @GetMapping (value = {"/addPerson"})
    public ModelAndView add (Model model){
        ModelAndView modelAndView=new ModelAndView("addPerson");
        PersonForm personForm= new PersonForm();
        model.addAttribute("personForm",personForm);
        log.info ("/addPerson was called");
        return modelAndView;
    }

    @PostMapping(value = {"/addPerson"})
    public ModelAndView savePerson(Model model,
                                   @Valid @ModelAttribute("personForm") PersonForm personForm,
                                   Errors errors)
    {
        ModelAndView modelAndView = new ModelAndView();
        if (errors.hasErrors()) {
            modelAndView.setViewName("addPerson");

        }
        else {
            modelAndView.setViewName("PersonList");
        String firstName = personForm.getFirstName();
        String lastName = personForm.getLastName();
        String street = personForm.getStreet();
        String city = personForm.getCity();
        String zip = personForm.getZip();
        String email = personForm.getEmail();
        String birthday = personForm.getBirthday();
        Person newPerson = new Person(firstName, lastName, street, city, zip, email, birthday,
                personForm.getPhone());
        persons.add(newPerson);
        model.addAttribute("persons", persons);
        log.info("/addPerson - POST was called");
        return modelAndView;
        }
        return modelAndView;
    }
}*/
