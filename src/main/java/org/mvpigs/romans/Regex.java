package org.mvpigs.romans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private String regex="";
    private Pattern pattern;
    private Matcher matcher;

    public Regex() {}
    
    public Regex(String regex) {
        this.regex = regex;
        pattern = Pattern.compile(regex);
    }

    public Matcher getMatcher(String aEvaluar) {
        return pattern.matcher(aEvaluar);
    }

    public String getregex() {
        return this.regex;
    }


}