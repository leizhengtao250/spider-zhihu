package com.netopstec.spiderzhihu.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhenye 2019/6/19
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 昵称
     */
    private String name;
    /**
     * 用户持有的唯一token
     */
    private String urlToken;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 回答数
     */
    private Integer answerCount;
    /**
     * 文章数
     */
    private Integer articleCount;
    /**
     * 关注数
     */
    private Integer followerCount;
    /**
     * 现居地
     */
    private String home;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlToken() {
        return urlToken;
    }

    public void setUrlToken(String urlToken) {
        this.urlToken = urlToken;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public Integer getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * 所在行业
     */
    private String industry;
    /**
     * 所在公司
     */
    private String company;
    /**
     * 所处职位
     */
    private String job;
    /**
     * 大学
     */
    private String university;
    /**
     * 专业
     */
    private String major;
}
