package Game.IA;

import Game.IA.AlgoReactToContext.AlgoReactToContext;
import Game.Player.Element.Element;

public class IaTimid extends Ia {

    public IaTimid(Element element) {
        setName(getClass().getSimpleName());
        setElement(element);
    }

    @Override
    public void reactToContext(AlgoReactToContext algoReactToContext) {
        algoReactToContext.reactToContext(this);

    }
}
