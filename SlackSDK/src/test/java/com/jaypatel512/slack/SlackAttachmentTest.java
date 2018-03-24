package com.jaypatel512.slack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Collections;
import java.util.Date;
import org.junit.Test;

public class SlackAttachmentTest {

  @Test
  public void setters_setsValues() {
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
        .timestamp(new Date())
        .fields(Collections.singletonList(slackField));

    assertEquals("Required plain-text summary of the attachment.", attachment.fallback());
    assertEquals("#36a64f", attachment.color());
    assertEquals("Optional text that appears above the attachment block", attachment.pretext());
    assertEquals("Bobby Tables", attachment.authorName());
    assertEquals("http://flickr.com/bobby/", attachment.authorLink());
    assertEquals("http://flickr.com/icons/bobby.jpg", attachment.authorIcon());
    assertEquals("Slack API Documentation", attachment.title());
    assertEquals("https://api.slack.com", attachment.titleLink());
    assertEquals("Optional text that appears within the attachment", attachment.text());
    assertEquals("http://my-website.com/path/to/image.jpg", attachment.imageUrl());
    assertEquals("http://example.com/path/to/thumb.png", attachment.thumbUrl());
    assertEquals("Slack API", attachment.footer());
    assertEquals("https://platform.slack-edge.com/img/default_application_icon.png", attachment.footerIcon());
  }

  @Test
  public void addField_addsField() {
    SlackAttachment attachment = new SlackAttachment();
    SlackField field = new SlackField();

    assertNull(attachment.fields());

    attachment.addField(field);

    assertNotNull(attachment.fields());
    assertEquals(1, attachment.fields().size());
    assertEquals(field, attachment.fields().get(0));
  }

}
