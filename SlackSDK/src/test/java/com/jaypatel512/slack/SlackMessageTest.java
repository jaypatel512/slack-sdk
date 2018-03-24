package com.jaypatel512.slack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import java.util.Date;
import org.junit.Test;

public class SlackMessageTest {

  @Test
  public void setters_setsAllValues() {
    SlackField slackField = new SlackField();
    slackField.title("Priority");
    slackField.value("High");
    slackField.shorten(false);

    SlackAttachment attachment = new SlackAttachment();
    attachment.fallback("Required plain-text summary of the attachment.")
        .color("#36a64f")
        .pretext("Optional text that appears above the attachment block")
        .authorName("Bobby Tables")
        .authorLink("http://flickr.com/bobby/")
        .authorIcon("http://flickr.com/icons/bobby.jpg")
        .title("Slack API Documentation")
        .titleLink("https://api.slack.com")
        .text("Optional text that appears within the attachment")
        .imageUrl("http://my-website.com/path/to/image.jpg")
        .thumbUrl("http://example.com/path/to/thumb.png")
        .footer("Slack API")
        .footerIcon("https://platform.slack-edge.com/img/default_application_icon.png")
        .ts(new Date().getTime())
        .fields(Collections.singletonList(slackField));

    SlackMessage slackMessage = new SlackMessage().addAttachment(attachment);
    assertNotNull(slackMessage);
    assertNotNull(slackMessage.attachments());
    assertEquals(1, slackMessage.attachments().size());

    SlackAttachment actualAttachment = slackMessage.attachments().get(0);
    assertEquals("Required plain-text summary of the attachment.", actualAttachment.fallback());
  }

}
