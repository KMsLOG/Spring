package com.ssafy.mvc.model.dto;

public class Video {
	int youtubeId;
	String title;
	String fitPartName;
	String channelName;
	String url;
	int viewCnt = 0;
	
	public Video() {}

	public Video(int youtubeId, String title, String fitPartName, String channelName,String url, int viewCnt) {
		super();
		this.youtubeId = youtubeId;
		this.title = title;
		this.fitPartName = fitPartName;
		this.channelName = channelName;
		this.url = url;
		this.viewCnt = viewCnt;
	}

	public Video(String title, String fitPartName, String channelName,String url) {
		super();
		this.title = title;
		this.fitPartName = fitPartName;
		this.channelName = channelName;
		this.url = url;
	}
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getYoutubeId() {
		return youtubeId;
	}

	public void setYoutubeId(int youtubeId) {
		this.youtubeId = youtubeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFitPartName() {
		return fitPartName;
	}

	public void setFitPartName(String fitPartName) {
		this.fitPartName = fitPartName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	
}
