package org.missionarogya.sherp.model.dao;
 
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import org.missionarogya.sherp.model.dao.MyObjectDao;
import org.missionarogya.sherp.model.dao.object.MyObject;
 
@Repository("objectDao")
public class MyObjectDaoImpl extends AbstractDao implements MyObjectDao{
 
    public void saveObject(MyObject myObject) {
        persist(myObject);
    }
 
    @SuppressWarnings("unchecked")
    public List<MyObject> findAllObjects() {
        Criteria criteria = getSession().createCriteria(MyObject.class);
        return (List<MyObject>) criteria.list();
    }
 
    public void deleteMyObjectBySsn(String ssn) {
        
        MyObject myObject = (MyObject) getSession().load(MyObject.class,Integer.parseInt(ssn));
        getSession().delete(myObject);
    }
 
     
    public MyObject findBySsn(String ssn){
        Criteria criteria = getSession().createCriteria(MyObject.class);
        criteria.add(Restrictions.eq("id",Integer.parseInt(ssn)));
        return (MyObject) criteria.uniqueResult();
    }
     
    public void updateMyObject(MyObject myObject){
        getSession().update(myObject);
    }
     
}