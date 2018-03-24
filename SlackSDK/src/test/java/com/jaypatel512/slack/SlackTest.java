package com.jaypatel512.slack;

import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import org.junit.Test;

public class SlackTest {

  @Test
  public void builder_setsUrl() {
    Slack slack = Slack.builder("https://localhost")
        .build();

    assertEquals("https://localhost", slack.getUrl());
  }

  @Test
  public void builder_setsDefaultProxy_ifNotProvided() {
    Slack slack = Slack.builder("https://localhost")
        .build();

    assertNotNull(slack.getProxy());
    assertEquals(Proxy.NO_PROXY, slack.getProxy());
  }

  @Test
  public void builder_setsProxy() {
    Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(123));
    Slack slack = Slack.builder("https://localhost")
        .proxy(proxy)
        .build();

    assertEquals(proxy, slack.getProxy());
  }

  @Test
  public void builder_setsDefaultGson_ifNotProvided() {
    Slack slack = Slack.builder("https://localhost")
        .build();

    assertNotNull(slack.getGson());
    assertEquals(false, slack.getGson().serializeNulls());
    assertEquals(LOWER_CASE_WITH_UNDERSCORES, slack.getGson().fieldNamingStrategy());
  }

  @Test
  public void builder_setsGson() {
    Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(123));
    Slack slack = Slack.builder("https://localhost")
        .proxy(proxy)
        .build();

    assertEquals(proxy, slack.getProxy());
  }

  @Test
  public void builder_setsDefaultTimeout_ifNotProvided() {
    Slack slack = Slack.builder("https://localhost")
        .build();

    assertNotNull(slack.getGson());
    assertEquals(5000, slack.getTimeout());
  }

  @Test
  public void builder_setsTimeout() {
    Slack slack = Slack.builder("https://localhost")
        .timeout(10)
        .build();

    assertEquals(10, slack.getTimeout());
  }
}
