package dev.top.controller.views;

public class CollegueView {

	private String name;

	private Integer score;

	private String url;

	public CollegueView(String name, Integer score, String url) {
		super();
		this.name = name;
		this.score = score;
		this.url = url;
	}

	public CollegueView() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
