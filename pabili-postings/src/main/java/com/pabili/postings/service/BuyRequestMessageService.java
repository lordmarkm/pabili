package com.pabili.postings.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.pabili.commons.service.BaseJpaService;
import com.pabili.postings.model.BuyRequestMessage;
import com.pabili.postings.service.custom.BuyRequestMessageServiceCustom;

/**
 * @author Mark Martinez, create Sep 14, 2015
 */
public interface BuyRequestMessageService extends BuyRequestMessageServiceCustom, BaseJpaService<BuyRequestMessage> {

    @Query("select b from BuyRequestMessage b where b.buyRequestHeader.id = ?1 and b.gopher.user.username = ?2 order by b.dateCreated asc")
    List<BuyRequestMessage> findByConversation(Long buyRequestHeaderId, String gopherUsername);

    /**
     * Wish there was a cleaner way to do this
     * The only other way I can think of is to just get all the buy request messages
     * and then prune them in java. Not sure which method is better, but this def'ly
     * retrieves less data
     * 
     * 
     * This was written for MySQL and might not work with other dbs!
     *
     * 
     * @param id
     * @return
     */
    @Query(nativeQuery = true, value = "select b.* from buy_request_msg b" +
            " inner join (select gopher_id, max(created) as max_created from buy_request_msg group by gopher_id)" +
            " groupedb on b.gopher_id = groupedb.gopher_id and b.created = groupedb.max_created" +
            " where b.buy_request_header_id = ?1")
    List<BuyRequestMessage> findLatestMessages(Long id);

}
