package com.rootls.service;

import com.rootls.model.Menu;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luowei
 * Date: 13-4-21
 * Time: 下午9:39
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MenuServiceTest {

    Logger logger = LoggerFactory.getLogger(MenuServiceTest.class);

    @Resource
    MenuService menuService;

    @Test
    public void testFindById() throws Exception {

        Menu menu = menuService.findById(2);

        assertEquals("人员管理", menu.getName());
        logger.info("========= name:"+menu.getName());

    }
}
