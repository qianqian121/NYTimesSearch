package com.codepath.nytimessearch.models;

/**
 * Created by qiming on 7/30/2016.
 */
public class Filter {
    String beginDate;
    String sortOrder;
    class NewsDesk {
        String arts;
        String fashion;

        public String getSports() {
            return sports;
        }

        public void setSports(String sports) {
            this.sports = sports;
        }

        public String getArts() {
            return arts;
        }

        public void setArts(String arts) {
            this.arts = arts;
        }

        public String getFashion() {
            return fashion;
        }

        public void setFashion(String fashion) {
            this.fashion = fashion;
        }

        String sports;

        public NewsDesk(String arts, String fashion, String sports) {
            this.arts = arts;
            this.fashion = fashion;
            this.sports = sports;
        }

        public String toQueryString() {
            String s = arts + " " + fashion + " " + sports;
            if (s.length() == 2)
                return "";
            return String.format("news_desk:(%s)", s);
        }
    }
    NewsDesk newsDesk;

    public Filter(String beginDate, String sortOrder, NewsDesk newsDesk) {
        this.beginDate = beginDate;
        this.sortOrder = sortOrder;
        this.newsDesk = newsDesk;
    }

    public Filter() {
        this.beginDate = "";
        this.sortOrder = "";
        this.newsDesk = null;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public NewsDesk getNewsDesk() {
        return newsDesk;
    }

    public String getNewsDeskQuery() {
        return newsDesk.toQueryString();
    }

    public void setNewsDesk(NewsDesk newsDesk) {
        this.newsDesk = newsDesk;
    }
}
