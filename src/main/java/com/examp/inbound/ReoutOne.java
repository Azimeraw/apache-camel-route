package com.examp.inbound;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
@Component
@Slf4j
public class ReoutOne extends RouteBuilder {
    public static JaxbDataFormat jaxbFormat(Class<?> clazz) {
        try {
            return new JaxbDataFormat(JAXBContext.newInstance(clazz));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
}}
    @Override
    public void configure() throws Exception {
        from("direct:start")
                .process(exchange -> {
                    // Your custom processing logic goes here
                    String body = exchange.getIn().getBody(String.class);
                    body = "Processedppppppppppppppppppppppppppppppppppppppppppppppp: " + body;
                    exchange.getIn().setBody(body);
                    log.info(body); // Log the updated body
                })
                .to("direct:end");
        System.out.println("ppppppppppppppppppppppppppppppppppppppppppppppppppp");
    }
}
