package com.rootls.repository;

import com.rootls.model.Menu;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: luowei
 * Date: 13-4-20
 * Time: 下午11:54
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MenuReposityTest {


    Logger logger = LoggerFactory.getLogger(MenuReposityTest.class);

    @Resource
    MenuRepository menuRepository;

    @Test
    public void testFindById() throws Exception {

        Menu menu = menuRepository.findById(1);
        logger.info("========= name:"+menu.getName());
        assertEquals("用户管理", menu.getName());
    }

    @Test
    public void testFindByName() throws Exception {
        List<Menu> menus = menuRepository.findByName("人员管理");
        assertEquals(2, menus.get(0).getId().intValue());
        assertEquals("manage/user/list", menus.get(0).getUrl());

    }

    @Test
    public void testCreateTimeBetween() throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp t1 = new Timestamp(df.parse("2012-03-03 12:00:00").getTime());
        Timestamp t2 = new Timestamp(df.parse("2012-03-04 12:00:00").getTime());

        List<Menu> menus = menuRepository.findByCreateTimeBetween(t1, t2);

        logger.info("======= menus size:"+menus.size());
        assertEquals(2, menus.size());
        for(Menu menu:menus){
            if(menu.getName().equals("菜单管理")){
                assertTrue(true);
            }
        }

    }


    @Test
    public void testModify() throws Exception {

        int addResult = menuRepository.add(1000,"美女管理");
        assertTrue(addResult!=0);
        logger.info("====== addResult:"+addResult);

        int updateResult = menuRepository.updateNameById("哇噻美眉",1000);
        assertTrue(updateResult!=0);
        assertEquals("哇噻美眉",menuRepository.findById(1000).getName());
        logger.info("====== updateResult:"+updateResult);

        int delResult = menuRepository.deleteById(1000);
        assertTrue(delResult!=0);
        assertNull(menuRepository.findById(1000));
        logger.info("====== delResult:"+delResult);
    }

    @After
    public void tearDown() throws Exception {
        menuRepository.deleteById(1000);

    }

}
