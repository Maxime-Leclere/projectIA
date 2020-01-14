package Game.Player;

import Game.Player.Element.Element;

public abstract
class Player {
    private String name;
    private double life = 100;
    private int attack = 10;
    private Element element;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLife() {
        return life;
    }

    public void setLife(double life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    private double calculAttackElement(int val) {
        if (val == 1)return getAttack()*(1 + getElement().getPourcentage());
        else if (val == -1)return getAttack()*(1 - getElement().getPourcentage());
        return getAttack();
    }

    public double calculAttackPlayer(Player player){
        if (player.getElement() == this.getElement().getFaiblesse())return calculAttackElement(-1);
        else if (player.getElement() == this.getElement().getAvantage()) return calculAttackElement(1);
        else return calculAttackElement(0);
    }

    public void damagePlayer(Player player) {
       player.setLife(player.getLife() - (int)calculAttackPlayer(player));
    }

    @Override
    public String toString() {
        return "Nom : "+ getName() + "\n" +
                "Vie : " + getLife() + "\n" +
                "Attaque : "+ getAttack() + "\n" +
                "Element : "+ getElement().getName() + "\n";
    }
}
