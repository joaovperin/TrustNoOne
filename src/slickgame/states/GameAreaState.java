/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slickgame.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Joaov
 */
public class GameAreaState extends BasicGameState {

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawString("hehehehe", 50, 50);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    }

}
