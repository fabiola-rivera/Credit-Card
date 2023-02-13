package app;
import client.Person;
import payment.CreditCard;
import goods.Item;


import java.util.Random;
public class Controller {


    public static void main(String[] args) throws InterruptedException{

        Person john = new Person(               "John",
                                                "Doe",
                                            "1100 Brickell Ave",
                                             "Apt 102",
                                             "Miami",
                                            "Florida");


        CreditCard masterCard = new CreditCard(john, "Mastercard", 2500.00);

        CreditCard ax = new CreditCard(john, "American Express", 5000.00 );

        john.getCreditCards().add(masterCard);
        john.getCreditCards().add(ax);

Item cafeMocha = new Item("Food", "Cafe Mocha", 4.77);

Item gucciSlipper = new Item("Clothing", "Gucci Princetown", 2650.0);

Item coke = new Item("Food", "Coke", 1.99);

Item airlinesTicket = new Item("Travel", "MIA-SFO", 823.26);

        // step 12

       // john is buying cafeMocha using his MasterCard credit card
           ((CreditCard)john.getCreditCards().get(0)).makeCharge(cafeMocha);

        // john is buying gucciSlipper using his MasterCard credit card
        ((CreditCard)john.getCreditCards().get(0)).makeCharge(gucciSlipper);



        // john is buying gucciSlipper using his American Express  credit card
        ((CreditCard)john.getCreditCards().get(1)).makeCharge(gucciSlipper);

        // john is running a transaction Report on his MasterCard
            ((CreditCard)john.getCreditCards().get(0)).transactionsReport();

        // john is running a transaction Report on his American Express
        ((CreditCard)john.getCreditCards().get(1)).transactionsReport();
Random generator = new Random();

        for(int i=1; i<=7; i++){

            // DO NOT MESS WITH THE SLEEP CODE
            // sleep for a random time upto 1 seconds
            Thread.sleep(generator.nextInt(1001));

            // buy cafeMocha on MasterCard if the cafeMocha is a multiple  3
            if(i % 3 == 0){
                masterCard.makeCharge(cafeMocha);
            } else {
                ax.makeCharge(cafeMocha);
            }

        }//end for

        // buying 5 airlinesTicket using different credit cards
        for(int i=1; i<=5; i++){

            // DO NOT MESS WITH THE SLEEP CODE
            // sleep for a random time upto 1 seconds
            Thread.sleep(generator.nextInt(1001));
if(i % 2 == 0 ){
    masterCard.makeCharge(airlinesTicket);
} else{
    ax.makeCharge(airlinesTicket);
}

        }//end for

        // buying 10 cokes using different credit cards
        for(int i=1; i<=10; i++){

            // sleep for a random time upto 1 seconds
            Thread.sleep(generator.nextInt(1001));

            // this is use to randomly select a credit card
            int randomSelectCard = generator.nextInt(2);

            if(randomSelectCard == 0 ){
                masterCard.makeCharge(coke);
                System.out.printf("randomSelectCard: MasterCard");

            }

          else{
              ax.makeCharge(coke);
              System.out.printf("randomSelectCard: MasterCard");
            }

        }//end for

        // john is running a transaction Report on his masterCard
        ((CreditCard) john.getCreditCards().get(0)).transactionsReport();


        // john is running a transaction Report on his American Express
        ((CreditCard) john.getCreditCards().get(1)).transactionsReport();


        // john is running displayInfo method
        john.displayInfo();







    } // end main

} // end Controller 
