package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

// A JumpyGrub is a Grub that jumps every 2 seconds.
public class JumpyGrub extends Grub {

    private long jumpInterval = 2000;
    private long timeSinceJump = 0;

    public JumpyGrub(Animation left, Animation right,
        Animation deadLeft, Animation deadRight)
    {
        super(left, right, deadLeft, deadRight);
        jumpSpeed = -0.7f;
    }

    public void update(long elapsedTime) {
        super.update(elapsedTime);
        timeSinceJump += elapsedTime;
        if (timeSinceJump >= jumpInterval) {
            jump();
            timeSinceJump = 0;
        }
    }
}
