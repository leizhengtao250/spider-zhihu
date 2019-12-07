package com.netopstec.spiderzhihu.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Paging {
    private Long totals;

    public Long getTotals() {
        return totals;
    }

    public void setTotals(Long totals) {
        this.totals = totals;
    }
}
