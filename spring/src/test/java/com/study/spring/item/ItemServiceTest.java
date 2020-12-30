package com.study.spring.item;

import com.study.spring.config.AppConfig;
import com.study.spring.item.service.ItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

public class ItemServiceTest {

    private final ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    private ItemService itemService = ac.getBean(ItemService.class);

    @Test
    @DisplayName("아이템 저장 및 찾기 테스트")
    void saveItemAndFindTest()
    {
        Item item = new Item(1L,"itemA",3000);
        assertDoesNotThrow(() -> itemService.save(item));
        assertEquals(item,itemService.findById(item.getId()));
    }
}
