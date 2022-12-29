
public class game {
    public static void main(String[] args)  {

        everything connect = new everything();


        connect.shuffleDeck();

        connect.cutDeck();

        connect.firstMoveCards();

        connect.gameMethod();

        connect.secondMoveCards();

        connect.gameMethod();

        connect.thirdMoveCards();

        connect.gameMethod();

        connect.fourthMoveCards();

        connect.gameMethod();

        connect.fifthMoveCards();

        connect.gameMethod();

        connect.sixthMoveCards();

        connect.gameMethod();

        connect.lastCardsOnTheTable();



        if(connect.getPlayerPoint()>connect.getComputerPoint()){
            System.out.println("The player point: " + connect.getPlayerPoint());
            System.out.println("The computer point " + connect.getComputerPoint());
            System.out.println("The winner is player------------------------");

        }
        if(connect.getPlayerPoint()<connect.getComputerPoint()){
            System.out.println("The player point: " + connect.getPlayerPoint());
            System.out.println("The computer point " + connect.getComputerPoint());
            System.out.println("The winner is computer------------------------");

        }
        if(connect.getPlayerPoint()==connect.getComputerPoint()){
            System.out.println("The player point: " + connect.getPlayerPoint());
            System.out.println("The computer point " + connect.getComputerPoint());
            System.out.println("There is no winner------------------------");

        }



    }
}