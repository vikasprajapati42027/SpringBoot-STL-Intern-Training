package com.phoenix.di.performers;
/*
 * @author : vikas.prajapati@stltech.in
 * @version 0.1
 * @Date 29-07-2021
 * @copyright Sterlite Technology Ltd.
 * 
 */

import com.phoenix.di.instuments.Instument;

import javax.sound.midi.Instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Pyaare_Raghav")
public class Instumentalist implements Performer {

	@Autowired
	 private Instument instument;
	 
	 @Value("Awara hu.....")
	 private String song;
	 
	@Override
	public void perform() {
		// TODO Auto-generated method stub
          System.out.println("Instrumentalist is playing a song.. "+song);
       instument.play();
	}
	
	

}
