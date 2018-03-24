package com.jaypatel512.slack;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true, fluent = true)
public class SlackAttachment {

  private String fallback;
  private String color;
  private String pretext;
  private String authorName;
  private String authorLink;
  private String authorIcon;
  private String title;
  private String titleLink;
  private String text;
  private List<SlackField> fields;
  private String imageUrl;
  private String thumbUrl;
  private String footer;
  private String footerIcon;
  private Long ts;

  public SlackAttachment addField(SlackField field) {
    if (fields == null) {
      fields = new ArrayList<>();
    }
    fields.add(field);
    return this;
  }
}
