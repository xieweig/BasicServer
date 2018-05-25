package org.grow.core.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.grow.core.infrasturcture.JpaRepo;
import org.grow.core.states.BornSealer;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

import java.util.Random;


public class BaseDomain{

    @JsonIgnore
    @Resource
    protected ApplicationContext applicationContext;

    @JsonIgnore
    @Resource
    protected JpaRepo jpaRepo;
    /**
     * 目测应该用状态策略，暂时这样 todo
     * */
    @JsonIgnore
    @Resource
    protected Random random;

    @JsonIgnore
    @Resource
    protected ObjectMapper objectMapper;
    /**
    **note: 测试使用
    */
    @JsonIgnore
    @Resource
    private BornSealer bornSealer;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
