package org.grow.core.infrasturcture.dto;

import org.grow.core.domain.TrainingMember;
import org.grow.core.domain.TrainingScore;
import org.grow.core.domain.vo.IndividualInfo;
import org.grow.core.infrasturcture.Assistant;

import java.util.ArrayList;
import java.util.List;

public class TrainingMemberAssistant implements Assistant<TrainingMember> {

    private String memberCode;


    private List<TrainingScore> trainingScores = new ArrayList<TrainingScore>();


    private Long id;


    private IndividualInfo individualInfo;

    @Override
    public void validate() {

    }

    @Override
    public Class<TrainingMember> getHeroClass() {
        return TrainingMember.class;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public List<TrainingScore> getTrainingScores() {
        return trainingScores;
    }

    public void setTrainingScores(List<TrainingScore> trainingScores) {
        this.trainingScores = trainingScores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IndividualInfo getIndividualInfo() {
        return individualInfo;
    }

    public void setIndividualInfo(IndividualInfo individualInfo) {
        this.individualInfo = individualInfo;
    }

    @Override
    public String toString() {
        return "TrainingMemberAssistant{" +
                "memberCode='" + memberCode + '\'' +
                ", trainingScores=" + trainingScores +
                ", id=" + id +
                ", individualInfo=" + individualInfo +
                '}';
    }
}
