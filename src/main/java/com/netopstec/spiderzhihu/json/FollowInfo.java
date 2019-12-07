package com.netopstec.spiderzhihu.json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 关注以及被关注者列表的json对应对象
 * @author zhenye 2019/6/19
 */
@Getter
@Setter
@ToString
public class FollowInfo {
    private Paging paging;

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<UserInfo> getData() {
        return data;
    }

    public void setData(List<UserInfo> data) {
        this.data = data;
    }

    private List<UserInfo> data;
}
