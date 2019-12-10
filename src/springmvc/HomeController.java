package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    @RequestMapping("/errors")
    public String showErrorPage(HttpServletRequest request,
                                Model theModel) {
        int requestCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        String errorMsg;

        switch(requestCode) {
            case 400:
                errorMsg = "HTTP Error 400: Bad request";
                break;
            case 404:
                errorMsg = "HTTP Error 404: Resource not found";
                break;
            case 500:
                errorMsg = "HTTP Error 500: Internal server error";
                break;
            default:
                errorMsg = "Whoa! Something went really wrong";
        }

        theModel.addAttribute("errorMessage", errorMsg);

        return "/errors";
    }
}