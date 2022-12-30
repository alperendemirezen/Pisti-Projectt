import java.util.Random;
import java.util.Scanner;


public class everything {
    card[] newDeck;
    card[] firstPart;
    card[] secondPart;
    card[] readyDeck;
    card[] playerCards;
    card[] computerCards;
    card[] boardCards;
    card[] playerAll;
    card[] computerAll;
    card lastCard;
    private int playerPoint;
    private int computerPoint;
    private int turnCounter;
    private int boardCounter;
    private int playerAllCounter;
    private int computerAllCounter;
    private String lastWinner;//Value needed to determine who gets the last cards left on the table
    private String codeBlocks;


    public everything() {
        newDeck = new card[52];  //new sequential deck
        firstPart = new card[52];  //the first part of the deck to be created after cutting
        secondPart = new card[52]; //the second part of the deck to be created after cutting
        readyDeck = new card[52];  //deck to be used in the game
        playerCards = new card[4]; //cards in the player's hand during the game
        computerCards = new card[4]; //4 cards that the computer can use during the game
        boardCards = new card[52]; //first 4 cards on the table
        playerAll = new card[52]; //array where the player's won cards go
        computerAll = new card[52]; //array where the computer's won cards go
        playerPoint = 0; //player's score
        computerPoint = 0; //computer's score
        turnCounter = 0;  //counter used to see how many times the loop has run
        boardCounter = 4; //number of cards on the board
        playerAllCounter = 0; //number of cards won by the player
        computerAllCounter = 0; //number of cards won by the computer
        codeBlocks = "on"; //used to check a block
        lastCard = new card(0, "c"); //last card on the table(filled in to identify)


        for (int i = 0; i < 52; i++) {
            card boardCard = new card(0, "b");
            boardCards[i] = boardCard;
        }
        for (int i = 0; i < 52; i++) {
            card computerCard = new card(0, "c");
            computerAll[i] = computerCard;
        }
        for (int i = 0; i < 52; i++) {
            card playerCard = new card(0, "p");
            playerAll[i] = playerCard;
        }
        //Filled so that it is not empty.

        for (int i = 0; i < 13; i++) {
            card spadeCards = new card(i + 1, "♠");
            newDeck[i] = spadeCards;
        }
        for (int i = 13; i < 26; i++) {
            card heartCards = new card(i - 12, "♥");
            newDeck[i] = heartCards;
        }
        for (int i = 26; i < 39; i++) {
            card diamondCards = new card(i - 25, "♦");

            newDeck[i] = diamondCards;
        }
        for (int i = 39; i < 52; i++) {
            card clubCards = new card(i - 38, "♣");
            newDeck[i] = clubCards;
        }
        //Deck created.


    }

    public void shuffleDeck() {
        Random r = new Random();
        for (int i = 0; i < newDeck.length; i++) {
            int firstplace = r.nextInt(52);
            int secondplace = r.nextInt(52);

            card number = newDeck[firstplace];
            newDeck[firstplace] = newDeck[secondplace];
            newDeck[secondplace] = number;
        }
        //The deck is shuffled.
    }


    public void cutDeck() {
        Random r = new Random();
        int cutNo = r.nextInt(51);
        System.arraycopy(newDeck, 0, secondPart, 0, cutNo);
        System.arraycopy(newDeck, cutNo, firstPart, 0, newDeck.length - cutNo);
        System.arraycopy(firstPart, 0, readyDeck, 0, newDeck.length - cutNo);
        System.arraycopy(secondPart, 0, readyDeck, (newDeck.length - cutNo), cutNo);

        //The deck was cut from a random number.

    }

    public void firstMoveCards() {

        for (int i = 0; i < 8; i += 2) {
            computerCards[i / 2] = readyDeck[i];
            playerCards[i / 2] = readyDeck[i + 1];
        }
        for (int i = 0; i < 4; i++) {
            boardCards[i] = readyDeck[i + 8];
            lastCard = boardCards[i];
        }
        //The cards were first dealt to the players and then to the table.
    }

    public void secondMoveCards() {
        for (int i = 12; i < 20; i += 2) {
            computerCards[(i - 12) / 2] = readyDeck[i];
            playerCards[(i - 12) / 2] = readyDeck[i + 1];
        }
        //When the cards in the hands of the players are exhausted, they are dealt a second time.
    }

