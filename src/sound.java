
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class sound {
	
	
	private  File sound1 = new File(new File("").getAbsolutePath() + "\\1.wav");
	
	
	public void jump() {
		 try {
	            AudioInputStream ais = AudioSystem.getAudioInputStream(sound1);
	            Clip c = AudioSystem.getClip();
	            c.open(ais); //Clip opens AudioInputStream
	            c.start(); //Start playing audio

	            //sleep thread for length of the song
	            Thread.sleep((int)(c.getMicrosecondLength() * 0.001));
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	
	
	public void pickMask() {
		
	}
	
	
	
	public void pickVac() {
		
	}
	
	
	public void start() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
