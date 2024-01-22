package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BasketTest {
    @Test
    public void testAddRightBagel(){
        Basket basket = new  Basket();
        Basket.setMaxSize(2);
        Bagel bagelNoFillings = new  Bagel("BGLO", 0.49, "Onion");

        Filling filling1 = new  Filling("FILB", 0.12, "Bacon");
       ArrayList< Filling> fillings = new ArrayList<>();
       fillings.add(filling1);

        Bagel bagelWfillings = new  Bagel("BGLO", 0.49, "Onion", fillings);

       //Add Bagel With no filling
       Assertions.assertTrue(basket.add(bagelNoFillings));

        //Add Bagel With filling
        Assertions.assertTrue(basket.add(bagelWfillings));

       //Try adding with a full basket
       Assertions.assertFalse(basket.add(bagelNoFillings));

    }

    @Test
    public void testAddWrongBagel(){
         Basket basket = new  Basket();

         Bagel bagelWrongPrice = new  Bagel("BGLO", 0.69, "Onion");
         Bagel bagelWrongVariant = new  Bagel("BGLO", 0.39, "Plain");
         Bagel bagelWrongId = new  Bagel("BGL", 0.39, "Plain");



        //Add Wrong Bagel
        Assertions.assertFalse(basket.add(bagelWrongPrice));
        Assertions.assertFalse(basket.add(bagelWrongVariant));
        Assertions.assertFalse(basket.add(bagelWrongId));
        Assertions.assertFalse(basket.add(bagelWrongPrice));

    }

    @Test
    public void testRemove(){
         Basket basket = new  Basket();
         Bagel bagel1 = new  Bagel("BGLO", 0.49, "Onion");
         Bagel bagel2 = new  Bagel("BGLO", 0.49, "Onion");
        basket.add(bagel1);

        //Remove bagel not in basket
        Assertions.assertFalse(basket.remove(bagel2));

        //Remove bagel in basket
        Assertions.assertTrue(basket.remove(bagel1));
    }

    @Test
    public void testAddFillings(){
         Basket basket = new  Basket();
         Bagel bagel = new  Bagel("BGLO", 0.49, "Onion");
         Bagel bagel2 = new  Bagel("BGLO", 0.49, "Onion");
         Filling filling1 = new  Filling("FILB", 0.12, "Bacon");
         Filling filling2 = new  Filling("FILE", 0.12, "Egg");
         Filling fillingWrong = new  Filling("FIL", 0.12, "Egg");

        ArrayList< Filling> fillings = new ArrayList< Filling>();
        fillings.add(filling1);
        fillings.add(filling2);

        ArrayList< Filling>  wrongfillings = new ArrayList< Filling>();
        wrongfillings.add(fillingWrong);
        basket.add(bagel);

        //Add multiple filling to bagel in basket
        Assertions.assertTrue(basket.addFillings(bagel, fillings));

        //Add incorrect filling
        Assertions.assertFalse(basket.addFillings(bagel, wrongfillings));

        //Add filling to bagel not in basket
        Assertions.assertFalse(basket.addFillings(bagel2, fillings));
    }

    @Test
    public void testSetMax(){
         Basket basket = new  Basket();

        //Set max to positive number
        Assertions.assertTrue( Basket.setMaxSize(10));

        //Set max to zero
        Assertions.assertTrue( Basket.setMaxSize(0));

        //Set max to negative number
        Assertions.assertFalse( Basket.setMaxSize(-20));

        Assertions.assertEquals(0,  Basket.getMaxSize());
    }

    @Test
    public void testGetCostOfFilling(){
         Basket basket = new  Basket();
         Filling filling1 = new  Filling("FILB", 0.12, "Bacon");

        //Test get cost of filling
        Assertions.assertEquals(0.12, basket.getCostOfFilling(filling1));

    }
    @Test
    public void testGetCostOfBagel(){
         Basket basket = new  Basket();
         Bagel bagelplain = new  Bagel("BGLP", 0.39, "Plain");
         Filling filling1 = new  Filling("FILB", 0.12, "Bacon");
         Filling filling2 = new  Filling("FILE", 0.12, "Egg");

        ArrayList< Filling> fillings = new ArrayList<>();
        fillings.add(filling1);
        fillings.add(filling2);

         Bagel bagelWithFilling = new  Bagel("BGLP", 0.39, "Plain", fillings);

        //Get cost of plain bagel
        Assertions.assertEquals(0.39, basket.getCostOfBagel(bagelplain));

        //Get cost of bagel with filling on
        Assertions.assertEquals(0.63, basket.getCostOfBagel(bagelWithFilling));
    }
    @Test
    public void testGetTotalCostNoDisCount(){
         Bagel bagelplain = new  Bagel("BGLP", 0.39, "Plain");
         Bagel bagelOnion = new  Bagel("BGLO", 0.49, "Onion");
         Filling filling1 = new  Filling("FILB", 0.12, "Bacon");
         Filling filling2 = new  Filling("FILE", 0.12, "Egg");

        ArrayList<Filling> fillings = new ArrayList<>();
        fillings.add(filling1);
        fillings.add(filling2);

         Bagel bagelWithFilling = new Bagel("BGLP", 0.39, "Plain", fillings);

         Basket basket = new Basket();

        basket.add(bagelplain);
        basket.add(bagelWithFilling);
        basket.add(bagelOnion);

        Assertions.assertEquals( 1.51,basket.getCostOfBasket());
    }

    @Test
    public void testTwelveDiscountForBagels (){
        Basket basket = new Basket();
        Basket.setMaxSize(100);
        Bagel bagel1 = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagel2 = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagel3 = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagel4 = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagel5 = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagel6 = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagel7 = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagel8 = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagel9 = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagel10 = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagel11 = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagel12 = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagel13 = new  Bagel("BGLP", 0.39, "Plain");


        //exactly 12-discount
        basket.add(bagel1);
        basket.add(bagel2);
        basket.add(bagel3);
        basket.add(bagel4);
        basket.add(bagel5);
        basket.add(bagel6);
        basket.add(bagel7);
        basket.add(bagel8);
        basket.add(bagel9);
        basket.add(bagel10);
        basket.add(bagel11);
        basket.add(bagel12);
        System.out.println(basket.getProducts().size());

        Assertions.assertEquals(3.99, basket.getCostOfBasket());

        basket.add(bagel13);

        //more than 12-discount
        Assertions.assertEquals(4.38, basket.getCostOfBasket());
    }
}