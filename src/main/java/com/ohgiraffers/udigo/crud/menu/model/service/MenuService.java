package com.ohgiraffers.udigo.crud.menu.model.service;

import com.ohgiraffers.udigo.crud.menu.model.dao.MenuMapper;
import com.ohgiraffers.udigo.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.udigo.crud.menu.model.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {


    private final MenuMapper menuMapper;

    @Autowired
    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    public List<CategoryDTO> findAllCategory() {
        return menuMapper.findAllCategory();
    }

}
