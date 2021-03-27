package com.alex.designpattern.factory.skin;

import java.util.ArrayList;
import java.util.List;

public abstract class ComboBox {
    public static final List<String> options = new ArrayList<>();
    static {
        options.add("Thu");
        options.add("Pku");
        options.add("Ucb");
        options.add("Mit");
    }

    public abstract String getOption(int index);

    public abstract void display();
}
