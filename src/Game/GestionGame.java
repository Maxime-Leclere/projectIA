package Game;

import Game.Fight.Fight;
import Game.IA.IaTimid;
import Game.Player.Element.GameElement;
import Game.Player.Player;
import Game.Player.User.Human;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GestionGame {

    public static String menu(Fight fight) {
        if (fight.getPlayerCurrent().getClass() == Human.class) {
            String choix = "";
            System.out.println("Attaque\nFuite\nTaper le choix de votre action");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {
                choix =  String.valueOf(in.readLine());
            } catch (IOException e) {
                System.out.println("Problème de saisie");
            }
            return choix;
        }
        return "L'IA choisi une action";
    }

    static void executeAction(Fight fight, String action) {
        switch (action) {
            case "attaque":
                fight.getPlayerCurrent().damagePlayer(fight.getPlayerNoCurrent());
                System.out.println("Le joueur " + fight.getPlayerCurrent().getName() + " attaque " +
                        fight.getPlayerNoCurrent() + " et " + fight.getPlayerNoCurrent().getName() + " subit " +
                        fight.getPlayerCurrent().calculAttackPlayer(fight.getPlayerCurrent()) + " de point de vie");
                break;
            case "fuite":
                System.out.println("le Joueur " + fight.getPlayerCurrent().getName() + " a pris la fuite");
                fight.stopFight();
                break;
            default:
                break;
        }
        fight.checkPointLife();
        fight.nextRound();
    }

    public static void main(String[] args) {
        Player user = new Human("max", GameElement.getFeu());
        Player userAdver = new IaTimid(GameElement.getAir());
        Fight fight = new Fight(user, userAdver);
        System.out.println("Le combat commence!!!\n"+fight.toString());

        while (fight.isRunning()) {
            executeAction(fight, menu(fight));
        }

    }
}
