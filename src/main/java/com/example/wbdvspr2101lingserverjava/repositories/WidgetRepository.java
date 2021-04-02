package com.example.wbdvspr2101lingserverjava.repositories;

import com.example.wbdvspr2101lingserverjava.models.Widget;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WidgetRepository
    extends CrudRepository<Widget, Long> {

  //    @Query(value="SELECT * FROM widgets", nativeQuery = true)
  @Query("SELECT widget FROM Widget widget")
  public List<Widget> findAllWidgets();

  @Query(value="SELECT * FROM widgets WHERE id=:wid", nativeQuery = true)
  public Widget findWidgetById(@Param("wid") Long widgetId);

  @Query(value="SELECT * FROM widgets WHERE topic_id=:tid", nativeQuery = true)
  public List<Widget> findWidgetsForTopic(@Param("tid") String topicId);
}
