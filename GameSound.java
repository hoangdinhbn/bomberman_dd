 package SOUND;

import java.applet.Applet;
import java.applet.AudioClip;
//import java.util.HashMap;

public class GameSound {
//	public static GameSound instance;

        public static final AudioClip LOSE = Applet.newAudioClip(GameSound.class.getResource("lose.mid"));
        public static final AudioClip PLAYGAME = Applet.newAudioClip(GameSound.class.getResource("playgame.mid"));
        public static final AudioClip BOMB = Applet.newAudioClip(GameSound.class.getResource("Bonus.mid"));
        public static final AudioClip BOMBER_DIE = Applet.newAudioClip(GameSound.class.getResource("Die.mid"));
        public static final AudioClip BONG_BANG  = Applet.newAudioClip(GameSound.class.getResource("Explosion.mid"));
       
//	public static final String PLAYGAME = "playgame.mid";
//	public static final String BOMB = "Bonus.mid";
//	public static final String BOMBER_DIE = "Die.mid";
//	public static final String BONG_BANG = "Explosion.mid";
//	public static final String LOSE = "lose.mid";
//	private HashMap<String, AudioClip> audioMap;
//
//	public GameSound() {
//		audioMap = new HashMap<>();
//		loadAllAudio();
//	}
//
//	public static GameSound getIstance() {
//		if (instance == null) {
//			instance = new GameSound();
//		}
//
//		return instance;
//	}
//
//	public void loadAllAudio() {
//
//		putAudio(PLAYGAME);
//		putAudio(BOMB);
//
//		putAudio(BOMBER_DIE);
//		putAudio(BONG_BANG);
//
////		putAudio(WIN);
//		putAudio(LOSE);
//	}
//
//	public void stop() {
//
//		getAudio(PLAYGAME).stop();
//		getAudio(BOMB).stop();
//		getAudio(BONG_BANG).stop();
////		getAudio(WIN).stop();
//		getAudio(LOSE).stop();
//	}
//
//	public void putAudio(String name) {
//		AudioClip auClip = Applet.newAudioClip(GameSound.class.getResource(name));
//		audioMap.put(name, auClip);
//	}
//
//	public AudioClip getAudio(String name) {
//		return audioMap.get(name);
//	}
}
