package com.movies.moviesapp.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestController
public class UniversalErrorHandler {

    @Bean
    public ErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes() {
            @Override
            public Map<String, Object> getErrorAttributes(WebRequest requestAttributes, ErrorAttributeOptions includeStackTrace) {
                Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
                errorAttributes.remove("timestamp");
                errorAttributes.remove("path");

                if (errorAttributes.get("error") == "Not Found") {
                    errorAttributes.remove("error");
                    errorAttributes.put("status","Not Found");
                    errorAttributes.put("message","Object not found");
                    errorAttributes.put("response",null);
                }
                if (errorAttributes.get("error") == "Method Not Allowed") {
                    errorAttributes.remove("error");
                    errorAttributes.put("status","Not allowed");
                    errorAttributes.put("message","Method not allowed for requested resource");
                    errorAttributes.put("response",null);
                }

                if (errorAttributes.get("error") == "Internal Server Error") {
                    errorAttributes.remove("error");
                    errorAttributes.put("status","Internal Server Error");
                    errorAttributes.put("message","Invalid input, correct the structure of the object");
                    errorAttributes.put("response",null);
                }

                return errorAttributes;
            }

        };
    }
}