    public void thirdMoveCards() {
        for (int i = 20; i < 28; i += 2) {
            computerCards[(i - 20) / 2] = readyDeck[i];
            playerCards[(i - 20) / 2] = readyDeck[i + 1];
        }
        //When the cards in the hands of the players are exhausted, they are dealt a third time.
    }

    public void fourthMoveCards() {
        for (int i = 28; i < 36; i += 2) {
            computerCards[(i - 28) / 2] = readyDeck[i];
            playerCards[(i - 28) / 2] = readyDeck[i + 1];
        }
        //When the cards in the hands of the players are exhausted, the cards are dealt a fourth time.
    }

    public void fifthMoveCards() {
        for (int i = 36; i < 44; i += 2) {
            computerCards[(i - 36) / 2] = readyDeck[i];
            playerCards[(i - 36) / 2] = readyDeck[i + 1];
        }
        //When the cards in the hands of the players are exhausted, the cards are dealt a fifth time.
    }

    public void sixthMoveCards() {
        for (int i = 44; i < 52; i += 2) {
            computerCards[(i - 44) / 2] = readyDeck[i];
            playerCards[(i - 44) / 2] = readyDeck[i + 1];
        }
        //When the cards in the hands of the players are exhausted, the cards are dealt a sixth and last time.
    }

