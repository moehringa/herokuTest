package edu.xavier.csci260.moehringa.domain;

public class WordStats {
  private String word;
  private String conversion;
  private Integer timesSeen;


  public WordStats(String word, String conversion, Integer timesSeen){
    this.word = word;
    this.conversion = conversion;
    this.timesSeen = timesSeen;
  }

  public WordStats(){}

  public String getWord() {
        return word;
    }

    public void setword(String word) {
        this.word = word;
    }

    public String getConversion() {
        return conversion;
    }

    public void setconversion(String conversion) {
        this.conversion = conversion;
    }

    public Integer getTimesSeen() {
        return timesSeen;
    }

    public void incrementTimesSeen() {
        timesSeen += 1;
    }
}
