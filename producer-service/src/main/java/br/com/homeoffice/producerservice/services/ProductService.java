package br.com.homeoffice.producerservice.services;

import dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static constants.RabbitMQConstants.EXG_NAME_MARKETPLACE;
import static constants.RabbitMQConstants.RK_PRODUCT_LOG;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {
    private final RabbitTemplate rabbitTemplate;

    public void createProduct(ProductDTO productDTO){
    log.info("Sending a messa to exchange "+ productDTO.toString());
    rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, productDTO);
    }
}
