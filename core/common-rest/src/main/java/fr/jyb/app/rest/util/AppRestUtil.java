package fr.jyb.app.rest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import fr.jyb.app.rest.converter.ZonedDateTimeDeSerializer;
import fr.jyb.app.rest.converter.ZonedDateTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 *
 */
@Component
@Slf4j
public class AppRestUtil {

    /**
     *
     * @return
     */
    public String generateRandomId() {
        return  UUID.randomUUID().toString();
    }

    /**
     *
     * @param request
     * @param response
     */
    public void setResponseHttpHeaders(HttpServletRequest request, HttpServletResponse response) {
        if ( Objects.nonNull(request.getAttribute("X-TRANSACTION-ID")) ) {
            response.setHeader("X-TRANSACTION-ID", request.getAttribute("X-TRANSACTION-ID").toString());
        } else if ( Objects.nonNull(request.getHeader("X-TRANSACTION-ID")) ) {
            response.setHeader("X-TRANSACTION-ID", request.getHeader("X-TRANSACTION-ID"));
        }

        if ( Objects.nonNull(request.getAttribute("X-APP-CORRELATION-ID")) ) {
            response.setHeader("X-APP-CORRELATION-ID", request.getAttribute("X-APP-CORRELATION-ID").toString());
        } else if ( Objects.nonNull(request.getHeader("X-APP-CORRELATION-ID")) ) {
            response.setHeader("X-APP-CORRELATION-ID", request.getHeader("X-APP-CORRELATION-ID"));
        }
    }

    public Optional<String> convertObjectToJson(Object object) {
        SimpleModule module = new SimpleModule();
        module.addSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer());
        module.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeSerializer());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);

        try {
            String jsonInString = objectMapper.writeValueAsString(object);
            return Optional.of(jsonInString);
        } catch (Exception e) {
            log.warn(String.format("Error while parsing object %s to json", object), e);
            return Optional.empty();
        }
    }
}
