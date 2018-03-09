package com.example.zengwei.newbook.JSONModel;

import java.io.Serializable;

/**
 * 书籍详情model
 * Created by zengwei on 2018/3/9.
 */

public class Detail implements Serializable {
    private String _id;   //id
    private String title;  //书名
    private String cover; //书籍封面
    private String longIntro;   //简介
    private String author;   //作者
    private String majorCate;  //书籍类型
    private String minorCate;  //书籍副类型
    private String updated;    //更新时间
    private String lastChapter;   //最新章节
    private int wordCount;  //字数
    private double score;  //评分
    private double retentionRatio;//读者留存
    private int serializeWordCount;  //日跟新字数
    private boolean isSerial;   //是否完结

    @Override
    public String toString() {
        return "Detail{" +
                "_id='" + _id + '\'' +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", longIntro='" + longIntro + '\'' +
                ", author='" + author + '\'' +
                ", majorCate='" + majorCate + '\'' +
                ", minorCate='" + minorCate + '\'' +
                ", updated='" + updated + '\'' +
                ", lastChapter='" + lastChapter + '\'' +
                ", wordCount=" + wordCount +
                ", score=" + score +
                ", retentionRatio=" + retentionRatio +
                ", serializeWordCount=" + serializeWordCount +
                ", isSerial=" + isSerial +
                '}';
    }

    public Detail(String _id, String title, String cover, String longIntro, String author, String majorCate, String minorCate, String updated, String lastChapter, int wordCount, double score, double retentionRatio, int serializeWordCount, boolean isSerial) {
        this._id = _id;
        this.title = title;
        this.cover = cover;
        this.longIntro = longIntro;
        this.author = author;
        this.majorCate = majorCate;
        this.minorCate = minorCate;
        this.updated = updated;
        this.lastChapter = lastChapter;
        this.wordCount = wordCount;
        this.score = score;
        this.retentionRatio = retentionRatio;
        this.serializeWordCount = serializeWordCount;
        this.isSerial=isSerial;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLongIntro() {
        return longIntro;
    }

    public void setLongIntro(String longIntro) {
        this.longIntro = longIntro;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMajorCate() {
        return majorCate;
    }

    public void setMajorCate(String majorCate) {
        this.majorCate = majorCate;
    }

    public String getMinorCate() {
        return minorCate;
    }

    public void setMinorCate(String minorCate) {
        this.minorCate = minorCate;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getRetentionRatio() {
        return retentionRatio;
    }

    public void setRetentionRatio(double retentionRatio) {
        this.retentionRatio = retentionRatio;
    }

    public int getSerializeWordCount() {
        return serializeWordCount;
    }

    public void setSerializeWordCount(int serializeWordCount) {
        this.serializeWordCount = serializeWordCount;
    }

    public boolean isSerial() {
        return isSerial;
    }

    public void setSerial(boolean serial) {
        isSerial = serial;
    }
}
