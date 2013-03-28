package edu.buet.cse.spring.ch02.spel;

import java.util.Random;

public class SongSelector {
  private static final String[] SONGS = { "Lost in Love", "All Out of Love", "Goodbye", "Sweet Dreams" };
  private final Random randomGenerator = new Random();

  public String selectSong() {
    return SONGS[randomGenerator.nextInt(SONGS.length)];
  }
}
