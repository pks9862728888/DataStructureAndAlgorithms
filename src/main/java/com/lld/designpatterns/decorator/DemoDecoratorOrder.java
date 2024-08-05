package com.lld.designpatterns.decorator;

import com.lld.designpatterns.decorator.beverages.Beverage;
import com.lld.designpatterns.decorator.beverages.CoffeeBeverage;
import com.lld.designpatterns.decorator.beverages.TeaBeverage;
import com.lld.designpatterns.decorator.beverages.beveragedecorators.SugarCube;
import com.lld.designpatterns.decorator.beverages.beveragedecorators.WhippedCream;

public class DemoDecoratorOrder {

    public static void main(String[] args) {
        Beverage tea = new TeaBeverage();
        printBill(tea);

        // Coffee with 2 sugar cube + whipped cream
        Beverage customCoffee = new CoffeeBeverage();
        customCoffee = new SugarCube(customCoffee, 2);
        customCoffee = new WhippedCream(customCoffee);
        printBill(customCoffee);

    }

    private static void printBill(Beverage beverage) {
        System.out.println("----------------------------------------------------");
        System.out.println("Beverage: " + beverage.description());
        System.out.println("Cost Breakdown: ");
        beverage.costBreakdown().forEach((k, v) -> System.out.printf("%s: %s%n", k, v));
        System.out.println("Total Cost: " + beverage.cost());
    }
}
