package smr.shop.ticket.service.dto.ticketMessage.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTicketMessageRequest {
    @NotNull(message = "Ticket ID is required!")
    private UUID ticketId;
    @NotBlank(message = "Message is required!")
    private String message;
}