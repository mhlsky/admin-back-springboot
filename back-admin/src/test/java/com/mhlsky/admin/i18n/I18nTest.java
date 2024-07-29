package com.mhlsky.admin.i18n;

import cn.hutool.extra.spring.SpringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

/**
 * :
 *
 * @author mhlsky孟
 * @date 2024/7/29 下午2:41
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class I18nTest {
    @Autowired
    private MessageSource messageSource;
    @Test
    public void i18nTest() {
        // MessageSource messageSource = SpringUtil.getBean(MessageSource.class);
        String str = messageSource.getMessage("SUCCESS", null, LocaleContextHolder.getLocale());
        System.out.println(str);
        String str1 = messageSource.getMessage("SUCCESS", null, Locale.US);
        System.out.println(str1);

    }
}