    public void gameMethod() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < 4; i++) {
     //The game will be played against each other for 4 rounds until the cards in the hand are exhausted.
            for (int k = 0; k < 4; k++) {
                if (boardCounter != 0) {
                    if (computerCards[k].getValue() == lastCard.getValue() || computerCards[k].getValue() == 11) {
                //If the computer has a card with the same number as the last card on the table, it will enter this block.(or joker)

                        if (computerCards[k].getValue()==11){System.out.println("Computer played this card and take all:" + "Joker" + computerCards[k].getSymbol());}
                        else {System.out.println("Computer played this card and take all:" + computerCards[k].getValue() + computerCards[k].getSymbol());}
                        //Shows which card the computer won by discarding

                        boardCards[boardCounter].copyCard(computerCards[k]);    //The card of the same value is thrown on the table.
                        boardCounter++;
                        computerCards[k].setValue(-1);    //The value was changed to minus one so that the index used by the players would not be used until the card came again.
                        computerPointMethod();     //How many points will be counted and added before the cards on the table are collected.
                        lastWinner = "computer";   //If there is no winner after that, the computer will take the remaining cards on the table.
                        codeBlocks = "off";        //The value has become "off" so that it is not entered in the next line of code.

                        for (int j = 0; j < boardCounter; j++) {
                            computerAll[computerAllCounter + j].copyCard(boardCards[j]);
                            boardCards[j].setValue(0);
                            turnCounter++;
                        //The cards on the table are collected and the int values of the empty indexes in the table are set to 0.
                        }
                        boardCounter = 0;
                        computerAllCounter += turnCounter;
                        turnCounter = 0;
                        lastCard.setValue(0); //The int value is set to 0 so that the lastcard is not used because there is no card on the table.
                        break;
                    }
                }
            }
            if (codeBlocks.equals("on")) {
            //If the computer does not have a card of the same rank as the last card on the table, the code block it will enter.
                int x = r.nextInt(computerCards.length);
                while (computerCards[x].getValue() == -1) {
                    x = r.nextInt(computerCards.length);
                    if (computerCards[x].getValue() != -1)
                        break;
                    //A random card has been discarded.
                }


                boardCards[boardCounter].copyCard(computerCards[x]);
                lastCard.copyCard(computerCards[x]);
                computerCards[x].setValue(-1);
                boardCounter++;
                //The random card discarded became the last card on the table.
            }
            codeBlocks = "on";

            if (lastCard.getValue() == 0) { //If there is no card on the table, it gives a warning saying that there is no card.
                System.out.println("No card on the table");
            } else if (lastCard.getValue() == 11) {System.out.println("Last card on the table is:" + " " + "Jack" + lastCard.getSymbol());
            } else if (lastCard.getValue() == 12) {System.out.println("Last card on the table is:" + " " + "Quenn" + lastCard.getSymbol());
            } else if (lastCard.getValue() == 13) {System.out.println("Last card on the table is:" + " " + "King" + lastCard.getSymbol());
            } else {System.out.println("Last card on the table is:" + " " + lastCard.getValue() + lastCard.getSymbol());
            }

            for (int k = 0; k < 4; k++) {
                if (playerCards[k].getValue() == 11) {System.out.println(k + "=" + "Jack" + playerCards[k].getSymbol());
                } else if (playerCards[k].getValue() == 12) {System.out.println(k + "=" + "Quenn" + playerCards[k].getSymbol());
                } else if (playerCards[k].getValue() == 13) {System.out.println(k + "=" + "King" + playerCards[k].getSymbol());
                } else if (playerCards[k].getValue() == -1) {System.out.println(k + "=");
                } else {System.out.println(k + "=" + playerCards[k].getValue() + playerCards[k].getSymbol());
                }
            }
            //Jack,Queen and King defined to be printed on the screen after cutting and mixing sections.


            System.out.println("Choose a number to play your card 0,1,2 or 3.");
            int chosen;

            while(true) {
                String input = sc.nextLine();
                try {
                    chosen = Integer.parseInt(input);
                } catch (Exception e) {
                    System.out.println("Something is wrong.Please try again");
                    continue;
                }
                if (chosen <= 3 && chosen >= 0 && playerCards[chosen].getValue() != -1) { break; }
            }
            //If an incorrect number or text is entered, it will give an error and ask to be entered again.

            if (playerCards[chosen].getValue() == lastCard.getValue() || playerCards[chosen].getValue() == 11) {
                //If the value of the index selected is the same as the last card, it enters this block.(or joker)
                boardCards[boardCounter].copyCard(playerCards[chosen]);   //The selected card is thrown onto the table.
                boardCounter++;
                playerCards[chosen].setValue(-1);
                playerPointMethod();     //How many points will be counted and added before the cards on the table are collected.
                lastWinner = "player";   //If there is no winner after that, the player will take the remaining cards on the table.

                for (int j = 0; j < boardCounter; j++) {
                    playerAll[playerAllCounter + j].copyCard(boardCards[j]);
                    boardCards[j].setValue(0);
                    turnCounter++;
                    //Cards are removed from the table and value of empty indexes is changed.
                }
                boardCounter = 0;
                playerAllCounter += turnCounter;
                turnCounter = 0;

            } else {
                //If the value of the selected index is not equal to the last card, the block it will enter.
                boardCards[boardCounter].copyCard(playerCards[chosen]);
                lastCard.copyCard(playerCards[chosen]);
                boardCounter++;
                playerCards[chosen].setValue(-1);
            }

        }
    }

    public void lastCardsOnTheTable() {
        if (lastWinner.equals("player")) {
            playerPointMethod();
        }
        if (lastWinner.equals("computer")) {
            computerPointMethod();
        }

        if (playerAllCounter > computerAllCounter) {
            playerPoint += 3;
        }
        if (computerAllCounter > playerAllCounter) {
            computerPoint += 3;
        }
        //Method that checks who wins last. Prints the score of the remaining cards on the table to the last winner.
        //It also detects who has the most cards and adds 3 point.

    }

    public void playerPointMethod() {

        if (boardCounter == 2 && boardCards[0].getValue() == boardCards[1].getValue()) {
            playerPoint += 10;
        }
        for (int i = 0; i < boardCounter; i++) {
            if (boardCards[i].getValue() == 2 && boardCards[i].getSymbol().equals("♣")) {
                playerPoint += 1;
            }
            if (boardCards[i].getValue() == 10 && boardCards[i].getSymbol().equals("♦")) {
                playerPoint += 2;
            }
            playerPoint += 1;
        }
        //Method that calculates all scoring for player.
    }


    public void computerPointMethod() {

        if (boardCounter == 2 && boardCards[0].getValue() == boardCards[1].getValue()) {
            computerPoint += 10;
        }
        for (int i = 0; i < boardCounter; i++) {
            if (boardCards[i].getValue() == 2 && boardCards[i].getSymbol().equals("♣")) {
                computerPoint += 1;
            }
            if (boardCards[i].getValue() == 10 && boardCards[i].getSymbol().equals("♦")) {
                computerPoint += 2;
            }
            computerPoint += 1;
        }
        //Method that calculates all scoring for computer.
    }

    public int getPlayerPoint() {
        return this.playerPoint;
    }

    public int getComputerPoint() {
        return this.computerPoint;
    }




}





