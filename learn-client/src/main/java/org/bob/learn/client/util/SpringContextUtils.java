package org.bob.learn.client.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * spring 上下文工具类
 */
@Slf4j
public final class SpringContextUtils {

    private static ApplicationContext applicationContext;

    /**
     * 私有构造器
     * 禁止通过反射构造类实例
     * @throws IllegalAccessException 非法访问异常
     */
    private SpringContextUtils() throws IllegalAccessException {
        throw new IllegalAccessException("禁止访问SpringContextUtils私有构造方法");
    }

    /**
     * 设置应用上下文
     * @param applicationContext 应用上下文
     */
    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtils.applicationContext = applicationContext;
    }

    /**
     * 根据beanType获取bean
     *
     * @param beanType bean类型
     * @param <T> bean类
     * @return  bean实例对象
     */
    public static <T> T getBean(Class<T> beanType) {
        try {
            return applicationContext.getBean(beanType);
        } catch (BeansException e) {
            log.error("Getting bean of beanType {} from applicationContext occurs exception [{}]",beanType,e.getMessage());
            return null;
        }
    }

    /**
     * 根据name和beanType获取bean
     *
     * @param beanName
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanName, Class<T> beanType) {
        try {
            return applicationContext.getBean(beanName, beanType);
        } catch (BeansException e) {
            log.error("Getting bean of beanName[{}] and beanType[{}] from applicationContext occurs exception [{}]",beanName,beanType,e.getMessage());
            return null;
        }
    }

    /**
     * 根据name获取bena
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        try {
            return applicationContext.getBean(beanName);
        } catch (BeansException e) {
            log.error("Getting bean of beanName[{}] from applicationContext occurs exception [{}]",beanName,e.getMessage());
            return null;
        }

    }

    /**
     * 根据beanType获取beans
     *
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> beanType) {
        try {
            return applicationContext.getBeansOfType(beanType);
        } catch (BeansException e) {
            log.error("Getting beans of beanType[{}] from applicationContext occurs exception [{}]",e.getMessage());
            return null;
        }
    }

    @Component
    final static class SpringContext implements ApplicationContextAware {

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            SpringContextUtils.setApplicationContext(applicationContext);
        }
    }

}
