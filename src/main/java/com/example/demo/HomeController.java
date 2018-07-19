package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CompanyRepository companyRepository;


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("customers",customerRepository.findAll());
        return "index";
    }


    //search by lastname
    @GetMapping("/searchLastName")
    public String getSearch() {
        return "searchform";
    }

    //search by city
    @GetMapping("/searchbycity")
    public String getSearchbycity() {
        return "searchcity";
    }

 // adding new customers
//    @GetMapping("/add")
//    public String customerForm(Model model) {
//    return "searchform";
//    }

    //processing all customers
    @GetMapping("/showAllCustomer")
    public String allCustomer(@Valid Customers customers, BindingResult result, HttpServletRequest request, Model model) {

        if (result.hasErrors()) {
            return "searchform";
        }

        String search = request.getParameter("allCustomer");
        model.addAttribute("listResult", customerRepository.findAll());
        return "allCustomer";
    }


    //search by last name ko yay dar
    @PostMapping("/process")
    public String showSearchResults(@Valid Customers customers, BindingResult result, HttpServletRequest request, Model model) {

     if (result.hasErrors()) {
     return "searchform";
 }

    String search = request.getParameter("lastname");
    model.addAttribute("listResult", customerRepository.findByLastnameIgnoreCase(search));
     return "searchform";
    }


    @PostMapping("/processcity")
    public String showCityResult(@Valid Customers customers, BindingResult result, HttpServletRequest request, Model model) {

        if (result.hasErrors()) {
            return "searchcity";
        }
//city ka html city nae tu ya mal
        String search = request.getParameter("city");
        model.addAttribute("listResult", customerRepository.findByCityIgnoreCase(search));
        return "searchcity";
    }
    @GetMapping("/searchEMPcount")
    public String showEMPcountResult(@Valid Customers customers, BindingResult result, HttpServletRequest request, Model model) {

        if (result.hasErrors()) {
            return "searchcount";
        }
//city ka html city nae tu ya mal
        String search = request.getParameter("city");
        model.addAttribute("listResult", companyRepository.findByEmpeeCount());
        return "searchcount";
    }


}
