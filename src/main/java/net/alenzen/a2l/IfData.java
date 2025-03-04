package net.alenzen.a2l;

import java.io.IOException;
import java.util.Objects;


public class IfData implements IA2LWriteable {
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public void writeTo(A2LWriter writer) throws IOException {
		writer.writeln(content);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		IfData ifData = (IfData) o;
		return Objects.equals(content, ifData.content);
	}

	@Override
	public int hashCode() {
		return Objects.hash(content);
	}
}
