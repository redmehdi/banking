package com.service.entities.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OperationalResponseDto {

	private BigDecimal total;

	private List<RecordDto> movimientos;

	public OperationalResponseDto(BigDecimal total, List<RecordDto> movimientos) {
		this.total = total;
		this.movimientos = movimientos;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<RecordDto> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<RecordDto> movimientos) {
		this.movimientos = movimientos;
	}

	void addMovimiento(final RecordDto recordDto) {
		if (movimientos == null)
			movimientos = new ArrayList<>();
		movimientos.add(recordDto);
	}

	@Override
	public String toString() {
		return String.format("OperationalResponseDto [total=%s, movimientos=%s]", total, movimientos);
	}

}
