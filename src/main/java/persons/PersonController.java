package persons;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Controller
public class PersonController {

    @RequestMapping("/persons")
    public String getPersons(Model model) {
        List<Person> persons = Arrays.asList(new Person("John", "Doe"), new Person("Jane", "Doe"));
        model.addAttribute("persons", persons);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        model.addAttribute("time", dtf.format(now));
        return "persons";
    }
}

