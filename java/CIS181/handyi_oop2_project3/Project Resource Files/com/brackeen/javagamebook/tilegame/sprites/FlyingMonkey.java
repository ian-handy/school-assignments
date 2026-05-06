package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;
import com.brackeen.javagamebook.util.RandomUtil;
import com.brackeen.javagamebook.codereflection.*;

/**
 * ZigZagFly is an aerial enemy with a unique movement pattern.
 * Key differences from regular Fly:
 * - Moves in a zigzag/wave-like pattern in addition to horizontal movement
 * - Uses vertical movement (setVelocityY) to create diagonal swooping motions
 * - Faster horizontal speed (0.3f instead of 0.2f)
 * - Less predictable and more challenging to avoid
 */
public class FlyingMonkey extends Creature {

	private static final int MILLI_PER_SECOND = 1000; 
	private long initJumpInterval = 1 * MILLI_PER_SECOND; 
	private long jumpInterval = initJumpInterval;
	
	public FlyingMonkey(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
		super(left, right, deadLeft, deadRight);

		this.jumpSpeed = -0.65f;
		this.trackPlayer=true;
	}

	public float getMaxSpeed() {
		return 0.3f * enemySpeedMultiplier;  // Faster than Fly's 0.2f
	}

	public void update(long elapsedTime) {
		super.update(elapsedTime);
		
		if((totalElapsedTime % jumpInterval)-elapsedTime<0){
			//Make the monkey jump if he's not already in the air
			jump(true);
			int variation = RandomUtil.getRandomInt(200);
			jumpInterval = initJumpInterval + variation;
		}
		else if (isOnGround())
			jump(true);
		

		if(getY()<-400)
			jumpInterval+=400;
		
		
	}
}
