package com.example.wbdvspr2101lingserverjava.controllers;

import com.example.wbdvspr2101lingserverjava.models.Widget;
import com.example.wbdvspr2101lingserverjava.services.WidgetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
  @Autowired
  WidgetService service;// = new WidgetService();

  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidgetForTopic(
      @PathVariable("tid") String topicId,
      @RequestBody Widget widget) {
    return service.createWidget(topicId,widget);
  }

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(
      @PathVariable("tid") String topicId
  ) {
    return service.findWidgetsForTopic(topicId);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetById(
      @PathVariable("wid") Long id) {
    return service.findWidgetById(id);
  }


  @PutMapping("/api/widgets/{wid}")
  public int updateWidget(@PathVariable("wid") Long wid, @RequestBody Widget widget) {
    return service.updateWidget(wid, widget);
  }

  @DeleteMapping("/api/widgets/{wid}")
  public int deleteWidget(@PathVariable("wid") Long wid) {
    return service.deleteWidget(wid);
  }

}
