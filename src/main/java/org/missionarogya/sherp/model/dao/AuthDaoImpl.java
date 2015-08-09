package org.missionarogya.sherp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.missionarogya.sherp.model.dao.object.Access;
import org.missionarogya.sherp.model.dao.object.Member;
import org.springframework.stereotype.Repository;
@Repository("AuthDao")
public class AuthDaoImpl extends AbstractDao implements AuthDao  {

	public List<Member> findMember(int memberId) {
		// TODO Auto-generated method stub
		
		Criteria criteria = getSession().createCriteria(Member.class);
        criteria.add(Restrictions.eq("memberId",memberId));
        return (List<Member>)criteria.list();
		
	}
	public List<Access> getAccessProfile(String action){
		Criteria criteria = getSession().createCriteria(Access.class);
        criteria.add(Restrictions.eq("action",action));
        return (List<Access>)criteria.list();
		
	}

}
