package org.taoran.course.message.req;

/**
 * ��Ƶ��Ϣ
 * 
 * @author ����
 * @date 2014-4-7
 */
public class VideoMessage extends BaseMessage {
	// ��Ƶý��Id
	private String MediaId;
	// ��Ƶ��Ϣ����ͼ��ý��Id
	private String ThumbMediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
