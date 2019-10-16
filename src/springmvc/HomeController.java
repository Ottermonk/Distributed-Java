package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Inherits from @Component, a specialized component
// Will be picked up by component scanning
@Controller
public class HomeController {
    // Maps a path to a method name
    @RequestMapping("/")
    // You can name these methods whatever you want
    public String showIndex() {
        // Returns the name of the view to show
        // Remember that prefix and suffix will be added
        // Result will be "/WEB-INF/view/index.jsp"
        return "index";
    }
}