
public class game {
    public static void main(String[] args)  {

        everything connect = new everything();


        connect.shuffleDeck();

        connect.cutDeck();

        connect.firstMoveCards();

        connect.playGame();

        connect.secondMoveCards();

        connect.playGame();

        connect.thirdMoveCards();

        connect.playGame();

        connect.fourthMoveCards();

        connect.playGame();

        connect.fifthMoveCards();

        connect.playGame();

        connect.sixthMoveCards();

        connect.playGame();

        connect.lastCardsOnTheTable();



        if(connect.getPlayerScore()>connect.getComputerScore()){
            System.out.println("The player point: " + connect.getPlayerScore());
            System.out.println("The computer point " + connect.getComputerScore());
            System.out.println("The winner is player------------------------");

        }
        if(connect.getPlayerScore()<connect.getComputerScore()){
            System.out.println("The player point: " + connect.getPlayerScore());
            System.out.println("The computer point " + connect.getComputerScore());
            System.out.println("The winner is computer------------------------");

        }
        if(connect.getPlayerScore()==connect.getComputerScore()){
            System.out.println("The player point: " + connect.getPlayerScore());
            System.out.println("The computer point " + connect.getComputerScore());
            System.out.println("There is no winner------------------------");

        }



    }
}