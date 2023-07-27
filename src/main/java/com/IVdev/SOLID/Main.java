package com.IVdev.SOLID;

import com.IVdev.SOLID.DIP.Framework;
import com.IVdev.SOLID.DIP.IForm;
import com.IVdev.SOLID.DIP.ModelForm;
import com.IVdev.SOLID.LSP.OmenHP;
import com.IVdev.SOLID.OCP.SaveComputerToDB;
import com.IVdev.SOLID.OCP.SaveInterface;
import com.IVdev.SOLID.SR.Computer;
import com.IVdev.SOLID.SR.SavePC;

public class Main {
    public static void main(String[] args) {
        Computer comp = new Computer("IBM XT", 50000);

        //single resp принцип********************
//        SavePC saver = new SavePC();
//        saver.saveToDB("out.dat", comp);

        //open-close принцип на основе полиморфизма*****************
//        SaveInterface saver = new SaveComputerToDB();
//        saver.save("out.dat", comp);

        //для принципа Барбары Лисков**********************
        test();
    }

    //тестовый метод для принципа Барбары Лисков
    //дочерний setData + ко всему меняет еще и размер памяти по сравнению с род.методом
    public static void test() {
        Computer comp = new Computer("IBM XT", 50000);
        Computer comp2 = new OmenHP("OmenHP", 50000);

        comp2.setData("IBM XT");
        if(comp.name.compareTo(comp2.name) == 0 && comp.memory_size == comp2.memory_size) {
            System.out.println("test ok");
        } else {
            System.out.println("test failed");
        }

        //для dependency inversion principle********************************
        //framework и MySQL сильно завязаны на зависимость от ModelForm
        //каждая форма д. реализовать общий интерфейс, интерфейс используется в программе
        IForm frm = new ModelForm(1, 13, "Turunen");
        Framework framework = new Framework();
        framework.save(frm);
    }
}
