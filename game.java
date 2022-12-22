public class game {
    public static void main(String[] args) {
        everything link = new everything();

        link.shuffleDeck();

        link.cutDeck();

        link.firstMoveCards();

        link.gameMethod();

        link.secondMoveCards();

        link.gameMethod();

        link.thirdMoveCards();

        link.gameMethod();

        link.fourthMoveCards();

        link.gameMethod();

        link.fifthMoveCards();

        link.gameMethod();

        link.sixthMoveCards();

        link.gameMethod();

        System.out.println(link.playerPoint);
        System.out.println(link.computerPoint);


    }
}