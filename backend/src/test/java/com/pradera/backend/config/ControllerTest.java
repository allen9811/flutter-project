package com.pradera.backend.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith(SpringExtension.class)
@WebMvcTest(excludeAutoConfiguration = SecurityAutoConfiguration.class)
public @interface ControllerTest {

    @AliasFor(annotation = WebMvcTest.class, attribute = "value")
    Class<?> value();

}
