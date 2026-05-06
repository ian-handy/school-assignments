package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

// A SpeedyFly is a Fly that flies 4 times faster than a normal Fly.
public class SpeedyFly extends Fly {

    public SpeedyFly(Animation left, Animation right,
        Animation deadLeft, Animation deadRight)
    {
        super(left, right, deadLeft, deadRight);
    }

    public float getMaxSpeed() {
        return 0.8f * enemySpeedMultiplier;
    }
}
