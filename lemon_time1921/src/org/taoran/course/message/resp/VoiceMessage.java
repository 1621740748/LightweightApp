package org.taoran.course.message.resp;

/**
 * ��Ӧ��Ϣ -> ������Ϣ
 * 
 * @author ����
 * @date 2015-4-7
 */
public class VoiceMessage extends BaseMessage {
	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}
}
