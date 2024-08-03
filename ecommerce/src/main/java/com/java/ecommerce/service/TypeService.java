package com.java.ecommerce.service;

import com.java.ecommerce.dto.response.TypeResponse;
import com.java.ecommerce.exception.AppException;
import com.java.ecommerce.exception.ErrorCode;
import com.java.ecommerce.mapper.TypeMapper;
import com.java.ecommerce.repository.TypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TypeService {
    TypeRepository typeRepository;
    TypeMapper typeMapper;

    public TypeResponse getType(String id){
        return typeMapper.toTypeResponse(typeRepository.findById(id)
                .orElseThrow(()-> new AppException(ErrorCode.TYPE_NOT_EXISTED)));
    }

    public List<TypeResponse> getAllType(){
        return typeRepository.findAll().stream()
                .map(typeMapper::toTypeResponse).toList();
    }
}
