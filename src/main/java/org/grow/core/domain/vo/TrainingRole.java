package org.grow.core.domain.vo;

import org.grow.core.states.LifeSealer;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Embeddable
public class TrainingRole {
    public enum Role{
        TRAINER,STUDENTMANAGER,STUDENT
    }
    /**
    **note: 后端生成的字段，不是由前端传递进入，一个好的app，希望用户输入很少的内容 持久化更多的内容 而查询到最多的内容
    */
    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDate trainingStartDate;

    @Enumerated(EnumType.STRING)
    private LifeSealer.LifeCircle lifeCircle;

    public LifeSealer.LifeCircle getLifeCircle() {
        return lifeCircle;
    }

    public void setLifeCircle(LifeSealer.LifeCircle lifeCircle) {
        this.lifeCircle = lifeCircle;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public LocalDate getTrainingStartDate() {
        return trainingStartDate;
    }

    public void setTrainingStartDate(LocalDate trainingStartDate) {
        this.trainingStartDate = trainingStartDate;
    }

    @Override
    public String toString() {
        return "TrainingRole{" +
                "role=" + role +
                ", trainingStartDate=" + trainingStartDate +
                ", lifeCircle=" + lifeCircle +
                '}';
    }
}
