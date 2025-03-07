package com.ohgiraffers.udigo.crud.menu.model.service;

import com.ohgiraffers.udigo.crud.menu.model.dao.MenuMapper;
import com.ohgiraffers.udigo.crud.menu.model.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private final MenuMapper menuMapper;

    @Autowired
    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }




    public MenuDTO findMenuByCode(int code) {
        return menuMapper.findMenuByCode(code);
    }

}
