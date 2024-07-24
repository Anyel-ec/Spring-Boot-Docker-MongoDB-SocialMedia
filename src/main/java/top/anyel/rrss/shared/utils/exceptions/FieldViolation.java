package top.anyel.rrss.shared.utils.exceptions;

import lombok.Builder;

@Builder
public record FieldViolation(String field, String message, Object rejValue) implements ApiError {
    @Override
    public String message() {
        return message;
    }
}