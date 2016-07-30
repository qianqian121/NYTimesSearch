
package com.codepath.nytimessearch.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Byline {

    private String organization;
    private String original;
    private List<String> person = new ArrayList<String>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Byline() {
    }

    /**
     * 
     * @param person
     * @param organization
     * @param original
     */
    public Byline(String organization, String original, List<String> person) {
        this.organization = organization;
        this.original = original;
        this.person = person;
    }

    /**
     * 
     * @return
     *     The organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * 
     * @param organization
     *     The organization
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Byline withOrganization(String organization) {
        this.organization = organization;
        return this;
    }

    /**
     * 
     * @return
     *     The original
     */
    public String getOriginal() {
        return original;
    }

    /**
     * 
     * @param original
     *     The original
     */
    public void setOriginal(String original) {
        this.original = original;
    }

    public Byline withOriginal(String original) {
        this.original = original;
        return this;
    }

    /**
     * 
     * @return
     *     The person
     */
    public List<String> getPerson() {
        return person;
    }

    /**
     * 
     * @param person
     *     The person
     */
    public void setPerson(List<String> person) {
        this.person = person;
    }

    public Byline withPerson(List<String> person) {
        this.person = person;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Byline withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
