package com.netopstec.spiderzhihu.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProxyIpStatus {

    SUCCESS("检测成功",1),
    FAIL("检测失败", 0),
    TO_TEST("待检测", -1);

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    private String desc;
    private Integer value;

    ProxyIpStatus(String s, int i) {
    }

}
