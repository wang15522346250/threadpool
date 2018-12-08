package com.alipay.demo.demo;

import java.io.Serializable;

/**
 * 测试类
 */
public class RiskLimit implements Comparable {

    public RiskLimit(Integer value, Integer start, Integer end) {
        this.value = value;
        this.start = start;
        this.end = end;
    }

    public RiskLimit() {
    }

    /**
     * 额度值
     */
    private Integer value;
    /**
     * 起始值
     */
    private Integer start;
    /**
     * 结束值
     */
    private Integer end;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "RiskLimit{" +
                "start=" + start +
                ", end=" + end +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
