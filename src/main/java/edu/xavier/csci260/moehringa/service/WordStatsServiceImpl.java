package edu.xavier.csci260.moehringa.service;

import edu.xavier.csci260.moehringa.DAL.WordTrackerDAO;
import edu.xavier.csci260.moehringa.domain.WordStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

/**
 * Created by aaronmoehring on 3/4/17.
 */

@Component
public class WordStatsServiceImpl implements WordStatsService {


    private WordTrackerDAO wordTracker;

    @Autowired
    public WordStatsServiceImpl(WordTrackerDAO wordTracker){

        this.wordTracker = wordTracker;
    }

    public void update(String word, String conversion) {

        if(wordTracker.find(word).isPresent() && !wordTracker.find(word).get().isEmpty()){
            wordTracker.wordUpdate(word, conversion);

        }
        else{
            wordTracker.createWord(word, conversion);
        }

    }


    public Optional<List<WordStats>> find(Optional<String> word) {

        if(word.isPresent()){
            String findMe = word.get();
            return wordTracker.find(findMe);
        }
        else{
            return wordTracker.findAll();
        }
    }

    public WordTrackerDAO getWordTracker(){
        return wordTracker;
    }
}
