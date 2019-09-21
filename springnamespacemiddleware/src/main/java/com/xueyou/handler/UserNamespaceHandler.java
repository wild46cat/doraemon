package com.xueyou.handler;

import com.xueyou.parser.UserDefinationParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class UserNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("self-user", new UserDefinationParser());
    }
}
