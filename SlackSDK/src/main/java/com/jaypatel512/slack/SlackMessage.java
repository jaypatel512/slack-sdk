package com.jaypatel512.slack;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true, fluent = true)
public class SlackMessage {

  private String text;
  private List<SlackAttachment> attachments;

  public SlackMessage addAttachment(SlackAttachment attachment) {
    if (attachments == null) {
      attachments = new ArrayList<>();
    }
    attachments.add(attachment);
    return this;
  }
}
