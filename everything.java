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
        public int playerPoint;
        public int computerPoint;
        public int turnCounter;
        public int boardCounter;
        public int playerAllCounter;
        public int computerAllCounter;



        public everything() {
            newDeck = new card[52];
            firstPart = new card[52];
            secondPart = new card[52];
            readyDeck = new card[52];
            playerCards = new card[4];
            computerCards = new card[4];
            boardCards = new card[52];
            playerAll = new card[52];
            computerAll = new card[52];
            playerPoint = 0;
            computerPoint = 0;
            turnCounter = 0;
            boardCounter = 4;
            playerAllCounter = 0;
            computerAllCounter = 0;


            for(int i=0;i<13;i++) {
                card spadeCards = new card(i+1,"spade");
                newDeck[i] = spadeCards;
            }
            for(int i=13;i<26;i++) {
                card heartCards = new card(i-12,"heart");
                newDeck[i] = heartCards;
            }
            for(int i=26;i<39;i++) {
                card diamondCards = new card(i-25,"diamond");
                newDeck[i] = diamondCards;
            }
            for(int i=39;i<52;i++) {
                card clubCards = new card(i-38,"club");
                newDeck[i] = clubCards;
            }
            //It creates the deck.


        }

        public void shuffleDeck() {
            Random r = new Random();
            for(int i=0;i<newDeck.length;i++) {
                int firstplace = r.nextInt(52);
                int secondplace = r.nextInt(52);

                card number = newDeck[firstplace];
                newDeck[firstplace] = newDeck[secondplace];
                newDeck[secondplace] = number;
            }
            //It shuffles the deck.
        }


        public void cutDeck() {
            Random r = new Random();
            int cutNo = r.nextInt(51);
            System.arraycopy(newDeck,0,secondPart,0,cutNo);
            System.arraycopy(newDeck,cutNo,firstPart,0,newDeck.length-cutNo);
            System.arraycopy(firstPart,0,readyDeck,0,newDeck.length-cutNo);
            System.arraycopy(secondPart,0,readyDeck,(newDeck.length-cutNo),cutNo);




        }

        public void firstMoveCards() {

            for(int i=0;i<8;i+=2) {
                computerCards[i/2] = readyDeck[i];
                playerCards[i/2] = readyDeck[i+1];
            }
            for(int i=0;i<4;i++) {
                boardCards[i] = readyDeck[i+8];
                lastCard = boardCards[i];
            }
        }

        public void secondMoveCards() {
            for(int i=12;i<20;i+=2) {
                computerCards[(i-12)/2] = readyDeck[i];
                playerCards[(i-12)/2] = readyDeck[i+1];
            }
        }
        public void thirdMoveCards() {
            for(int i=20;i<28;i+=2) {
                computerCards[(i-20)/2] = readyDeck[i];
                playerCards[(i-20)/2] = readyDeck[i+1];
            }
        }
        public void fourthMoveCards() {
            for(int i=28;i<36;i+=2) {
                computerCards[(i-28)/2] = readyDeck[i];
                playerCards[(i-28)/2] = readyDeck[i+1];
            }
        }
        public void fifthMoveCards() {
            for(int i=36;i<44;i+=2) {
                computerCards[(i-36)/2] = readyDeck[i];
                playerCards[(i-36)/2] = readyDeck[i+1];
            }
        }
        public void sixthMoveCards() {
            for(int i=44;i<52;i+=2) {
                computerCards[(i-44)/2] = readyDeck[i];
                playerCards[(i-44)/2] = readyDeck[i+1];
            }
        }

        public void gameMethod() {
            Random r = new Random();
            Scanner sc = new Scanner(System.in);

            for(int i=0;i<4;i++) {

                for(int k=0;k<4;k++) {


                    if(computerCards[i].value==lastCard.value||computerCards[i].value==11) {


                        boardCards[boardCounter] = computerCards[i];
                        boardCounter++;
                        computerCards[i].value = 0;
                        computerPointMethod();

                        for(int j=0;j<boardCounter;j++) {
                            computerAll[computerAllCounter+j] = boardCards[j];
                            boardCards[j].value = 0;
                            turnCounter++;

                        }
                        boardCounter = 0;
                        computerAllCounter+=turnCounter;
                        turnCounter = 0;
                        lastCard.value = 0;

                    }

                }

                int x = r.nextInt(computerCards.length);
                while(computerCards[x].value==0) {
                    x = r.nextInt(computerCards.length);
                    if(computerCards[x].value!=0)
                        break;

                    boardCards[boardCounter] = computerCards[x];
                    lastCard = computerCards[x];
                    boardCounter++;

                }

                System.out.println("Choose a number to play your card 0,1,2 or 3.");
                int chosen = sc.nextInt();
                while(playerCards[chosen].value==0) {
                    System.out.println("You used this card please choose another card.Do not choose this number until the cards are dealt again.");
                    chosen = sc.nextInt();
                    if (playerCards[chosen].value!=0) {
                        break;
                    }
                }


                if (playerCards[chosen].value==lastCard.value||playerCards[chosen].value==11) {
                    boardCards[boardCounter] = playerCards[chosen];
                    boardCounter++;
                    playerCards[chosen].value = 0;
                    playerPointMethod();

                    for(int j=0;j<boardCounter;j++) {
                        playerAll[playerAllCounter+j] = boardCards[j];
                        boardCards[j].value = 0;
                        turnCounter++;
                    }
                    boardCounter = 0;
                    playerAllCounter+=turnCounter;
                    turnCounter = 0;
                }


                else {
                    boardCards[boardCounter] = playerCards[chosen];
                    lastCard = playerCards[chosen];
                    boardCounter++;
                    playerCards[chosen].value = 0;
                }

            }
        }

        public void playerPointMethod() {

            if(boardCounter==2) {
                playerPoint+=10;
            }
            for(int i=0;i<boardCounter;i++) {
                if (boardCards[i].value==2&&boardCards[i].name.equals("Club")) {
                    playerPoint+=1;
                }
                if (boardCards[i].value==10&&boardCards[i].name.equals("Diamond")) {
                    playerPoint+=2;
                }
                playerPoint+=1;
            }

        }
        public void computerPointMethod() {

            if(boardCounter==2) {
                computerPoint+=10;
            }
            for(int i=0;i<boardCounter;i++) {
                if (boardCards[i].value==2&&boardCards[i].name.equals("Club")) {
                    computerPoint+=1;
                }
                if (boardCards[i].value==10&&boardCards[i].name.equals("Diamond")) {
                    computerPoint+=2;
                }
                computerPoint+=1;
            }
        }



    }




