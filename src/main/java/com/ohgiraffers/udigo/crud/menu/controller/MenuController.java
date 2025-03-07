package com.ohgiraffers.udigo.crud.menu.controller;


import com.ohgiraffers.udigo.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.udigo.crud.menu.model.service.MenuService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private static final Logger logger = LogManager.getLogger(MenuController.class);

    private final MenuService menuService;
    private final MessageSource messageSource;

    @Autowired
    public MenuController(MenuService menuService, MessageSource messageSource) {

        this.menuService = menuService;
        this.messageSource = messageSource;

    }


    @GetMapping("/detail/{code}")
    public String findMenuDetail(@PathVariable("code") int code,
                                 Model model) {

        MenuDTO menu = menuService.findMenuByCode(code);

        model.addAttribute("menu", menu);

        return "menu/detail";
    }





}
