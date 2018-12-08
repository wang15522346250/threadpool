package com.alipay.demo.demo;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 集合排序
 */
public class ListTest {

    @Test
    public void test() {
        RiskLimit riskLimit = new RiskLimit();
        riskLimit.setStart(300);
        riskLimit.setEnd(349);
        riskLimit.setValue(1000);
        RiskLimit riskLimit1 = new RiskLimit();
        riskLimit1.setStart(350);
        riskLimit1.setEnd(399);
        riskLimit1.setValue(2000);
        RiskLimit riskLimit2= new RiskLimit();
        riskLimit2.setStart(400);
        riskLimit2.setEnd(449);
        riskLimit2.setValue(3000);
        ArrayList<RiskLimit> riskLimits = Lists.newArrayList(riskLimit1, riskLimit, riskLimit2);
        System.out.println("未排序之前：riskLimits = " + riskLimits);
        Collections.sort(riskLimits, new Comparator<RiskLimit>() {
            @Override
            public int compare(RiskLimit o1, RiskLimit o2) {
                return o1.getStart().compareTo(o2.getStart());
            }
        });
        System.out.println("排序之后：riskLimits = " + riskLimits);
    }
}
