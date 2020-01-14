package Game.Fight;

import Game.Player.Player;

public class Fight {
    private Player user;
    private Player playerAdvers;
    private Player playerCurrent;
    private Player playerNoCurrent;
    private boolean running = true;

    private int round = 0;

    public Fight(Player player, Player playerAdvers) {
        setUser(player);
        setPlayerAdvers(playerAdvers);
        setPlayerCurrent(player);
        setPlayerNoCurrent(playerAdvers);
    }

    public void stopFight() {
        setRunning(false);
        System.out.println("Le combat est terminer!!!!");
    }

    public String toStringRound() {
        return "Tour : " + getRound() + "\n" +
                "Joueur Courrant : " + getPlayerCurrent().toString() + "\n" +
                "Joueur : " + getUser() + "\n" +
                "Joueur Adverse : " + getPlayerAdvers() + "\n";
    }

    public void nextRound() {
        ++round;
        changePlayerCurrent();
        System.out.println(toString());
    }

    public void changePlayerCurrent() {
        if (getPlayerCurrent() == getUser()) {
            setPlayerCurrent(getPlayerAdvers());
            setPlayerNoCurrent(getUser());
        }
        else {
            setPlayerCurrent(getUser());
            setPlayerNoCurrent(getPlayerAdvers());
        }
    }

    public Player getPlayerCurrent() {
        return playerCurrent;
    }

    public void setPlayerCurrent(Player playerCurrent) {
        this.playerCurrent = playerCurrent;
    }

    public Player getUser() {
        return user;
    }

    public Player getPlayerAdvers() {
        return playerAdvers;
    }

    public int getRound() {
        return round;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setUser(Player user) {
        this.user = user;
    }

    public void setPlayerAdvers(Player playerAdvers) {
        this.playerAdvers = playerAdvers;
    }

    public void setPlayerNoCurrent(Player playerNoCurrent) {
        this.playerNoCurrent = playerNoCurrent;
    }

    public Player getPlayerNoCurrent() {
        return playerNoCurrent;
    }

    public void checkPointLife(){
        if (getPlayerCurrent().getLife() <= 0) {
            System.out.println("Le joueur "+ getPlayerCurrent().getName() +" n'a plus de point de vie");
            stopFight();
        }
        else if (getPlayerNoCurrent().getLife() <= 0) {
            System.out.println("Le joueur "+ getPlayerNoCurrent().getName() +" n'a plus de point de vie");
            stopFight();
        }
    }

    @Override
    public String toString() {
        return "Tour : " + getRound() + "\n" +
                "Joueur : " + getUser().toString() + "\n" +
                "Joueur Adverse: " + getPlayerAdvers().toString() + "\n";
    }
}
