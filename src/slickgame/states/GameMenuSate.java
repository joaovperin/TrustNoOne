/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slickgame.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 *
 * @author Joaov
 */
public class GameMenuSate extends BasicGameState {

    private Circle mouseBall;
    private boolean isMousePressed;
    private boolean mouseWasPressed;
    private Image canvasBkp;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        mouseBall = new Circle(10, 10, 20);
        canvasBkp = new Image(800, 600);
        mouseWasPressed = false;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawImage(canvasBkp, 0, 0);
        g.setColor(Color.black);
        g.drawString("oi", 50, 50);

        if (isMousePressed) {
            g.setColor(Color.red);
            g.fill(mouseBall);
            if (mouseWasPressed) {
                g.copyArea(canvasBkp, 0, 0);
            }
        } else {
            g.setColor(Color.yellow);
            g.fill(mouseBall);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        final Input input = container.getInput();

        if (input.isKeyPressed(Input.KEY_1)) {
            game.enterState(1, new FadeOutTransition(), new FadeInTransition());
            return;
        }
        mouseBall.setCenterX(input.getMouseX());
        mouseBall.setCenterY(input.getMouseY());

        boolean pressingMouse = input.isMouseButtonDown(0);
        if ((pressingMouse && !isMousePressed) || (!pressingMouse && isMousePressed)) {
            mouseWasPressed = !mouseWasPressed;
        }
        isMousePressed = pressingMouse;
    }

}
