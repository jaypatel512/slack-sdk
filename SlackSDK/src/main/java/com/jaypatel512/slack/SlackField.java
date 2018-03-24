package com.jaypatel512.slack;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true, fluent = true)
public class SlackField {

  private String title;
  private String value;

  @SerializedName("short")
  private boolean shorten;
}
