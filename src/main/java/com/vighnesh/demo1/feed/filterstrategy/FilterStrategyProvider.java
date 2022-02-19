package com.vighnesh.demo1.feed.filterstrategy;

public class FilterStrategyProvider {

    public static AbstractFilterStrategy getStrategy(String strategy) {
        if(strategy == null) return new DefaultFilterStrategy();
        if(strategy.equalsIgnoreCase("none")) return new DefaultFilterStrategy();
        if(strategy.equalsIgnoreCase("posted")) return new PosterFilterStrategy();
        if(strategy.equalsIgnoreCase("commented")) return new CommentFilterStrategy();
        if(strategy.equalsIgnoreCase("voted")) return new VotedFilterStrategy();

        return new  DefaultFilterStrategy();
    }
}
