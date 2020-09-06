package com.backend.v1.repository.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.backend.v1.data.es.WedulPlay;

/**
 * study
 *
 * @author wedul
 * @since 2019-02-09
 **/
@Repository("wedulPlayRepository")
public interface WedulPlayRepository extends ElasticsearchRepository<WedulPlay, String> {

	WedulPlay findByUser(String user);

}
