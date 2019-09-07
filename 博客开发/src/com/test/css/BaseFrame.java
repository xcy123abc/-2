package com.test.css;

import javax.swing.*;

public abstract class BaseFrame extends JFrame {
    //模板模式


    public BaseFrame(){
        this.init();
    }

    protected void init(){
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }


    protected abstract void setFontAndSoOn();

    protected abstract void addElement();

    protected abstract void addListener();

    protected abstract void setFrameSelf();





}
