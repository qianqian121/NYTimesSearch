
package com.codepath.nytimessearch.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Meta {

    private Integer hits;
    private Integer time;
    private Integer offset;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Meta() {
    }

    /**
     * 
     * @param time
     * @param hits
     * @param offset
     */
    public Meta(Integer hits, Integer time, Integer offset) {
        this.hits = hits;
        this.time = time;
        this.offset = offset;
    }

    /**
     * 
     * @return
     *     The hits
     */
    public Integer getHits() {
        return hits;
    }

    /**
     * 
     * @param hits
     *     The hits
     */
    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Meta withHits(Integer hits) {
        this.hits = hits;
        return this;
    }

    /**
     * 
     * @return
     *     The time
     */
    public Integer getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */
    public void setTime(Integer time) {
        this.time = time;
    }

    public Meta withTime(Integer time) {
        this.time = time;
        return this;
    }

    /**
     * 
     * @return
     *     The offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * 
     * @param offset
     *     The offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Meta withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Meta withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
