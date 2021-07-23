package com.ninglz.bamboo.commoon.knife.annotation;

import com.ninglz.bamboo.commoon.knife.config.KnifeAutoConfiguration;
import com.ninglz.bamboo.commoon.knife.support.KnifeProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @program: bamboo
 * @description:
 * @author: ninglz
 * @created: 2021/07/23 13:24
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableConfigurationProperties(KnifeProperties.class)
@Import({KnifeAutoConfiguration.class})
public @interface EnableBambooKnife {
}
