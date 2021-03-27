package com.alex.designpattern.factory.simplefactory;

import com.alex.designpattern.util.ConfigUtil;

public class Client {
    public static void main(String[] args) {
        // Chart chart = ChartFactory.getChart("line");
        // chart.display();

        //Chart chart = ChartFactory.getChart(ConfigUtil.getProperty("chart.properties", "chartType"));
        //chart.display();

        Chart chart = ChartFactory.getChart(ConfigUtil.getXmlConfig("chart.xml", "chartType"));
        chart.display();
    }
}
