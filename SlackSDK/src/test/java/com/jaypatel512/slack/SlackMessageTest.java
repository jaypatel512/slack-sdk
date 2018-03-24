package com.jaypatel512.slack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SlackMessageTest {

  @Test
  public void setters_setsValues() {
    SlackField slackField = new SlackField()
        .title("Title");
    SlackAttachment attachment = new SlackAttachment()
        .authorName("Author Name")
        .addField(slackField);

    SlackMessage slackMessage = new SlackMessage().text("Hello").addAttachment(attachment);

    assertNotNull(slackMessage);
    assertEquals("Hello", slackMessage.text());
    assertNotNull(slackMessage.attachments());
    assertEquals(1, slackMessage.attachments().size());

    SlackAttachment actualAttachment = slackMessage.attachments().get(0);

    assertNotNull(actualAttachment);
    assertNotNull(actualAttachment.fields());
    assertEquals(1, actualAttachment.fields().size());

    SlackField actualField = actualAttachment.fields().get(0);

    assertNotNull(actualField);
    assertEquals("Title", actualField.title());
  }

  @Test
  public void addAttachment_addsAttachment() {
    SlackMessage message = new SlackMessage();
    SlackAttachment attachment = new SlackAttachment();

    assertNull(message.attachments());

    message.addAttachment(attachment);

    assertNotNull(message.attachments());
    assertEquals(1, message.attachments().size());
    assertEquals(attachment, message.attachments().get(0));
  }

  @Test
  public void gson_serializesCorrectly() {
    Slack slack = Slack.builder("https://localhost")
        .build();

    SlackMessage slackMessage = new SlackMessage().markdown(true);

    assertEquals(true, slackMessage.markdown());
    assertEquals("{\"mrkdwn\":true}", slack.getGson().toJson(slackMessage));
  }
}
