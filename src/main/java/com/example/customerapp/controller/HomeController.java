package com.example.customerapp.controller;

import com.example.customerapp.entity.Customer;
import com.example.customerapp.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final CustomerService service;

    public HomeController(CustomerService service) {
        this.service = service;
    }

    // One page: shows form + table
    @GetMapping("/")
    public String index(@RequestParam(value = "id", required = false) Long id, Model model) {
        Customer formCustomer = (id == null) ? new Customer() : service.findById(id);

        model.addAttribute("customerForm", formCustomer);
        model.addAttribute("customers", service.findAll());
        model.addAttribute("isEdit", id != null);

        return "index";
    }

    // Add or Update
    @PostMapping("/save")
    public String save(@ModelAttribute("customerForm") Customer customer) {
        service.save(customer);
        return "redirect:/";
    }

    // Edit loads customer into same page
    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id) {
        return "redirect:/?id=" + id;
    }

    // Delete
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
