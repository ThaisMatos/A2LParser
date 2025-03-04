package net.alenzen.a2l;

import java.util.Objects;

import net.alenzen.a2l.enums.AddrType;
import net.alenzen.a2l.enums.DataType;
import net.alenzen.a2l.enums.IndexOrder;

public class AxisRescaleXYZ45 implements IA2LDimensionWriteable {
	private long position;
	private DataType datatype;
	private long maxNumberOfRescalePairs;
	private IndexOrder indexorder;
	private AddrType addressing;

	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	public DataType getDatatype() {
		return datatype;
	}

	public void setDatatype(DataType datatype) {
		this.datatype = datatype;
	}

	public long getMaxNumberOfRescalePairs() {
		return maxNumberOfRescalePairs;
	}

	public void setMaxNumberOfRescalePairs(long maxNumberOfRescalePairs) {
		this.maxNumberOfRescalePairs = maxNumberOfRescalePairs;
	}

	public IndexOrder getIndexorder() {
		return indexorder;
	}

	public void setIndexorder(IndexOrder indexorder) {
		this.indexorder = indexorder;
	}

	public AddrType getAddressing() {
		return addressing;
	}

	public void setAddressing(AddrType addressing) {
		this.addressing = addressing;
	}

	@Override
	public IA2LWriteable getA2lWritable(String dimension) {
		return (A2LWriter writer) -> {
			writer.writelnSpaced("AXIS_RESCALE_" + dimension, Long.toString(position), datatype.name(),
					Long.toString(maxNumberOfRescalePairs), indexorder.name(), addressing.name());
		};
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AxisRescaleXYZ45 that = (AxisRescaleXYZ45) o;
		return position == that.position && maxNumberOfRescalePairs == that.maxNumberOfRescalePairs
				&& datatype == that.datatype && indexorder == that.indexorder && addressing == that.addressing;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position, datatype, maxNumberOfRescalePairs, indexorder, addressing);
	}
}
