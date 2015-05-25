package org.taoran.course.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
	public static final String defaultMenu = "------------------------\n" + "�Ƽ�: �ܱ�����\n"
			+ "------------------------\n" + "1 ���ܷ��� 2 ������\ue03e\n"
			+ "3 �ܱ����� 4 ����Lemon\n" + "5 ��ֵ��� ǿ����Ϯ" + Tools.emoji(0x1F525)
			+ "\n" + "6 �����Ƽ� 7 ����Ц��\n" + "8 ������¼ 9 ��������\n"+"����ʵ�ù������ڿ��������ڴ���\n\n"
			+ "��ֱ�ӵ���˵�����";
	public static String welcome = "�ף���ô���ڲ����أ�\ue11b\n\n�������������ֵĺð��֣��������ɣ�ôô��~";

	/**
	 * �����㲥ʹ��ָ��
	 * 
	 * @return
	 */
	public static String getMusicUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\ue03e").append("���������ָ��").append("\n\n");
		buffer.append("�ظ�������+����").append("\n");
		buffer.append("���磺������ĭ").append("\n");
		buffer.append("���ߣ�������ĭ@������(����ָ������Ŷ)").append("\n");
		buffer.append("������������ ����һ���� Ȼ��Ϳ���ת����������").append("\n\n");
		buffer.append("�ظ���?����ʾ���˵�");
		return buffer.toString();
	}

	/**
	 * ���������
	 * 
	 * @return
	 */
	public static String getJoke() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("/::D").append("Ц��ʹ��ָ��").append("\n\n");
		buffer.append("�ظ���Ц�������ɡ�").append("\n\n");
		buffer.append("�ظ���?����ʾ���˵�");

		return buffer.toString();
	}

	/**
	 * ����Ԥ��ʹ��ָ��
	 * 
	 * @return
	 */
	public static String getWeatherUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("������ѯָ��").append("\n\n");
		buffer.append("�ظ�������+����").append("\n");
		buffer.append("���磺��������").append("\n");
		buffer.append("�ظ���?����ʾ���˵�");
		return buffer.toString();
	}

	/**
	 * emoji����ת��(hex -> utf-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}

	/**
	 * ��ע��ʾ��
	 * 
	 * @return
	 */
	public static String getSubscribeMsg() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("���Ƿ��й����������Ĵ���ATM����������KTV�򹫲޵ľ�����").append("\n\n");
		buffer.append("���Ƿ��й�����������Ѱ��ʳ�����ֳ����ľ�����").append("\n\n");
		buffer.append("�ܱ�����Ϊ���ĳ��б��ݻ�����Ϊ���ṩרҵ���ܱ�����ָ�ϣ��ظ�����������ʼ����ɣ�");
		return buffer.toString();
	}

	/**
	 * �ܱ�����ָ��
	 * 
	 * @return
	 */
	public static String getLocationUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\ue138").append("�ܱ�����ʹ��˵��").append("\n\n");
		buffer.append("�����ȷ��͵���λ��Ŷ").append("\n");
		buffer.append("������ڵײ��ġ�+����ť������λ��").append("\n");
		buffer.append("Ȼ��ָ���ؼ�������").append("\n");
		buffer.append("��ʽ������+�ؼ���\n���磺������ʳ����������վ����������").append("\n");
		buffer.append(Tools.emoji(0x1F525) + "С��ʾ���е�����ͼŶ����Ҳ����·���ˡ�"
				+ Tools.emoji(0x1F525));
		return buffer.toString();
	}

	/**
	 * ����ʹ��ָ��
	 * 
	 * @return
	 */
	public static String getTranslateUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(emoji(0xe148)).append("���ܷ���ʹ��ָ��").append("\n\n");
		buffer.append("֧�����·��뷽��").append("\n");
		buffer.append("    �� -> Ӣ").append("\n");
		buffer.append("    Ӣ -> ��").append("\n");
		buffer.append("    �� -> ��").append("\n\n");
		buffer.append("ʹ��ʾ����").append("\n");
		buffer.append("    ���������й���").append("\n");
		buffer.append("    ����dream").append("\n");
		buffer.append("    ���뤵�褦�ʤ�").append("\n\n");
		buffer.append("�ٶȷ��� ����֧��");
		return buffer.toString();
	}

	/**
	 * ������ѯʹ��ָ��
	 * 
	 * @return
	 */
	public static String getBusUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("������ѯʹ��˵��").append("\n\n");
		buffer.append("����1�����ͳ�����·").append("\n");
		buffer.append("����2��ָ���ؼ�������").append("\n");
		buffer.append("��ʽ�����йؼ���\n���磺����135·").append("\n");
		buffer.append("ע��������δ�����ڼ䣬���롱��������վ��0.0").append("\n");
		return buffer.toString();
	}

	/**
	 * ��Ϸʹ��ָ��
	 * 
	 * @return
	 */
	public static String getGameUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("����Ϸʹ��˵��").append("\n\n");
		buffer.append("����1�����ͷ������").append("\n");
		buffer.append("������ڵײ��ġ�+����ť��ѡ�񡰷��롱���㡰���͡�").append("\n\n");
		buffer.append("����2��ָ���ؼ�������").append("\n");
		return buffer.toString();
	}

	/**
	 * �������ʹ��ָ��
	 * 
	 * @return
	 */
	public static String getFaceUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n");
		buffer.append("�������ϴ����˻����������Ƭ").append("\n");
		buffer.append("������ڵײ��ġ�+����ť������ͼƬ��");
		return buffer.toString();
	}

	/**
	 * ����ʹ��ָ��
	 * 
	 * @return
	 */
	public static String getChatUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\ue307").append("Lemon��������").append("\n\n");
		buffer.append("Lucene���漼��֧��").append("\n");
		buffer.append("�Ͻ����԰�(>^��^<)").append("\n");
		buffer.append("������������������").append("\n");

		return buffer.toString();
	}

	/**
	 * �����������
	 * 
	 * @return
	 */
	public static String getSuggestUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("��ϵ����").append("\n\n");
		buffer.append("����1����ֱ������").append("\n");
		buffer.append("����2����ϵ����Ա").append("\n");
		buffer.append("Email:932191671@qq.com\nQQ:932191671").append("\n");
		return buffer.toString();
	}

	public static String recommendMusic() {
		String respContent = null;
		respContent = "\ue110 �����Ƽ�1 �赥FATE\n"
				+ "���� <a href=\"http://v.yinyuetai.com/video/2268593\">brave shine(UBW op2) - Aimer</a>\n\n"
				+ "1 <a href=\"http://music.163.com/#/song?id=29550217\">ideal white - �cҰ�ޤ���</a>\n"
				+ "2 <a href=\"http://music.163.com/#/song?id=29736027\">believe - Kalafina</a>\n"
				+ "3 <a href=\"http://music.163.com/#/song?id=560108\">MEMORIA - �{��������</a>\n"
				+ "4 <a href=\"http://music.163.com/#/song?id=608404\">oath sign - LISA</a>\n"
				+ "5 <a href=\"http://music.163.com/#/song?id=756338\">to the beginning - Kalafina</a>\n\n"
				+ "\ue110 �����Ƽ�2 ��������\n"
				+ "���� <a href=\"http://music.163.com/#/song?id=30953009\">see you again-Wiz Khalifa/Charlie Puth</a>\n\n"
				+ "1 <a href=\"http://music.163.com/#/song?id=579954\">�������`�����`����� - �������</a>\n"
				+ "2 <a href=\"http://music.qq.com/qqmusic.html?id=5034876\">You Are Beautiful - James Blunt </a>\n"
				+ "3 <a href=\"http://music.qq.com/qqmusic.html?id=4825889\">ʱ������ - ����Ψ</a>\n"
				+ "4 <a href=\"http://music.qq.com/qqmusic.html?id=442823\">Live Like You're Dying - Lenka</a>\n"
				+ "5 <a href=\"http://music.163.com/#/song?id=27674128\">������ե��`����󥯥å��` - AKB48</a>\n"
				+ "\n�ظ�music��book��ȡָ�������Ƽ�Mua~";
		return respContent;
	}

	public static String getRecommendUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\ue126").append("�Ƽ�����ʹ��˵��").append("\n\n");
		buffer.append("�ظ�Music�Ƽ�����").append("\n");
		buffer.append("�ظ�Book�Ƽ�����").append("\n");
		return buffer.toString();
	}

	public static boolean isQQFace(String content) {
		boolean result = false;

		// �ж�QQ�����������ʽ
		String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";

		Pattern p = Pattern.compile(qqfaceRegex);
		Matcher m = p.matcher(content);
		if (m.matches()) {
			result = true;
		}
		return result;
	}

	public static String getYuluUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("���Լ���һ�����õ��ˣ��Ӷ��鿪ʼ��").append("\n\n");
		buffer.append("�ظ���ϯĽ�ݡ����ߡ���¼��").append("\n");
		buffer.append("Tip���ظ�next����ȡ��һ��").append("\n");
		return buffer.toString();
	}

	public static String getTuijian() {
		String respContent = null;
		respContent = "\ue110 �����Ƽ�1 �赥FATE\n"
				+ "���� <a href=\"http://v.yinyuetai.com/video/2268593\">brave shine(UBW op2) - Aimer</a>\n\n"
				+ "1 <a href=\"http://music.163.com/#/song?id=29550217\">ideal white - �cҰ�ޤ���</a>\n"
				+ "2 <a href=\"http://music.163.com/#/song?id=29736027\">believe - Kalafina</a>\n"
				+ "3 <a href=\"http://music.163.com/#/song?id=560108\">MEMORIA - �{��������</a>\n"
				+ "4 <a href=\"http://music.163.com/#/song?id=608404\">oath sign - LISA</a>\n"
				+ "5 <a href=\"http://music.163.com/#/song?id=756338\">to the beginning - Kalafina</a>\n\n"
				+ "\ue110 �����Ƽ�2 ��������\n"
				+ "���� <a href=\"http://music.163.com/#/song?id=30953009\">see you again-Wiz Khalifa/Charlie Puth</a>\n\n"
				+ "1 <a href=\"http://music.163.com/#/song?id=579954\">�������`�����`����� - �������</a>\n"
				+ "2 <a href=\"http://music.qq.com/qqmusic.html?id=5034876\">You Are Beautiful - James Blunt </a>\n"
				+ "3 <a href=\"http://music.qq.com/qqmusic.html?id=4825889\">ʱ������ - ����Ψ</a>\n"
				+ "4 <a href=\"http://music.qq.com/qqmusic.html?id=442823\">Live Like You're Dying - Lenka</a>\n"
				+ "5 <a href=\"http://music.163.com/#/song?id=27674128\">������ե��`����󥯥å��` - AKB48</a>\n";
		return respContent;
	}
}
