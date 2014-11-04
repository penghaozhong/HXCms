package com.hx.cms.dao.assist;

import java.util.List;

import com.hx.cms.entity.assist.CmsVoteSubTopic;
import com.hx.common.hibernate3.Updater;

public interface CmsVoteSubTopicDao {
	public List<CmsVoteSubTopic> findByVoteTopic(Integer voteTopicId);
	
	public CmsVoteSubTopic findById(Integer id);

	public CmsVoteSubTopic save(CmsVoteSubTopic bean);

	public CmsVoteSubTopic updateByUpdater(Updater<CmsVoteSubTopic> updater);

	public CmsVoteSubTopic deleteById(Integer id);
}