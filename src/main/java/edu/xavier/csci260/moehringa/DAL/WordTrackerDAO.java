package edu.xavier.csci260.moehringa.DAL;

import edu.xavier.csci260.moehringa.domain.WordStats;
import edu.xavier.csci260.moehringa.platin.PLatin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;


public interface WordTrackerDAO{

  void wordUpdate(String word, String conversion);
  Optional<List<WordStats>> find(String word);
  void createWord(String word, String conversion);
  Optional<List<WordStats>> findAll();
  void setPLatin(PLatin p);
  PLatin getPlatin();
  void setLogger(Logger logger);
  Logger getLogger();
}
