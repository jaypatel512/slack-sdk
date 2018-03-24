package com.jaypatel512.slack;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true, fluent = true)
public class SlackMessage {

  private String text;
  private String channel;
  private String username;
  @SerializedName("mrkdwn")
  private Boolean markdown;
  private List<SlackAttachment> attachments;

  public SlackMessage addAttachment(SlackAttachment attachment) {
    if (attachments == null) {
      attachments = new ArrayList<>();
    }
    attachments.add(attachment);
    return this;
  }
}
