package lt.akademijait.bronza.services;

import lt.akademijait.bronza.repositories.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocTypeService {

    @Autowired
    private DocumentTypeRepository docTypeRepository;

    //@Transactional(readOnly = true)
}
