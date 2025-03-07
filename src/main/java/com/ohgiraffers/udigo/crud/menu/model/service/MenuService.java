package com.ohgiraffers.udigo.crud.menu.model.service;

import com.ohgiraffers.udigo.crud.menu.model.dao.MenuMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.ohgiraffers.udigo.crud.menu.model.dto.CategoryDTO;

import com.ohgiraffers.udigo.crud.menu.model.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;



@Service
public class MenuService {

    private final MenuMapper menuMapper;




    @Autowired
    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }


    @Transactional
    public void deleteMenu(int code) {
        menuMapper.deleteMenu(code);
    }
}


    @Transactional
    public void updateMenu(MenuDTO menu) {
        menuMapper.updateMenu(menu);
    }


    @Autowired
    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;

    @Autowired
    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findMenuList() {

        return menuMapper.findAllMenu();
    }

    public MenuDTO findMenuDetail(int code) {


        return menuMapper.findMenuByCode(code);
    }

    public List<CategoryDTO> findAllCategory() {


        return menuMapper.findAllCategory();
    }

 
    @Transactional
    public void registMenu(MenuDTO newMenu) {

        menuMapper.registMenu(newMenu);

    }

    @Transactional
    public void updateMenu(MenuDTO menu) {

feat/select-by


    public MenuDTO findMenuByCode(int code) {
        return menuMapper.findMenuByCode(code);
    }


}

        menuMapper.updateMenu(menu);
    }
}


