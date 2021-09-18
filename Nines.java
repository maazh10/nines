import java.util.Scanner;
/**
 * Write a description of class Nines here.
 * 
 * @author Maaz Hashmi
 */
public class Nines
{
    private static int playerRolls = 0;
    private static int pScore = 0;
    private static int cScore = 0;
    
    public static void main(String args[]) {
        // start the game with player's turn when instructed
        System.out.print("Type ROLL to start your turn. ");
        Scanner playerTurn = new Scanner(System.in);
        String start = playerTurn.nextLine();
        if("roll".equals(start) || "Roll".equals(start) || "ROLL".equals(start)) {
            System.out.println();
            playerRoll();
        }
        
        System.out.println();
        
        // continue with computer's turn when instructed
        System.out.print("Type ROLL to continue. ");
        Scanner computerTurn = new Scanner(System.in);
        String go = computerTurn.nextLine();
        if("roll".equals(go) || "Roll".equals(go) || "ROLL".equals(go)) {
            System.out.println();
            computerRoll();
        }
        
        System.out.println();
        
        // print out the winner based on score
        calculateScore();
    }
    
    public static void playerRoll() {
        // start off with two random rolls and add them to player's score
        int pRoll1 = roll();
        int pRoll2 = roll();
        System.out.println("Your first roll was " + pRoll1 + ". Your second roll was " + pRoll2 + ".");
        pScore = pRoll1 + pRoll2;
        
        // subtract 9 if score exceeds 9
        if(pScore > 9) {
            pScore = pScore - 9;
        }
        
        // print out the score
        System.out.println("You score is " + pScore + ". ");
        
        int pExtraRolls = 0;
        
        // ask if the player wants to roll again, 5 times or until they say no
        while(pExtraRolls < 5) {
            System.out.print("Do you want another roll? (Y/N)  ");
            Scanner s = new Scanner(System.in);
            String answer = s.nextLine();
            if("Y".equals(answer) || "y".equals(answer)) {
                // if they want an extra roll, roll a new die and add it to score
                int pr = roll();
                pScore = pScore + pr;
                // subtract 9 if score exceeds 9
                if(pScore > 9) {
                    pScore = pScore - 9;
                }
                // print out the result of the additional roll and the new score
                System.out.println("Your roll was " + pr + ". Your score is " + pScore + ". ");
                // keep track of the extra rolls, the player took for the computer's turn
                playerRolls++;
            }
            if("N".equals(answer) || "n".equals(answer)) {
                // if they refuse to roll again print the score and stop the loop
                System.out.println("Your score is " + pScore + ". ");
                pExtraRolls = 5;
            }
            pExtraRolls++;
        }

    }
    
    public static void computerRoll() {
        // start off with two random rolls and add them to computer's score
        int cRoll1 = roll();
        int cRoll2 = roll();
        System.out.println("The computer's first roll was " + cRoll1 + ". The computer's second roll was " + cRoll2 + ".");
        cScore = cRoll1 + cRoll2;
        
        // subtract 9 if score exceeds 9
        if(cScore > 9) {
            cScore = cScore - 9;
        }
        
        // print out the score
        System.out.println("Computer's score is " + cScore + ". ");

        int cExtraRolls = 0;
        // roll additional dice for the computer that matches the number of additional rolls
        // of the player
        while(cExtraRolls < playerRolls) {
            // roll a new die and add it to score
            int cr = roll();
            cScore = cScore + cr;
            // subtract 9 if score exceeds 9
            if(cScore > 9) {
                cScore = cScore - 9;
            }
            // print out the result of the additional roll and the new score
            System.out.println("Computer's roll was " + cr + ". Computer's score is " + cScore + ". ");
            cExtraRolls++;
        }
    }
    
    public static void calculateScore() {
        // print out the final scores
        System.out.println("Your score was " + pScore + ". Computer's score was " + cScore + ". ");
        // print out the winner depending on who got the higher score
        if(pScore > cScore) {
            System.out.print("YOU WIN!");
        } else if(cScore > pScore) {
            System.out.print("COUMPUTER WINS!");
        } else if (pScore == cScore) {
            System.out.print("IT'S A TIE!");
        }
        System.exit(0);
    }
    
    public static int roll() {
        // "roll a die" 
        // return a random number between 1 to 6 whenever called
        int roll = (int)(Math.random()*6)+1;
        return roll;
    }
}
