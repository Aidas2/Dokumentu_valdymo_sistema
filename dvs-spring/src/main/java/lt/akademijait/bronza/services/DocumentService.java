package lt.akademijait.bronza.services;

import lt.akademijait.bronza.repositories.DocTypeRepository;
import lt.akademijait.bronza.repositories.DocumentRepository;
import lt.akademijait.bronza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocTypeRepository docTypeRepository;
    @Autowired
    private UserRepository userRepository;








}
