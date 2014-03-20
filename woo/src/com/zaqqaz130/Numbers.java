package com.zaqqaz130;

import java.util.Random;

public class Numbers {
	
public Random rand;
public int numOne, numTwo, numSum;
public float woof = 22.2f;

public int genNums() {
	
	rand = new Random();
	numOne = rand.nextInt(11);
	numTwo = rand.nextInt(11);
	numSum = numOne + numTwo;
	
	return numSum;
}

public boolean soo() {
	if (woof == 22.2f) {
	return true;
}
else {return false;}
}

}
