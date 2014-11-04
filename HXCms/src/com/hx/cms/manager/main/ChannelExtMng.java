package com.hx.cms.manager.main;

import com.hx.cms.entity.main.Channel;
import com.hx.cms.entity.main.ChannelExt;

public interface ChannelExtMng {
	public ChannelExt save(ChannelExt ext, Channel channel);

	public ChannelExt update(ChannelExt ext);
}