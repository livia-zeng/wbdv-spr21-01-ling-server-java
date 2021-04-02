package com.example.wbdvspr2101lingserverjava.services;

import com.example.wbdvspr2101lingserverjava.models.Widget;
import com.example.wbdvspr2101lingserverjava.repositories.WidgetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository repository;

  public Widget createWidget(String topicId,Widget widget) {
      widget.setTopicId(topicId);
      return repository.save(widget);
  }

  public List<Widget> findAllWidgets() {
    return repository.findAllWidgets();
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    return repository.findWidgetsForTopic(topicId);
  }

  public Widget findWidgetById(Long id) {
    return repository.findWidgetById(id);
  }

  public Widget updateWidget(Long id, Widget newWidget) {
    Widget originalWidget = findWidgetById(id);
    originalWidget.setType(newWidget.getType());
    originalWidget.setText(newWidget.getText());
    originalWidget.setSrc(newWidget.getSrc());
    originalWidget.setHeight(newWidget.getHeight());
    originalWidget.setWidth(newWidget.getWidth());
    if(newWidget.getOrdered() != null) originalWidget.setOrdered(newWidget.getOrdered());
    originalWidget.setSize(newWidget.getSize());
    return repository.save(originalWidget);
  }

  public Integer deleteWidget(Long id) {
    repository.deleteById(id);
    return 1;
  }

}
