package com.backend.v1.repository.order;

import java.util.List;

public interface OrderCustomRepository {
	List<String> findAllOrderCodeByUserCode(String userCode);
}
