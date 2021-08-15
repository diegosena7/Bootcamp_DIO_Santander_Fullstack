package one.digitalinnovation.personapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Usamos a classe PersonMapper que faz a conversão do nosso objeto Entity pata DTO
 * Ela é chamada através da biblioteca MapStruct
 * Usado o @AllArgsConstructor(onConstructor = @__(@Autowired)) para injetar as dependências
 * e criar os construtores
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    /**
     * Método responsável por criar um objeto no BD
     * @param personDTO
     * @return
     */
    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    }

    /**
     * Método responsável por buscar todos os objetos do BD
     * @return
     */
    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Método responsável por buscar um objeto pelo id
     * @param id
     * @return
     * @throws PersonNotFoundException
     */
    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }

    /**
     * Método responsável por deletar o objeto pelo id informado
     * @param id
     * @throws PersonNotFoundException
     */
    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    /**
     * Método responsável por atualizar o objeto pelo id informado
     * @param id
     * @param personDTO
     * @return
     * @throws PersonNotFoundException
     */
    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
    }

    /**
     * Método responsável por verificar se o id informado para deletar/atualizar existe no BD
     * @param id
     * @return
     * @throws PersonNotFoundException
     */
    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    /**
     * Método responsável por criar a mensagem de erro ao usuário em caso de id não encontrado
     * para realizar a exclusão/atualização do objeto.
     * @param id
     * @param message
     * @return
     */
    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
