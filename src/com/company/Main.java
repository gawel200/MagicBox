package com.company;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JFrame implements ActionListener {

    JLabel lZawartoscSkrzyni;

    public Main(){
        //The probability of occurrence of the item is as follows: 50% Consumables , 40% Normal item, 5% Rare item, 3% Unique item, 2% Epic item."
        //Window and buttun
        setSize(300, 200);
        setTitle("THE GAME");
        setLayout(null);
        JButton bOtworzSkrzynie = new JButton("OPEN");
        bOtworzSkrzynie.setBounds(500,400,300,120);
        add(bOtworzSkrzynie);
        bOtworzSkrzynie.addActionListener(this);

        //Description, text, item you rolled
        lZawartoscSkrzyni = new JLabel("Push the button below to open chest and try your luck!");
        lZawartoscSkrzyni.setBounds(400,200,1000,20);
        lZawartoscSkrzyni.setForeground(new Color(20,100,200));
        add(lZawartoscSkrzyni);
    }

    public static void main(String[] args) {

        Main okienko = new Main();
        okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okienko.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        Random r = new Random();

        //Category
        int firstRoll = r.nextInt(101);

        //Grade of item / Type of item (consumables)
        int secondRoll = r.nextInt (101);

        //Type of item
        int thirdRoll = r.nextInt (101);
        System.out.println("The probability of occurrence of the item is as follows: 50% Consumables , 40% Normal item, 5% Rare item, 3% Unique item, 2% Epic item.");
        System.out.println(firstRoll + " Item category");
        System.out.println(secondRoll + " Grade of item");
        System.out.println(thirdRoll + " Type of item");
        lZawartoscSkrzyni.setText(categoryRoll(firstRoll, secondRoll, thirdRoll));

    }

    //Category
    public static String categoryRoll (int firstRollNumber, int secondRollNumber, int thirdRollNumber) {
        if (firstRollNumber <= 50) {
            return consItem(secondRollNumber);
        } else if (firstRollNumber <= 90) {
            return normalItemRoll(secondRollNumber,thirdRollNumber);
        } else if (firstRollNumber <= 95) {
            return rareItemRoll(secondRollNumber,thirdRollNumber);
        } else if (firstRollNumber <= 98) {
            return uniqueItemRoll(secondRollNumber,thirdRollNumber);
        } else return epicItemRoll(secondRollNumber,thirdRollNumber);
    }

    //Type of consumables
    public static String consItem (int consRoll) {
        if (consRoll <= 8) {
            return "HP potion";
        } else if (consRoll <= 16){
            return "MP Potion";
        } else if (consRoll <= 24) {
            return "Sapphire";
        } else if (consRoll <= 32) {
            return "Emerald";
        } else if (consRoll <= 40) {
            return "Diamond";
        } else if (consRoll <= 48) {
            return "Alkohol";
        } else if (consRoll <= 56) {
            return "Fireworks";
        } else if (consRoll <= 64) {
            return "10 000 gold";
        } else if (consRoll <= 72) {
            return "Chest";
        } else if (consRoll <= 80) {
            return "Knight Cape";
        } else if (consRoll <= 86) {
            return "Wizard Cape";
        } else if (consRoll <= 91) {
            return "Archery Cape";
        } else if (consRoll <= 96) {
            return "Horse Mount";
        } else if (consRoll <= 98) {
            return "Dragon Pet";
        } else return "Pheonix Pet";
    }

    //Grade Normal items
    public static String normalItemRoll (int grupRoll, int itemRoll) {
        if (grupRoll <= 20) {
            return "Normal " + jewelleryRoll(itemRoll);
        } else if (grupRoll <= 40) {
            return "Normal " + weaponRoll(itemRoll);
        } else if (grupRoll <= 60) {
            return "Normal " + armorRoll(itemRoll);
        } else if (grupRoll <= 80) {
            return "Normal " + helmetRoll(itemRoll);
        } else return "Normal " + bootsRoll(itemRoll);
    }

    //Grade Rare items
    public static String rareItemRoll (int rareRoll, int itemRoll) {
        if (rareRoll<= 20) {
            return "Rare " + jewelleryRoll(itemRoll);
        } else if (rareRoll <= 40) {
            return "Rare " + weaponRoll(itemRoll);
        } else if (rareRoll <= 60) {
            return "Rare " + armorRoll(itemRoll);
        } else if (rareRoll <= 80) {
            return "Rare " + helmetRoll(itemRoll);
        } else return "Rare " + bootsRoll(itemRoll);
    }

    //Grade Unique items
    public static String uniqueItemRoll (int uniqueRoll, int itemRoll) {
        if (uniqueRoll <= 20) {
            return "Unique " + jewelleryRoll(itemRoll);
        } else if (uniqueRoll <= 40) {
            return "Unique " + weaponRoll(itemRoll);
        } else if (uniqueRoll <= 60) {
            return "Unique " + armorRoll(itemRoll);
        } else if (uniqueRoll <= 80) {
            return "Unique " + helmetRoll(itemRoll);
        } else return "Unique " + bootsRoll(itemRoll);
    }

    //Grade Epic items
    public static String epicItemRoll (int epicRoll, int itemRoll) {
        if (epicRoll <= 20) {
            return "Epic " + jewelleryRoll(itemRoll);
        } else if (epicRoll<= 40) {
            return "Epic " + weaponRoll(itemRoll);
        } else if (epicRoll <= 60) {
            return "Epic " + armorRoll(itemRoll);
        } else if (epicRoll <= 80) {
            return "Epic " + helmetRoll(itemRoll);
        } else return "Epic " + bootsRoll(itemRoll);
    }

    //Type of jawellery
    public static String jewelleryRoll (int jewelleryItem) {
        if (jewelleryItem <=50) {
            return "Ring";
        } else return "Neckless";
    }
    //Type of weapons
    public static String weaponRoll (int weaponItem) {
        if (weaponItem <= 20) {
            return "Bow";
        } else if (weaponItem <= 40) {
            return "Staff";
        } else if (weaponItem <= 60) {
            return "One handed sword";
        } else if (weaponItem <= 80) {
            return "Shield";
        } else return "Two handed mace";
    }

    //Type of armors
    public static String armorRoll (int armorItem) {
        if (armorItem <= 34) {
            return "Cloth armor";
        } else if (armorItem <= 67) {
            return "Leather armor";
        } else return "Plate armor";

    }

    //Type of helmets
    public static String helmetRoll (int helmetItem) {
        if (helmetItem <= 33) {
            return "Cloth helmet";
        } else if (helmetItem <= 67) {
            return "Leather helemet";
        } else return "Plate helmet";

    }

    //Type of boots
    public static String bootsRoll (int bootsItem) {
        if (bootsItem <= 33) {
            return "Cloth boots";
        } else if (bootsItem <= 66) {
            return "Leather boots";
        } else return "Plate boots";
    }

}
