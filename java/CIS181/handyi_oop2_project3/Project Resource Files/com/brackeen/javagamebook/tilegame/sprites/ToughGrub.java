package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;

// A ToughGrub is a Grub that takes 3 hits to die instead of 1.
public class ToughGrub extends Grub {

    public ToughGrub(Animation left, Animation right,
        Animation deadLeft, Animation deadRight)
    {
        super(left, right, deadLeft, deadRight);
        health = 3;
    }
}
