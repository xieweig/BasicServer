package org.grow.core.tobody_totail;


import org.grow.core.domain.HeroBasic;
import org.grow.core.domain.TrainingMember;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BasicLongTail {

    @Resource
    private ApplicationContext applicationContext;
    @EventListener
    public void listening(TrainingMember trainingMember){
        System.out.println(trainingMember.getApplicationContext()==null);
    }
    @EventListener()
    @Async
    public void continues(TrainingMember trainingMember) {
        System.out.println("======="+Thread.currentThread().getName());
        System.out.println(trainingMember.toJsonString());


        TrainingMember target = applicationContext.getBean(TrainingMember.class);
        BeanUtils.copyProperties(trainingMember,target);
        System.out.println(trainingMember.getApplicationContext()==null);
        System.out.println("over");
    }

}
