package org.grow.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.grow.core.domain.vo.BaseDomain;
import org.grow.core.domain.vo.IndividualInfo;
import org.grow.core.domain.vo.TrainingRole;
import org.grow.core.infrasturcture.Assistant;

import org.grow.core.states.LifeSealer;
import org.springframework.beans.BeanUtils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope(value = "request")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainingMember extends BaseDomain implements Morphling<TrainingMember> , HeroBasic<TrainingMember> {

    @Column(updatable = false, nullable = false,unique = true)
    private String memberCode ;
    /**
    **note: 非前台传入信息 关乎多模块查询以及后端状态机的关键信息
    */
    private TrainingRole trainingRole = new TrainingRole();
    /**
    **note: 前台传入信息 固定长度部分
    */
    private IndividualInfo individualInfo;
    /**
     **note: 前台传入信息 非固定长度部分 可以考虑并入individual`或者 trainingRole里面
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "memberCode",referencedColumnName = "memberCode")
    private List<TrainingScore> trainingScores = new ArrayList<TrainingScore>();
    /**
     **note: 非信息部分 依赖注入
     */

    @Override
    public TrainingMember enrichRepo(RepoType repoType) {
        switch (repoType) {
            case JPA:
                /**
                **note: 此处有问题 当返回的仅仅是个序列化后的数据体怎么解决依赖注入的问题
                */
                TrainingMember temp = jpaRepo.save(this);
                this.setTrainingRole(temp.getTrainingRole());
                this.setTrainingScores(temp.getTrainingScores());
                return this;
            case REDIS:
                return null;
        }
        return this;
    }
  @Override
    public TrainingMember noticeOthers(PublishType publishType) {
        System.out.println((applicationContext==null)+"????1");
        switch (publishType){
            case SPRING_LISTENER:
                System.out.println((applicationContext==null)+"????");
                applicationContext.publishEvent(this);
                return this;

        }
         return this;
    }

    @Override
    public TrainingMember acceptDataFrom(Assistant<TrainingMember> a) {

        a.validate();
        BeanUtils.copyProperties(a,this);
        return this;
    }

    @Override
    public TrainingMember lifeTransition(LifeSealer<TrainingMember> sealer) {
        return  sealer.lifeSeal(this);
    }

    @Override
    public String toJsonString() {
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public TrainingMember getInstanceFromJsonString(String jsonString) {
       //objectMapper.readValue(this, new TypeReference<TrainingMember>() { });
       return  null;
    }
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public TrainingRole getTrainingRole() {
        return trainingRole;
    }

    public void setTrainingRole(TrainingRole trainingRole) {
        this.trainingRole = trainingRole;
    }

    public List<TrainingScore> getTrainingScores() {
        return trainingScores;
    }

    public void setTrainingScores(List<TrainingScore> trainingScores) {
        this.trainingScores = trainingScores;
    }

    public IndividualInfo getIndividualInfo() {
        return individualInfo;
    }

    public void setIndividualInfo(IndividualInfo individualInfo) {
        this.individualInfo = individualInfo;
    }

    @Override
    public String toString() {
        return "TrainingMember{" +
                "memberCode='" + memberCode + '\'' +
                ", trainingRole=" + trainingRole +
                ", individualInfo=" + individualInfo +
                ", trainingScores=" + trainingScores +
                '}';
    }
}
