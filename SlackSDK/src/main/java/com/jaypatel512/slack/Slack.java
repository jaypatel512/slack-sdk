package com.jaypatel512.slack;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Slack {

  private String url;

  public String send(SlackMessage slackMessage) throws SlackException {
    return "true";
  }

}
