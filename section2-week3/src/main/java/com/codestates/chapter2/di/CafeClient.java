package com.codestates.chapter2.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import java.util.*;

public class CafeClient {
    public static void main(String[] args) {
        GenericApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        MenuController controller = context.getBean(MenuController.class);

        List<Menu> menuList = controller.getMenus();
        controller.getMenus();

    }



    public class MenuController {
        private MenuService menuService;

        @Autowired
        public MenuController(MenuService menuService) {
            this.menuService = menuService;
        }

        public List<Menu> getMenus() {
            return menuService.getMenuList();
        }
    }

    public interface MenuService {
        List<Menu> getMenuList();
    }

    public class MenuServiceStub implements MenuService {
        @Override
        public List<Menu> getMenuList() {
            return List.of(
                    new Menu(1, "아메리카노", 2500),
                    new Menu(2, "카라멜 마끼아또", 4500),
                    new Menu(3, "바닐라 라떼", 4500)
            );
        }
    }

    @Configuration
    @ComponentScan(basePackageClasses = CafeClient.class)
    public  class Config {
        @Bean
        public MenuService getMenuService() {
            return new MenuServiceStub();
        }

        @Bean
        public MenuController getMenuController(MenuService menuService) {
            return new MenuController(menuService);
        }
    }
}

