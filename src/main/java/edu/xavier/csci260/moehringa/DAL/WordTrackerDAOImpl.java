package edu.xavier.csci260.moehringa.DAL;

import edu.xavier.csci260.moehringa.domain.WordStats;
import edu.xavier.csci260.moehringa.platin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class WordTrackerDAOImpl implements WordTrackerDAO{

  private PLatin platin;
  private JdbcTemplate jdbcTemplate;
  private Logger log;

  @Autowired
  public WordTrackerDAOImpl(JdbcTemplate jdbcTemplate) {

    this.jdbcTemplate = jdbcTemplate;
    platin = new PLatinImpl();
  }
  @Override
  public void wordUpdate(String theWord, String conversion){

    if(platin.convert(theWord).equals(conversion)) {

      Optional<List<WordStats>> newTime = find(theWord);

      int updateTime = newTime.get().get(0).getTimesSeen() + 1;

      jdbcTemplate.update("update word_stats set timesSeen = ? where word = ?", updateTime, theWord);

    }
    else{
      log.info("Unable to update: Conversion did not match word.");
    }
  }
  @Override
  public Optional<List<WordStats>> find(String word){

    List<WordStats> returnList = jdbcTemplate.query(
            "SELECT word, conversion, timesSeen FROM word_stats WHERE word = ?",
            new Object[] { word },
            (rs, rowNum) ->
                    new WordStats(rs.getString("word"),
                            rs.getString("conversion"),
                            rs.getInt("timesSeen"))

    );

    return Optional.of(returnList);

  }

  @Override
  public void createWord(String theWord, String theConversion){

    Object[] newWord = {theWord, theConversion, 1};
    List<Object[]> params = new ArrayList<>();
    params.add(newWord);
    jdbcTemplate.batchUpdate("INSERT INTO word_stats(word, conversion, timesSeen) VALUES (?,?,?)", params);

  }
  @Override
  public Optional<List<WordStats>> findAll(){

    List<WordStats> returnList = jdbcTemplate.query(
            "SELECT * FROM word_stats",
            (rs, rowNum) ->
                new WordStats(rs.getString("word"), rs.getString("conversion"), rs.getInt("timesSeen"))
            );

    return Optional.of(returnList);

  }
  @Override
  public void setPLatin(PLatin p){
    this.platin = p;
  }
  @Override
  public PLatin getPlatin(){
    return platin;
  }
  @Override
  public void setLogger(Logger logger){
    this.log = logger;
  }
  @Override
  public Logger getLogger(){
    return log;
  }

}
