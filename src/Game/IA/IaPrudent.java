package Game.IA;

import Game.IA.AlgoReactToContext.AlgoReactToContext;
import Game.Player.Element.Element;

public class IaPrudent extends Ia {

    public IaPrudent(Element element) {
        setName(getClass().getName());
        setElement(element);
    }

    @Override
    public void reactToContext(AlgoReactToContext algoReactToContext) {
        algoReactToContext.reactToContext(this);
    }
}
