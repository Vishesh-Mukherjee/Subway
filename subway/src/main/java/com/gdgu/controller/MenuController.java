package com.gdgu.controller;

import javax.validation.Valid;

import com.gdgu.entity.Order;
import com.gdgu.entity.OrderForm;
import com.gdgu.repository.MenuSandwichRepository;
import com.gdgu.repository.OrderFormRepository;
import com.gdgu.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {
    
    private MenuSandwichRepository menuSandwichRepository;
    private OrderFormRepository orderFormRepository;
    private OrderRepository orderRepository;
    private Order order;

    @Autowired
    public MenuController(MenuSandwichRepository menuSandwichRepository, OrderFormRepository orderFormRepository, OrderRepository orderRepository) {
        this.menuSandwichRepository = menuSandwichRepository;
        this.orderFormRepository = orderFormRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public String getMenu(Model model) {
        model.addAttribute("menuSandwichList", menuSandwichRepository.findAll());
        model.addAttribute("order", new Order());
        return "menu";
    }

    @PostMapping
    public String processMenu(Order order) {
        this.order = order;
        return "redirect:/menu/order";
    }

    @GetMapping("/order") 
    public String orderForm(Model model) {
        model.addAttribute("orderForm", new OrderForm());
        return "orderForm";
    }

    @PostMapping("/order")
    public String processOrderForm(@Valid OrderForm orderForm, Errors errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        orderForm.setOrder(order);
        orderRepository.save(order);
        orderFormRepository.save(orderForm);    
        return "/dashboard";
    }

}