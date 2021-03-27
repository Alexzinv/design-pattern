package com.alex.designpattern.Prototype.weekreport;

import java.io.*;

public class WeeklyLog implements Cloneable{
	private Attachment attachment;
	private String name;
	private String date;
	private String content;

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "WeeklyLog{" +
				"attachment=" + attachment +
				", name='" + name + '\'' +
				", date='" + date + '\'' +
				", content='" + content + '\'' +
				'}';
	}

	@Override
	protected Object clone() {
		try {
			Object o = super.clone();
			return o;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	// 深拷贝 方式二：对象序列化实现  <推荐>
	public WeeklyLog deepClone(){
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			// 序列化
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);    // 把当前对象一对象流方式输出

			// 反序列化
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			WeeklyLog copyObj = (WeeklyLog) ois.readObject();
			return copyObj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(bis != null)
					bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(bos != null)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
