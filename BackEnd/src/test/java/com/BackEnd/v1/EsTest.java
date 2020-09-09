package com.BackEnd.v1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.backend.v1.data.es.WedulPlay;
import com.backend.v1.repository.es.WedulPlayRepository;
import com.backend.v1.service.es.WedulPlayService;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {
	WedulPlayService wedulPlayService;

	@Autowired
	@Qualifier("wedulPlayRepository")
	WedulPlayRepository wedulPlayRepository;

	@Before
	public void setup() {
		wedulPlayService = new WedulPlayService(wedulPlayRepository);
	}

	@Test
	public void whenValidParameter_thenSuccessFind() {
		List<WedulPlay> list = wedulPlayService.findAll();
		System.out.println("list:" + list);
		assertNotNull(list);
	}

	@Test
	public void whenValidParameter_thenSuccessSave() {
		Exception ex = null;

		try {
			wedulPlayService.save(
					WedulPlay.builder().title("안녕 이건 테스트야").user("위들").startAt(1242421424).endAt(23214124).build());
		} catch (Exception exception) {
			ex = exception;
		}

		assertTrue(null == ex);
	}
}
