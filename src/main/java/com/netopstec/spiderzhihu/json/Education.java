package com.netopstec.spiderzhihu.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 教育经历
 * @author zhenye 2019/7/4
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Education {
    private School school;
    private Major major;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Integer getDiploma() {
        return diploma;
    }

    public void setDiploma(Integer diploma) {
        this.diploma = diploma;
    }

    public Integer getEntrance_year() {
        return entrance_year;
    }

    public void setEntrance_year(Integer entrance_year) {
        this.entrance_year = entrance_year;
    }

    private Integer diploma;
    private Integer entrance_year;
}
