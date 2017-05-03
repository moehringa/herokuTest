package edu.xavier.csci260.moehringa.service;

import edu.xavier.csci260.moehringa.DAL.WordTrackerDAO;
import edu.xavier.csci260.moehringa.domain.WordStats;
import java.util.List;
import java.util.Optional;

/**
 * Created by aaronmoehring on 3/3/17.
 */

public interface WordStatsService {

    void update(String word, String conversion);
    Optional<List<WordStats>> find(Optional<String> word);
    WordTrackerDAO getWordTracker();

}
