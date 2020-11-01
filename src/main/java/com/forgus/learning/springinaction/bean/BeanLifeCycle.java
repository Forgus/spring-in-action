package com.forgus.learning.springinaction.bean;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BeanLifeCycle implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean {
    @Override
    public void setBeanName(String s) {
        log.info("Step3:invoke method -> setBeanName()./n");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("Step4:invoke method -> setBeanFactory()./n beanFactory:{}", JSON.toJSONString(beanFactory));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("Step5:invoke method -> setApplicationContext()./n applicationContext:{}", JSON.toJSONString(applicationContext));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Step6:invoke method -> postProcessBeforeInitialization()./n");
        log.info("bean:{},beanName:{}", JSON.toJSONString(bean),beanName);
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Step7:invoke method -> afterPropertiesSet()./n");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Step8:invoke method -> postProcessAfterInitialization()./n");
        log.info("bean:{},beanName:{}", JSON.toJSONString(bean),beanName);
        return null;
    }

    @Override
    public void destroy() throws Exception {
        log.info("Step10:invoke method -> destroy()./n");
    }
}
