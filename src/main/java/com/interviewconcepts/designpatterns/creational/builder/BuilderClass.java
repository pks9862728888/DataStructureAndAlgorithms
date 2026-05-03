package com.interviewconcepts.designpatterns.creational.builder;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class BuilderClass {
  private int score;
  private String name;

  public static class Builder {
    private int score;
    private String name;

    public Builder score(int score) {
      this.score = score;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public BuilderClass build() {
      BuilderClass bc = new BuilderClass();
      bc.score = this.score;
      bc.name = this.name;
      return bc;
    }
  }
}
