package edu.buet.cse.spring.ch12.v4.listener;

import edu.buet.cse.spring.ch12.v4.model.Tweet;

public class TweetListener {
  public void tweetReceived(Tweet tweet) {
    System.out.printf("The received tweet is : %s%n", tweet);
  }
}
