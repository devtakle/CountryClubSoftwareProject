package com.ssdi.utilities;

import java.util.Random;

public class TokenGenerator implements ITokenGenerator {

	@Override
	public String genereateToken() {
			String token = null;
	/*		generating  5 digit token*/
			Random rand = new Random();
			int  randomNumber = rand.nextInt(99999) + 10000;
			//System.out.println("****random number "+Integer.toString(randomNumber));
			token = Integer.toString(randomNumber);
			return token;
		}
	}


