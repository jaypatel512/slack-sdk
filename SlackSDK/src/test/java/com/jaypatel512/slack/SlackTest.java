package com.jaypatel512.slack;

import org.junit.Assert;
import org.junit.Test;

public class SlackTest {

  @Test
  public void builder_setsUrl() {
    Slack slack = Slack.builder()
        .url("https://localhost")
        .build();

    Assert.assertEquals("https://localhost", slack.getUrl());
  }

}
