package com.example.zengwei.newbook.JSONModel;

/**
 * Created by zengwei on 2018/3/6.
 */

public class Search {
    /**
     * _id : 50864bf69dacd30e3a000014
     * title : 遮天
     * cat : 仙侠
     * author : 辰东
     * cover : /agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42216%2F_42216_203892.jpg%2F
     * lastChapter : 我的新书《圣墟》已上传
     */
    public Search(String _id, String title, String cat, String author, String cover, String lastChapter) {
        this._id = _id;
        this.title = title;
        this.cat = cat;
        this.author = author;
        this.cover = cover;
        this.lastChapter = lastChapter;
    }
    @Override
    public String toString() {
        return "Search{" +
                "_id='" + _id + '\'' +
                ", title='" + title + '\'' +
                ", cat='" + cat + '\'' +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", lastChapter='" + lastChapter + '\'' +
                '}';
    }
            private String _id;
            private String title;
            private String cat;
            private String author;
            private String cover;
            private String lastChapter;

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

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getLastChapter() {
                return lastChapter;
            }

            public void setLastChapter(String lastChapter) {
                this.lastChapter = lastChapter;
            }


}
