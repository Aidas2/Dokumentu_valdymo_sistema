package lt.akademijait.bronza.services;

import lt.akademijait.bronza.repositories.DocTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocTypeService {

    @Autowired
    private DocTypeRepository docTypeRepository;

    //@Transactional(readOnly = true)
}
