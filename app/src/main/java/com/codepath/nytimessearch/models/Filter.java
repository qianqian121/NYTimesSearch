package com.codepath.nytimessearch.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.parceler.Parcels;

/**
 * Created by qiming on 7/30/2016.
 */
public class Filter implements Parcelable {
    String beginDate;
    String sortOrder;

    protected Filter(Parcel in) {
        beginDate = in.readString();
        sortOrder = in.readString();
    }

    public static final Creator<Filter> CREATOR = new Creator<Filter>() {
        @Override
        public Filter createFromParcel(Parcel in) {
            return new Filter(in);
        }

        @Override
        public Filter[] newArray(int size) {
            return new Filter[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.beginDate);
        parcel.writeString(this.sortOrder);
        parcel.writeParcelable(Parcels.wrap(this.newsDesk), i);
    }

    public class NewsDesk implements Parcelable {
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

        public NewsDesk() {
            this.arts = "";
            this.fashion = "";
            this.sports = "";
        }

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.arts);
            dest.writeString(this.fashion);
            dest.writeString(this.sports);
        }

        protected NewsDesk(Parcel in) {
            this.arts = in.readString();
            this.fashion = in.readString();
            this.sports = in.readString();
        }

        public final Creator<NewsDesk> CREATOR = new Creator<NewsDesk>() {
            @Override
            public NewsDesk createFromParcel(Parcel source) {
                return new NewsDesk(source);
            }

            @Override
            public NewsDesk[] newArray(int size) {
                return new NewsDesk[size];
            }
        };
    }
    public NewsDesk newsDesk;

    public void update(Filter filter) {
        this.beginDate = filter.getBeginDate();
        this.sortOrder = filter.getSortOrder();
        this.newsDesk.setArts(filter.getNewsDesk().getArts());
        this.newsDesk.setFashion(filter.getNewsDesk().getFashion());
        this.newsDesk.setSports(filter.getNewsDesk().getSports());
    }

    public Filter(String beginDate, String sortOrder, NewsDesk newsDesk) {
        this.beginDate = beginDate;
        this.sortOrder = sortOrder;
        this.newsDesk = newsDesk;
    }

    public Filter() {
        this.beginDate = "";
        this.sortOrder = "";
        this.newsDesk = new NewsDesk();
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
