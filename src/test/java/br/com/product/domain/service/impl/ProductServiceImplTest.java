package br.com.product.domain.service.impl;

import br.com.product.domain.exception.model.BusinessException;
import br.com.product.domain.model.Group;
import br.com.product.domain.model.Product;
import br.com.product.domain.repository.ProductRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductServiceImplTest {

    private static final String MOCK_ID = "10";

    @Mock
    ProductRepository repository;

    @Mock
    GroupServiceImpl serviceImplGroup;

    @InjectMocks
    ProductServiceImpl service;

    @Test
    void testFindById() {
        when(repository.findById(Mockito.anyString())).thenReturn(Optional.of(new Product()));

        Product entity = service.findById(Mockito.anyString());
        assertNotNull(entity);
        verify(repository, times(1)).findById(Mockito.anyString());
    }

    @Test
    void testFindAll() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Product()));

        List<Product> list = service.findAll();
        assertNotNull(list);
        verify(repository, times(1)).findAll();
    }

    @Test
    void testSave() {
        when(repository.save(Mockito.any())).thenReturn(request());
        when(serviceImplGroup.findById(MOCK_ID)).thenReturn(new Group(MOCK_ID));

        Product entity = service.save(request());
        assertNotNull(entity);
        verify(repository, times(1)).save(Mockito.any());
    }

    private Product request() {
        var request = new Product();
        request.setGroup(new Group(MOCK_ID));
        return request;
    }

    @Test
    void testDeleteById() {
        when(repository.existsById("1")).thenReturn(Boolean.FALSE);
        BusinessException exception = assertThrows(BusinessException.class, () -> {
            service.deleteById("1");
        }, "exception is null");
        assertNotNull(exception);
    }
}
