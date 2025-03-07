package com.ohgiraffers.udigo.crud.menu.controller;

import com.ohgiraffers.udigo.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.udigo.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.udigo.crud.menu.model.service.MenuService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/menu")
public class MenuController {

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