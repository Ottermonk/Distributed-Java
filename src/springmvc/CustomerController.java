package springmvc;
import hibernate.entity.Customer;
import hibernate.services.CustomerService;
import hibernate.entity.Product;
import hibernate.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService CustomerService;

    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String theSearchTerm,
                         Model theModel) {
        List<Customer> list = CustomerService.getCustomerByName(theSearchTerm);

        theModel.addAttribute("customer", list);

        return "list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("Customer_ID") int theId) {
        CustomerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

    @RequestMapping("/showUpdateCustomerForm")
    public String showUpdateDonutForm(@RequestParam("Customer_ID") int theId,
                                      Model theModel) {
        Customer theCustomer = CustomerService.getCustomer(theId);

        theModel.addAttribute("aCustomer", theCustomer);

        return "form";
    }

    @RequestMapping("/list")
    public String listCustomer(Model theModel) {
        List<Customer> customerList = CustomerService.getCustomer();

        theModel.addAttribute("customer", customerList);

        return "list";
    }

    @GetMapping("/showAddCustomerForm")
    public String showAddCustomerForm(Model theModel) {
        Customer newCustomer = new Customer();

        theModel.addAttribute("aCustomer", newCustomer);

        return "form";
    }

    @PostMapping("/save")
    public String saveDonut(@Valid @ModelAttribute(name = "aCustomer") Customer theCustomer,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "form";
        }


        CustomerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, ste);
    }




}