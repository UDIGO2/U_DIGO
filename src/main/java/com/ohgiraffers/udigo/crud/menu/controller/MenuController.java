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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


}
