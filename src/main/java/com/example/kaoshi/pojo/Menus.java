package com.example.kaoshi.pojo;

import java.util.List;

public class Menus {
    private String id;
    private String parentId;
    private String text;
    private String url;
    private String yxbz;
    private List<Menus> children;
    private List<String> strings;

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public Menus(String id, String parentId, String text, String url, String yxbz) {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.url = url;
        this.yxbz = yxbz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz;
    }

    public List<Menus> getChildren() {
        return children;
    }

    public void setChildren(List<Menus> children) {
        this.children = children;
    }
}
