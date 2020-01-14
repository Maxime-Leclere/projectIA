package Game.Player.Element;

public class GameElement {
    static Element feu   = new Element("Feu", GameElement.eau, GameElement.air);
    static Element eau   = new Element("Eau", GameElement.air, GameElement.feu);
    static Element air   = new Element("Air", GameElement.feu, GameElement.terre);
    static Element terre = new Element("Terre", GameElement.terre, GameElement.eau);

    public static Element getFeu() {
        return feu;
    }

    public static Element getEau() {
        return eau;
    }

    public static Element getAir() {
        return air;
    }

    public static Element getTerre() {
        return terre;
    }
}
