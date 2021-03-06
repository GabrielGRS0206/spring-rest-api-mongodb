package br.com.product.domain.exception.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

@Schema
@JsonInclude(Include.NON_NULL)
public class Error {

    @Schema(example = "404", description = "Invalid request")
    private Integer status;

    @Schema(example = "2020-01-01 13:30:00", description = "Date hour error")
    private LocalDateTime dataHora;

    @Schema(example = "invalid request", description = "Message example")
    private String message;

    @Schema(example = "fields invalids", description = "Message error example")
    private String mensageError;
    private List<Field> fields;

    public Error() {
        super();
    }

    public Error(Integer status, LocalDateTime dataHora, String message, List<Field> fields) {
        super();
        this.status = status;
        this.dataHora = dataHora;
        this.message = message;
        this.fields = fields;
    }

    public Error(Integer status, LocalDateTime dataHora, String message, String messageErro, List<Field> fields) {
        super();
        this.status = status;
        this.dataHora = dataHora;
        this.message = message;
        this.fields = fields;
        this.mensageError = messageErro;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMensageError() {
        return mensageError;
    }

    public void setMensageError(String mensageError) {
        this.mensageError = mensageError;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }


}
