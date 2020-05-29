/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slickgame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import slickgame.states.GameMenuSate;
import slickgame.states.GameAreaState;

/**
 *
 * @author Joaov
 */
public class SlickGame extends StateBasedGame {

    /**
     * Start
     *
     * @param args the command line arguments
     * @throws org.newdawn.slick.SlickException
     */
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new SlickGame("Hello"));
        app.setDisplayMode(GameProps.width(), GameProps.height(), GameProps.fullscreen());
        app.setAlwaysRender(true);

        app.start();
    }

    public SlickGame(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        for (var st : new GameState[]{new GameMenuSate(), new GameAreaState()}) {
            this.addState(st);
        }
    }

}
