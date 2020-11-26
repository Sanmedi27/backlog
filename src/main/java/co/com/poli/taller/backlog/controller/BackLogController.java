package co.com.poli.taller.backlog.controller;

import co.com.poli.taller.backlog.domain.BackLog;
import co.com.poli.taller.backlog.model.ErrorMessage;
import co.com.poli.taller.backlog.service.BackLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/backlog")
public class BackLogController {
    private final BackLogService backLogService;

    public BackLogController(BackLogService backLogService) {
        this.backLogService = backLogService;
    }

    @GetMapping
    public ResponseEntity<List<BackLog>> listBackLog() {
        List<BackLog> backLogs = backLogService.getAllBackLogs();
        if (backLogs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(backLogs);
    }

    @PostMapping
    public ResponseEntity<BackLog> createBackLog(@Valid @RequestBody BackLog backLog, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        BackLog backLogDB = backLogService.createBackLog(backLog);
        return ResponseEntity.status(HttpStatus.CREATED).body(backLogDB);
    }

    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            json = objectMapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
