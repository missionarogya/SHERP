package org.missionarogya.sherp.model.dao;
import java.util.List;
 

import org.missionarogya.sherp.model.dao.object.MyObject;
 
public interface MyObjectDao {
  void saveObject(MyObject myObject);
     
    List<MyObject> findAllObjects();
     
    void deleteMyObjectBySsn(String ssn);
     
    MyObject findBySsn(String ssn);
     
    void updateMyObject(MyObject myObject);
}
