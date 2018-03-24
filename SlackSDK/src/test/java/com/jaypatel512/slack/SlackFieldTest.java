package com.jaypatel512.slack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SlackFieldTest {

  @Test
  public void gson_serializesCorrectly() {
    Slack slack = Slack.builder("https://localhost")
        .build();

    SlackField slackField = new SlackField()
        .shorten(true);

    assertEquals(true, slackField.shorten());
    assertEquals("{\"short\":true}", slack.getGson().toJson(slackField));
  }
}
