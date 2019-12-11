package com.xueyou.parser;

import com.xueyou.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.w3c.dom.Element;

public class UserDefinationParser extends AbstractSimpleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        int userId = Integer.valueOf(element.getAttribute("userId"), 0);
        String name = element.getAttribute("name");
        builder.addPropertyValue("userId", userId);
        builder.addPropertyValue("name", name);
    }
}
