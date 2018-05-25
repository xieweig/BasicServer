package org.grow.core.states;

import org.grow.core.domain.TrainingMember;
import org.grow.core.domain.vo.TrainingRole;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Random;

public class BornSealer implements LifeSealer<TrainingMember>{
    @Resource
    private Random random;
    @Override
    public TrainingMember lifeSeal(TrainingMember trainingMember) {
     trainingMember.setMemberCode("0200"+(random.nextInt(9000)+1000));
     //所以Trainingmember应该直接暴露三个属性
     trainingMember.getTrainingRole().setTrainingStartDate(LocalDate.now());
     trainingMember.getTrainingRole().setRole(TrainingRole.Role.STUDENT);
     trainingMember.getTrainingRole().setLifeCircle(LifeCircle.ANEWBORN);

        return trainingMember;
    }
}
