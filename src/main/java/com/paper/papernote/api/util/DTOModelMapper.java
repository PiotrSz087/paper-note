package com.paper.papernote.api.util;

import org.modelmapper.ModelMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.List;

public class DTOModelMapper extends RequestResponseBodyMethodProcessor {

    private static final ModelMapper modelMapper = new ModelMapper();

    public DTOModelMapper(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }


//    Zastępujemy metodę supportedParameter. Bez nadpisywania tej metody nasza nowa klasa zostanie zastosowana do
//    parametrów @RequestBody, tak jak klasa bazowa. Dlatego musimy go ulepszyć, aby zastosować tylko adnotacje @DTO.
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(DTO.class);
    }


}
