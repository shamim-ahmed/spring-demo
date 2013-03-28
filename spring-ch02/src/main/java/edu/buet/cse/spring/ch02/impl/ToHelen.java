package edu.buet.cse.spring.ch02.impl;

import edu.buet.cse.spring.ch02.model.Poem;

public class ToHelen implements Poem {
  private static final String[] LINES = { "Helen, thy beauty is to me", "Like those Nicean barks of yore",
      "That gently, o'er a perfumed sea,", "The weary, way-worn wanderer bore", "To his own native shore.",
      "On desperate seas long wont to roam,", "Thy hyacinth hair, thy classic face,",
      "Thy Naiad airs have brought me home", "To the glory that was Greece,", "And the grandeur that was Rome.",
      "Lo, in yon brilliant window-niche", "How statue-like I see thee stand,", "The agate lamp within thy hand,",
      "Ah! Psyche, from the regions which", "Are Holy Land!" };

  @Override
  public void recite() {
    for (String line : LINES) {
      System.out.println(line);
    }
  }
}
