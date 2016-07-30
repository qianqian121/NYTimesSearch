
package com.codepath.nytimessearch.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Doc {

    private String web_url;
    private String snippet;
    private String leadParagraph;
    private String _abstract;
    private String printPage;
    private List<String> blog = new ArrayList<String>();
    private String source;
    private Headline headline;
//    private Keywords keywords;
    private String pubDate;
    private String documentType;
    private String newsDesK;
    private String sectionName;
    private String subsectionName;
//    private Byline byline;
    private String typeOfMaterial;
    private String id;
    private String wordCount;
    private String slideshowCredits;
    private List<Multimedium> multimedia = new ArrayList<Multimedium>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Doc() {
    }

    /**
     * 
     * @param headline
     * @param web_url
     * @param pubDate
     * @param slideshowCredits
     * @param keywords
     * @param documentType
     * @param leadParagraph
     * @param sectionName
     * @param snippet
     * @param wordCount
     * @param blog
     * @param id
     * @param typeOfMaterial
     * @param multimedia
     * @param byline
     * @param printPage
     * @param source
     * @param newsDesK
     * @param _abstract
     * @param subsectionName
     */
    public Doc(String web_url, String snippet, String leadParagraph, String _abstract, String printPage, List<String> blog, String source, Headline headline, Keywords keywords, String pubDate, String documentType, String newsDesK, String sectionName, String subsectionName, Byline byline, String typeOfMaterial, String id, String wordCount, String slideshowCredits, List<Multimedium> multimedia) {
        this.web_url = web_url;
        this.snippet = snippet;
        this.leadParagraph = leadParagraph;
        this._abstract = _abstract;
        this.printPage = printPage;
        this.blog = blog;
        this.source = source;
        this.headline = headline;
        //this.keywords = keywords;
        this.pubDate = pubDate;
        this.documentType = documentType;
        this.newsDesK = newsDesK;
        this.sectionName = sectionName;
        this.subsectionName = subsectionName;
//        this.byline = byline;
        this.typeOfMaterial = typeOfMaterial;
        this.id = id;
        this.wordCount = wordCount;
        this.slideshowCredits = slideshowCredits;
        this.multimedia = multimedia;
    }

    /**
     * 
     * @return
     *     The web_url
     */
    public String getweb_url() {
        return web_url;
    }

    /**
     * 
     * @param web_url
     *     The web_url
     */
    public void setweb_url(String web_url) {
        this.web_url = web_url;
    }

    public Doc withweb_url(String web_url) {
        this.web_url = web_url;
        return this;
    }

    /**
     * 
     * @return
     *     The snippet
     */
    public String getSnippet() {
        return snippet;
    }

    /**
     * 
     * @param snippet
     *     The snippet
     */
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public Doc withSnippet(String snippet) {
        this.snippet = snippet;
        return this;
    }

    /**
     * 
     * @return
     *     The leadParagraph
     */
    public String getLeadParagraph() {
        return leadParagraph;
    }

    /**
     * 
     * @param leadParagraph
     *     The lead_paragraph
     */
    public void setLeadParagraph(String leadParagraph) {
        this.leadParagraph = leadParagraph;
    }

    public Doc withLeadParagraph(String leadParagraph) {
        this.leadParagraph = leadParagraph;
        return this;
    }

    /**
     * 
     * @return
     *     The _abstract
     */
    public String getAbstract() {
        return _abstract;
    }

    /**
     * 
     * @param _abstract
     *     The abstract
     */
    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public Doc withAbstract(String _abstract) {
        this._abstract = _abstract;
        return this;
    }

    /**
     * 
     * @return
     *     The printPage
     */
    public String getPrintPage() {
        return printPage;
    }

    /**
     * 
     * @param printPage
     *     The print_page
     */
    public void setPrintPage(String printPage) {
        this.printPage = printPage;
    }

    public Doc withPrintPage(String printPage) {
        this.printPage = printPage;
        return this;
    }

    /**
     * 
     * @return
     *     The blog
     */
    public List<String> getBlog() {
        return blog;
    }

    /**
     * 
     * @param blog
     *     The blog
     */
    public void setBlog(List<String> blog) {
        this.blog = blog;
    }

    public Doc withBlog(List<String> blog) {
        this.blog = blog;
        return this;
    }

    /**
     * 
     * @return
     *     The source
     */
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    public Doc withSource(String source) {
        this.source = source;
        return this;
    }

    /**
     * 
     * @return
     *     The headline
     */
    public Headline getHeadline() {
        return headline;
    }

    /**
     * 
     * @param headline
     *     The headline
     */
    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public Doc withHeadline(Headline headline) {
        this.headline = headline;
        return this;
    }


    /**
     * 
     * @return
     *     The pubDate
     */
    public String getPubDate() {
        return pubDate;
    }

    /**
     * 
     * @param pubDate
     *     The pub_date
     */
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Doc withPubDate(String pubDate) {
        this.pubDate = pubDate;
        return this;
    }

    /**
     * 
     * @return
     *     The documentType
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * 
     * @param documentType
     *     The document_type
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Doc withDocumentType(String documentType) {
        this.documentType = documentType;
        return this;
    }

    /**
     * 
     * @return
     *     The newsDesK
     */
    public String getNewsDesK() {
        return newsDesK;
    }

    /**
     * 
     * @param newsDesK
     *     The news_desK
     */
    public void setNewsDesK(String newsDesK) {
        this.newsDesK = newsDesK;
    }

    public Doc withNewsDesK(String newsDesK) {
        this.newsDesK = newsDesK;
        return this;
    }

    /**
     * 
     * @return
     *     The sectionName
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * 
     * @param sectionName
     *     The section_name
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Doc withSectionName(String sectionName) {
        this.sectionName = sectionName;
        return this;
    }

    /**
     * 
     * @return
     *     The subsectionName
     */
    public String getSubsectionName() {
        return subsectionName;
    }

    /**
     * 
     * @param subsectionName
     *     The subsection_name
     */
    public void setSubsectionName(String subsectionName) {
        this.subsectionName = subsectionName;
    }

    public Doc withSubsectionName(String subsectionName) {
        this.subsectionName = subsectionName;
        return this;
    }


    /**
     * 
     * @return
     *     The typeOfMaterial
     */
    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

    /**
     * 
     * @param typeOfMaterial
     *     The type_of_material
     */
    public void setTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }

    public Doc withTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
        return this;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The _id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Doc withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The wordCount
     */
    public String getWordCount() {
        return wordCount;
    }

    /**
     * 
     * @param wordCount
     *     The word_count
     */
    public void setWordCount(String wordCount) {
        this.wordCount = wordCount;
    }

    public Doc withWordCount(String wordCount) {
        this.wordCount = wordCount;
        return this;
    }

    /**
     * 
     * @return
     *     The slideshowCredits
     */
    public String getSlideshowCredits() {
        return slideshowCredits;
    }

    /**
     * 
     * @param slideshowCredits
     *     The slideshow_credits
     */
    public void setSlideshowCredits(String slideshowCredits) {
        this.slideshowCredits = slideshowCredits;
    }

    public Doc withSlideshowCredits(String slideshowCredits) {
        this.slideshowCredits = slideshowCredits;
        return this;
    }

    /**
     * 
     * @return
     *     The multimedia
     */
    public List<Multimedium> getMultimedia() {
        return multimedia;
    }

    /**
     * 
     * @param multimedia
     *     The multimedia
     */
    public void setMultimedia(List<Multimedium> multimedia) {
        this.multimedia = multimedia;
    }

    public Doc withMultimedia(List<Multimedium> multimedia) {
        this.multimedia = multimedia;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Doc withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
