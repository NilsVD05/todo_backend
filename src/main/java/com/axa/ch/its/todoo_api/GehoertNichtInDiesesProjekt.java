package com.axa.ch.its.todoo_api;

public class GehoertNichtInDiesesProjekt {
    private GehoertNichtInDiesesProjekt() {int val = 125;
        if (val < 200) {
            System.out.println("Value is less than 200");
            if (val < 100) {
                System.out.println("Less than 100");
                switch (val) {
                    case 75:
                        System.out.println("It is 75");
                        break;
                    case 50:
                        System.out.println("It is 50");
                        break;
                    case 25:
                        System.out.println("It is 25");
                        break;
                    default:
                        System.out.println("None");
                        break;
                }

            } else if (val < 150) {
                System.out.println("Between 100 and 150");
                switch (val) {
                    case 100:
                        System.out.println("It is 100");
                        break;
                    case 125:
                        System.out.println("It is 125");
                        break;
                    default:
                        System.out.println("None");
                        break;
                }


            } else {
                System.out.println("Value is greater than or equal 150");
            }


        }

    }
}