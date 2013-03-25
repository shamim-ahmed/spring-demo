package edu.buet.cse.spring.di;

import org.junit.Test;
import static org.mockito.Mockito.*;

import edu.buet.cse.spring.di.impl.BraveKnight;
import edu.buet.cse.spring.di.model.Knight;
import edu.buet.cse.spring.di.model.Quest;

public class AppTest {
  @Test
  public void testQuest() {
	Quest quest = mock(Quest.class);
	Knight knight = new BraveKnight(quest);
	knight.embarkOnQuest();
	verify(quest, times(1)).embark();
  }
}
