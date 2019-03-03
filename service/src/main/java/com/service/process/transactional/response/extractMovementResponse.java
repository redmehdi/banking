package com.service.process.transactional.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.service.entities.dto.RecordDto;

public class extractMovementResponse {

	private String total;

	private List<RecordDto> movimientos;

	public extractMovementResponse(String total, List<RecordDto> movimientos) {
		this.total = total;
		this.movimientos = movimientos;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
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
