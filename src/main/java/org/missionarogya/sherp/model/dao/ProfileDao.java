package org.missionarogya.sherp.model.dao;

import org.missionarogya.sherp.model.dao.object.Member;

public interface ProfileDao {
	public void saveMember(Member member);
	public boolean findMemberByEmailId(Member member);
}
