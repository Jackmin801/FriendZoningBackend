package com.meowmeow.dhateapp.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RestController
@RequestMapping("/search")
@CrossOrigin("*")
public class SearchController {

    @Autowired
    SearchService searchService;

    static List<SearchResult> fake = List.of(
            new SearchResult("Chooi He Lin",20,5),
            new SearchResult("Choo She Lin",40,4),
            new SearchResult("Chu Helix",100,2),
            new SearchResult("Chui Hi Ling",0,2)
    );
    @GetMapping(path = "/{username}")
    public List<SearchResult> query(
            @PathVariable("username")String username,
            @RequestParam(name = "dist", defaultValue = "100")int distance,
            @RequestParam(name = "gender", defaultValue = "both")String gender
    ){
        return searchService.search(username,distance,gender);
    }

    @GetMapping
    public List<SearchResult> defaultCatch(){
        return searchService.search(new Coordinate("0.0","0.0"),1000000,"","Both");
    }
}
