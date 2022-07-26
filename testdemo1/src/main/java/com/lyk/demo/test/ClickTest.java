package com.lyk.demo.test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 测试鼠标点击
 */
public class ClickTest {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        int n = 0;
        while (true) {
            n++;
            // 按下鼠标左键
            robot.mousePress(KeyEvent.BUTTON1_MASK);
            // 松开鼠标左键
            robot.mouseRelease(KeyEvent.BUTTON1_MASK);
            System.out.println("鼠标第"+n+"次点击");
            //五分钟
            Thread.sleep(5 * 1000);
        }
    }


}
