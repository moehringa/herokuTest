package edu.xavier.csci260.moehringa.service;

import edu.xavier.csci260.moehringa.DAL.WordTrackerDAO;
import edu.xavier.csci260.moehringa.platin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by aaronmoehring on 3/7/17.
 */

@Component
public class PigLatinServiceImpl implements PigLatinService{


    private WordTrackerDAO wordTracker;

    @Autowired
    public PigLatinServiceImpl(WordTrackerDAO wordTracker){

        this.wordTracker = wordTracker;
    }

    public String translate(String word){

        PLatin translater = wordTracker.getPlatin();
        String converted = translater.process(word);

        return converted;

    }
}
