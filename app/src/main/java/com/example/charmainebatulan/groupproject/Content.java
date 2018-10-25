package com.example.charmainebatulan.groupproject;

public class Content {

    private int id;
    private String topic;
    private int image;
    private String description;

    private int codingExample;
    private int output;
    private String youtubeVideo;
    private String videoDescription;


    public Content(int id, String topic, int image, String description) {
        this.id = id;
        this.topic = topic;
        this.image = image;
        this.description = description;

    }

    public Content(int id, String topic, int codingExample, int output) {
        this.id = id;
        this.topic = topic;
        this.codingExample = codingExample;
        this.output = output;
    }

    public Content(int id, String topic, String youtubeVideo, String videoDescription) {
        this.id = id;
        this.topic = topic;
        this.youtubeVideo = youtubeVideo;
        this.videoDescription = videoDescription;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public int getCodingExample() {

        return codingExample;
    }

    public void setCodingExample(int codingExample) {
        this.codingExample = codingExample;
    }

    public String getYoutubeVideo() {
        return youtubeVideo;
    }

    public void setYoutubeVideo(String youtubeVideo) {
        this.youtubeVideo = youtubeVideo;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    @Override
    public String toString() {
        return topic;


    }
}
