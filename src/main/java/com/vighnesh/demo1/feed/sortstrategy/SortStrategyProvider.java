package com.vighnesh.demo1.feed.sortstrategy;

public class SortStrategyProvider {

    public static AbstractSortStrategy getSortStrategy(String strategy) {
        if(strategy == null) return new DefaultSortStrategy();
        if(strategy.equalsIgnoreCase("none")) return new DefaultSortStrategy();
        if(strategy.equalsIgnoreCase("comments")) return new MostCommented();
        if(strategy.equalsIgnoreCase("upvotes")) return new MostUpVotedStrategy();
        return new DefaultSortStrategy();
    }
}
