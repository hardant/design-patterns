package com.brandon.designPattern._1_factoryMethod;

/**
 * 工厂方法模式
 *
 * 当我们只有在程序运行时才能确认使用某一个接口/类的哪一个子类是。我们可以使用工厂方法模式
 *
 * 工厂方法模式可以让降低代码的耦合性，提高代码的灵活性
 */

public class GetPlanFactory {
    public Plan getPlan(String planType) {
        if (planType == null) {
            return null;
        }

        if (planType.equals("DOMESTIC_PLAN")) {
            return new DomesticPlan();
        } else if (planType.equals("COMMERCIAL_PLAN")) {
            return new CommercialPlan();
        } else if (planType.equals("INSTITUTIONAL_PLAN")) {
            return new InstitutionalPlan();
        } else {
            return null;
        }
    }
}
