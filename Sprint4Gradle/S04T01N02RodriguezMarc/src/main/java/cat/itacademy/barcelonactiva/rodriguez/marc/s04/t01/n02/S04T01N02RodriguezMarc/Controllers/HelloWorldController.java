package cat.itacademy.barcelonactiva.rodriguez.marc.s04.t01.n02.S04T01N02RodriguezMarc.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    @ResponseBody
    public String saluda(@RequestParam(value = "name", defaultValue = "UNNKNOWN") String name) {
        return "Hello " + name + " you are executing a Maven project!";
    }

    @GetMapping({"/hello2", "/hello2/{name}"})
    public String saluda2(@PathVariable(required = false) String name) {
        if(name == null) name = "UNNKNOWN";

        return "Hello " + name + " you are executing a Maven project!";
    }


}
