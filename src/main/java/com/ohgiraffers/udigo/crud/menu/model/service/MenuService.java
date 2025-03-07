package com.ohgiraffers.udigo.crud.menu.model.service;

import com.ohgiraffers.udigo.crud.menu.model.dao.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


