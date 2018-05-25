package org.grow.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class TrainingScore implements Serializable {
    @Id
    @GeneratedValue
    private Long id = 0l;

    private Integer Score;

    private String TrainingClassCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }

    public String getTrainingClassCode() {
        return TrainingClassCode;
    }

    public void setTrainingClassCode(String trainingClassCode) {
        TrainingClassCode = trainingClassCode;
    }

    @Override
    public String toString() {
        return "TrainingScore{" +
                "id=" + id +
                ", Score=" + Score +
                ", TrainingClassCode='" + TrainingClassCode + '\'' +
                '}';
    }
}
