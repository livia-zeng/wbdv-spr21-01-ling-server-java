package com.example.wbdvspr2101lingserverjava.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "widgets")
public class Widget {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String type;
  private Integer size;
  private String text;
  private String topicId;
  private Integer width;
  private Integer height;
  private String ordered;
  private String src;
  private String name;
  private String cssClass;
  private String style;
  private String value;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getOrdered() {
    return ordered;
  }

  public void setOrdered(String ordered) {
    this.ordered = ordered;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Widget(Long id, String topicId, String type, Integer size, String text) {
    this.id = id;
    this.topicId = topicId;
    this.type = type;
    this.size = size;
    this.text = text;
  }

  @Override
  public String toString() {
    return "Widget{" +
        "id=" + id +
        ", type='" + type + '\'' +
        ", size=" + size +
        ", text='" + text + '\'' +
        ", topicId='" + topicId + '\'' +
        ", width=" + width +
        ", height=" + height +
        ", ordered='" + ordered + '\'' +
        ", src='" + src + '\'' +
        ", name='" + name + '\'' +
        ", cssClass='" + cssClass + '\'' +
        ", style='" + style + '\'' +
        ", value='" + value + '\'' +
        '}';
  }

  public Widget() {

  }
}
