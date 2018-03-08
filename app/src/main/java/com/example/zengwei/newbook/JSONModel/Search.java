package com.example.zengwei.newbook.JSONModel;

import java.util.List;

/**
 * Created by zengwei on 2018/3/6.
 */

public class Search {
            /**
             * _id : 50864bf69dacd30e3a000014
             * hasCp : true
             * title : 遮天
             * aliases :
             * cat : 仙侠
             * author : 辰东
             * site : zhuishuvip
             * cover : /agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42216%2F_42216_203892.jpg%2F
             * shortIntro : 冰冷与黑暗并存的宇宙深处，九具庞大的龙尸拉着一口青铜古棺，亘古长存。
             这是太空探测器在枯寂的宇宙中捕捉到的一幅极其震撼的画面。
             九龙拉棺，究竟是回到了上古，还是来到了星空的彼岸？
             一个浩大的仙侠世界，光怪陆离，神秘无尽。热血似火山沸腾，激情若瀚海汹涌，欲望如深渊无止境……
             登天路，踏歌行，弹指遮天。
             * lastChapter : 我的新书《圣墟》已上传
             * retentionRatio : 61.86
             * banned : 0
             * allowMonthly : false
             * latelyFollower : 2986
             * wordCount : 6352116
             * contentType : txt
             * superscript :
             * sizetype : -1
             * highlight : {"title":["遮","天"]}
             */

            private String _id;
            private boolean hasCp;
            private String title;
            private String aliases;
            private String cat;
            private String author;
            private String site;
            private String cover;
            private String shortIntro;
            private String lastChapter;
            private double retentionRatio;
            private int banned;
            private boolean allowMonthly;
            private int latelyFollower;
            private int wordCount;
            private String contentType;
            private String superscript;
            private int sizetype;
            private HighlightBean highlight;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public boolean isHasCp() {
                return hasCp;
            }

            public void setHasCp(boolean hasCp) {
                this.hasCp = hasCp;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getAliases() {
                return aliases;
            }

            public void setAliases(String aliases) {
                this.aliases = aliases;
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

            public String getSite() {
                return site;
            }

            public void setSite(String site) {
                this.site = site;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getShortIntro() {
                return shortIntro;
            }

            public void setShortIntro(String shortIntro) {
                this.shortIntro = shortIntro;
            }

            public String getLastChapter() {
                return lastChapter;
            }

            public void setLastChapter(String lastChapter) {
                this.lastChapter = lastChapter;
            }

            public double getRetentionRatio() {
                return retentionRatio;
            }

            public void setRetentionRatio(double retentionRatio) {
                this.retentionRatio = retentionRatio;
            }

            public int getBanned() {
                return banned;
            }

            public void setBanned(int banned) {
                this.banned = banned;
            }

            public boolean isAllowMonthly() {
                return allowMonthly;
            }

            public void setAllowMonthly(boolean allowMonthly) {
                this.allowMonthly = allowMonthly;
            }

            public int getLatelyFollower() {
                return latelyFollower;
            }

            public void setLatelyFollower(int latelyFollower) {
                this.latelyFollower = latelyFollower;
            }

            public int getWordCount() {
                return wordCount;
            }

            public void setWordCount(int wordCount) {
                this.wordCount = wordCount;
            }

            public String getContentType() {
                return contentType;
            }

            public void setContentType(String contentType) {
                this.contentType = contentType;
            }

            public String getSuperscript() {
                return superscript;
            }

            public void setSuperscript(String superscript) {
                this.superscript = superscript;
            }

            public int getSizetype() {
                return sizetype;
            }

            public void setSizetype(int sizetype) {
                this.sizetype = sizetype;
            }

            public HighlightBean getHighlight() {
                return highlight;
            }

            public void setHighlight(HighlightBean highlight) {
                this.highlight = highlight;
            }

            public static class HighlightBean {
                private List<String> title;

                public List<String> getTitle() {
                    return title;
                }

                public void setTitle(List<String> title) {
                    this.title = title;
                }
            }
}
