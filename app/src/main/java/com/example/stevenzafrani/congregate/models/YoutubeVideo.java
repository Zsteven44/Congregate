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



}
