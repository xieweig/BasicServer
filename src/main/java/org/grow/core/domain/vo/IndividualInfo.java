package org.grow.core.domain.vo;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Embeddable
public class IndividualInfo {


    private String nameChinese;

    private String nameEnglish;

    private LocalDate birthday;


    public String getNameChinese() {
        return nameChinese;
    }

    public void setNameChinese(String nameChinese) {
        this.nameChinese = nameChinese;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    @Override
    public String toString() {
        return "IndividualInfo{" +
                "nameChinese='" + nameChinese + '\'' +
                ", nameEnglish='" + nameEnglish + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
