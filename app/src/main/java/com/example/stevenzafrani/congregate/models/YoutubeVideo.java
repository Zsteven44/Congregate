package com.example.stevenzafrani.congregate.models;


public class YoutubeVideo {
    String title;
    String description;
    String id;
    String link;
    String defaultThumb;
    String mediumThumb;
    String highThumb;
    String standardThumb;


    public YoutubeVideo(String title,
                        String description,
                        String id,
                        String link,
                        String defaultThumb,
                        String mediumThumb,
                        String highThumb,
                        String standardThumb) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.link = link;
        this.defaultThumb = defaultThumb;
        this.mediumThumb = mediumThumb;
        this.highThumb = highThumb;
        this.standardThumb = standardThumb;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDefaultThumb() {
        return defaultThumb;
    }

    public void setDefaultThumb(String defaultThumb) {
        this.defaultThumb = defaultThumb;
    }

    public String getMediumThumb() {
        return mediumThumb;
    }

    public void setMediumThumb(String mediumThumb) {
        this.mediumThumb = mediumThumb;
    }

    public String getHighThumb() {
        return highThumb;
    }

    public void setHighThumb(String highThumb) {
        this.highThumb = highThumb;
    }

    public String getStandardThumb() {
        return standardThumb;
    }

    public void setStandardThumb(String standardThumb) {
        this.standardThumb = standardThumb;
    }
}
