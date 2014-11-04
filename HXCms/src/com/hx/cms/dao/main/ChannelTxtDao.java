package com.hx.cms.dao.main;

import com.hx.cms.entity.main.ChannelTxt;
import com.hx.common.hibernate3.Updater;

public interface ChannelTxtDao {
	public ChannelTxt findById(Integer id);

	public ChannelTxt save(ChannelTxt bean);

	public ChannelTxt updateByUpdater(Updater<ChannelTxt> updater);
}