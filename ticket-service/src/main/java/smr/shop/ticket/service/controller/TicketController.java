package smr.shop.ticket.service.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smr.shop.libs.common.dto.response.EmptyResponse;
import smr.shop.ticket.service.dto.request.CreateTicketRequest;
import smr.shop.ticket.service.dto.response.TicketResponse;
import smr.shop.ticket.service.model.valueobject.TicketStatus;
import smr.shop.ticket.service.service.TicketService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/1.0/tickets")
public class TicketController {
    TicketService ticketService;

    @GetMapping("/{id}")
    public TicketResponse getById(@PathVariable UUID id, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return ticketService.getById(id, page);
    }

    @GetMapping
    public List<TicketResponse> getAllUserTickets(@RequestParam(value = "page", defaultValue = "0") Integer page) {
        return ticketService.getAllUserTickets(page);
    }

    @PostMapping
    public CreateTicketRequest add(@RequestBody CreateTicketRequest request) {
        return ticketService.createTicket(request);
    }

    @PutMapping("/update/{id}/")
    public ResponseEntity<EmptyResponse> updateStatus(@PathVariable UUID id, @RequestBody TicketStatus ticketstatus) {
        ticketService.updateTicketStatus(id, ticketstatus);
        EmptyResponse response = EmptyResponse.builder()
                .message("updated success")
                .build();
        return ResponseEntity.ok().body(response);
    }

}