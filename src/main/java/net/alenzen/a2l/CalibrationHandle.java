package net.alenzen.a2l;

import java.io.IOException;
import java.util.List;

public class CalibrationHandle implements IA2LWriteable {
	private List<Long> handles;

	// optional parameters
	private String calibrationText;

	public List<Long> getHandles() {
		return handles;
	}

	public void setHandles(List<Long> handles) {
		this.handles = handles;
	}

	public String getCalibrationText() {
		return calibrationText;
	}

	public void setCalibrationText(String calibrationText) {
		this.calibrationText = calibrationText;
	}

	@Override
	public void writeTo(A2LWriter writer) throws IOException {
		writer.writelnBeginSpaced("CALIBRATION_HANDLE");
		writer.indent();
		
		if(handles != null && handles.size() > 0) {
			for(Long l : handles) {
				if(l != null) {
					writer.writeln("0x" + Long.toHexString(l));
				}
			}
		}
		
		if(calibrationText != null) {
			writer.writelnSpaced("CALIBRATION_HANDLE_TEXT", A2LWriter.toA2LString(calibrationText));
		}
		
		writer.dedent();
		writer.writelnEnd("CALIBRATION_HANDLE");
	}
}
