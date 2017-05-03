/*
package edu.xavier.csci260.moehringa.controller;

import edu.xavier.csci260.moehringa.domain.WordBody;
import edu.xavier.csci260.moehringa.service.PigLatinService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by aaronmoehring on 3/7/17.
 */
/*
@Controller
public class PigLatinController {


    private PigLatinService pigService;
    @Autowired
    public PigLatinController(PigLatinService pigService){

        this.pigService = pigService;

    }

    @RequestMapping(value = "/piglatin/translate",  method = RequestMethod.POST)
    @ResponseBody
    public List translate(@RequestBody WordBody body){

        ArrayList<String> returnWords = new ArrayList<>();

        for(String word : body.getWords()){
            returnWords.add(pigService.translate(word));
        }

        return returnWords;
    }


}
*/