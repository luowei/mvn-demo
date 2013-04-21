package com.rootls.service.impl;

import com.rootls.model.Menu;
import com.rootls.repository.MenuRepository;
import com.rootls.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: luowei
 * Date: 13-4-21
 * Time: 下午9:34
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    MenuRepository menuRepository;

    @Override
    public Menu findById(Integer id) {

        return menuRepository.findById(id);
    }
}
