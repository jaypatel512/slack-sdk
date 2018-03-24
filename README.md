# Slack Webhook SDK

[![Build Status](https://travis-ci.org/jaypatel512/slack-sdk.svg?branch=master)](https://travis-ci.org/jaypatel512/slack-sdk)

Slack Webhook SDK allows sending messages to Slack.

## Adding it to your project

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    compile 'com.jaypatel512:slack-sdk:0.0.1'
}
```

To use the latest build from the `master` branch use:

 ```groovy
dependencies {
    compile 'com.jaypatel512:slack-sdk:0.0.1-SNAPSHOT'
}
```

## Usage

> Send Simple Message

```java
Slack slack = Slack.builder("https://hooks.slack.com/services/id_1/id_2/token")
        .build();

SlackMessage message = new SlackMessage()
        .text("Hello World");

slack.send(message);
```