package exercise.controller;

import exercise.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(@RequestBody ContactCreateDTO contactData) {
        var contact = toEntity(contactData); // Сначала в Entity
        contactRepository.save(contact);
        var contactDTO = toDTO(contact); // Потом в DTO
        return contactDTO;
    }

    private ContactDTO toDTO(Contact contact) {
        var dto = new ContactDTO();
        dto.setId(contact.getId());
        dto.setFirstName(contact.getFirstName());
        dto.setLastName(contact.getLastName());
        dto.setPhone(contact.getPhone());
        dto.setCreatedAt(contact.getCreatedAt());
        dto.setUpdatedAt(contact.getUpdatedAt());
        return dto;
    }

    private Contact toEntity(ContactCreateDTO contactDto) {
        var post = new Contact();
        post.setFirstName(contactDto.getFirstName());
        post.setLastName(contactDto.getLastName());
        post.setPhone(contactDto.getPhone());
        return post;
    }
    // END
}
