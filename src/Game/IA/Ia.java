package Game.IA;

import Game.IA.AlgoJudgeContext.AlgoJudgeContext;
import Game.IA.AlgoReactToContext.AlgoReactToContext;
import Game.Player.Player;

public abstract class Ia extends Player {
    private AlgoJudgeContext algoJudgeContext;
    /*
        3 situation possible : favorable = 1, neutre = 0, defavorable = -1
     */
    public int judgeContext() {
        return getAlgoJudgeContext().judgeContext(this);
    }

    public abstract void reactToContext(AlgoReactToContext algoReactToContext);

    public AlgoJudgeContext getAlgoJudgeContext() {
        return algoJudgeContext;
    }

    public void setAlgoJudgeContext(AlgoJudgeContext algoJudgeContext) {
        this.algoJudgeContext = algoJudgeContext;
    }
}
