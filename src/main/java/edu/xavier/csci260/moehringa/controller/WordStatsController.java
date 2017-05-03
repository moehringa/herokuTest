package edu.xavier.csci260.moehringa.controller;

import edu.xavier.csci260.moehringa.domain.WordStats;
import edu.xavier.csci260.moehringa.service.WordStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



/**
 * Created by aaronmoehring on 3/3/17.
 */
@Controller
public class WordStatsController {


    private WordStatsService wordService;
    @Autowired
    public WordStatsController(WordStatsService wordService){

        this.wordService = wordService;

    }

    @RequestMapping(value = "/words/stats/{word}", method = RequestMethod.GET)
    @ResponseBody
    public List<WordStats> returnSingleWordStats(@PathVariable("word")Optional<String> word) {

        wordService.find(word).isPresent();
        return wordService.find(word).get();

    }

    @RequestMapping(value = "/words/all",  method = RequestMethod.GET)
    @ResponseBody
    public List<WordStats> returnAll(){

        wordService.find(Optional.empty()).isPresent();
        return wordService.find(Optional.empty()).get();

    }

    @RequestMapping(value = "/words/update",  method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody WordStats wordstats){

        String word = wordstats.getWord();
        String conversion = wordstats.getConversion();
        wordService.update(word, conversion);

    }

}
