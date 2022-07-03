package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {
    private static final int MOVEMENT = 100;
    private static final int GRAVITY = -15;
    private final Vector3 position;
    private final Vector3 velosity;
    private final Rectangle bounds;
    private final Animation birdAnimation;

    private final Texture texture;

    public Bird(int x, int y){
        position = new Vector3(x, y, 0);
        velosity = new Vector3(0, 0, 0);

        texture = new Texture("birdanimation.png");
        birdAnimation = new Animation(new TextureRegion(texture), 3, .5f);
        bounds = new Rectangle(x, y, texture.getWidth() / 3f, texture.getHeight());
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getBird() {
        return birdAnimation.getFrame();
    }

    public void update(float dt) {
        birdAnimation.update(dt);
        if (position.y > 0)
            velosity.add(0, GRAVITY, 0);
        velosity.scl(dt);
        position.add(MOVEMENT * dt, velosity.y, 0);
        if (position.y < 0)
            position.y = 0;

        velosity.scl(1 / dt);
        bounds.setPosition(position.x, position.y);


    }
    public void jump(){
        velosity.y = 250;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void dispose() {
        texture.dispose();
    }
}
