package com.ohgiraffers.udigo.crud.menu.controller;




import com.ohgiraffers.udigo.crud.menu.model.dto.CategoryDTO;

import com.ohgiraffers.udigo.crud.menu.model.dto.MenuDTO;

import com.ohgiraffers.udigo.crud.menu.model.service.MenuService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;



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

    @PostMapping("/delete/{code}")
    public String deleteMenu(@PathVariable("code") int code,
                             RedirectAttributes rAttr) {

        menuService.deleteMenu(code);

        rAttr.addFlashAttribute("successMessage", "메뉴가 성공적으로 삭제되었습니다.");


    private static final Logger logger = LogManager.getLogger(MenuController.class);

    private final MenuService menuService;
    private final MessageSource messageSource;

    @Autowired
    public MenuController(MenuService menuService, MessageSource messageSource) {

        this.menuService = menuService;
        this.messageSource = messageSource;

    }

    @GetMapping("/edit/{code}")
    public String showEditMenuForm(@PathVariable("code") int code,
                                   Model model) {

        MenuDTO menu = menuService.findMenuDetail(code);

        model.addAttribute("menu", menu);

        return "menu/edit";
    }

    @PostMapping("/update")
    public String updateMenu(MenuDTO menu, RedirectAttributes rAttr) {

        menuService.updateMenu(menu);

        rAttr.addFlashAttribute("successMessage", "메뉴가 성공적으로 수정되었습니다.");

        return "redirect:/menu/detail/" + menu.getCode();
    }

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



    private final MenuService menuService;
    private final MessageSource messageSource;

    private static final Logger logger = LogManager.getLogger(MenuController.class);

    @Autowired
    public MenuController(MenuService menuService, MessageSource messageSource) {
        this.menuService = menuService;
        this.messageSource = messageSource;
    }


    @GetMapping("/regist")
    public void registMenu() {}

    @GetMapping(value = "/category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {

        System.out.println("JavaScript 내장 함수인 fetch 비동기 요청 감지!");

        return menuService.findAllCategory();
    }

    @PostMapping("/regist")
    public String registMenu(MenuDTO newMenu,
                             RedirectAttributes rAttr,
                             Locale locale) {

        menuService.registMenu(newMenu);

        // Log4j로 로깅을 할 때, 이렇게 작성하면 된다~ 정도로만 익혀두자.
        logger.info("Locale : {}", locale);


//        rAttr.addFlashAttribute("successMessage", "신규 메뉴 등록에 성공하셨습니다.");
        rAttr.addFlashAttribute("successMessage", messageSource.getMessage("registMenu", null, locale));



        return "redirect:/menu/list";
    }

}