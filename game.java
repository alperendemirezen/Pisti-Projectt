public class game {
    public static void main(String[] args) {
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

        System.out.println(connect.getPlayerPoint());
        System.out.println(connect.getComputerPoint());

    }
}