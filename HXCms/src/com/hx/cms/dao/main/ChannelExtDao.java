package com.hx.cms.dao.main;

import com.hx.cms.entity.main.ChannelExt;
import com.hx.common.hibernate3.Updater;

public interface ChannelExtDao {
	public ChannelExt save(ChannelExt bean);

	public ChannelExt updateByUpdater(Updater<ChannelExt> updater);
}