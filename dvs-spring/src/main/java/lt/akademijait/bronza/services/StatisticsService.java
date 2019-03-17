package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.statistics.DocumentCountGetCommand;
import lt.akademijait.bronza.entities.Document;
import lt.akademijait.bronza.entities.DocumentType;
import lt.akademijait.bronza.entities.User;
import lt.akademijait.bronza.enums.DocumentState;
import lt.akademijait.bronza.repositories.DocumentRepository;
import lt.akademijait.bronza.repositories.DocumentTypeRepository;
import lt.akademijait.bronza.repositories.UserGroupRepository;
import lt.akademijait.bronza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Transactional
    public Long getAllUsersCount(){
        return (long) userRepository.findAll().size();
    }

    @Transactional
    public Long getAllDocumentsCount(){
        return (long) documentRepository.findAll().size();
    }

    @Transactional
    public List<Long> getAllDocumentsandUsersCount(){
        List<Long> count = new ArrayList<>();

        count.add((long) userRepository.findAll().size());
        count.add((long) documentRepository.findAll().size());


        return count;
    }

    @Transactional
    public DocumentCountGetCommand getCountByDocumentType(String docType){

        List<String> count = new ArrayList<>();
        List<String> submit = new ArrayList<>();
        List<String> accept = new ArrayList<>();
        List<String> reject = new ArrayList<>();

        for (Document document:documentRepository.findAll()){
            if (document.getDocumentType().getTitle().equals(docType)){
                count.add(document.getTitle());
                if (document.getDocumentState().equals(DocumentState.SUBMITTED)){
                    submit.add(document.getTitle());
                } else if (document.getDocumentState().equals(DocumentState.CONFIRMED)){
                    accept.add(document.getTitle());
                } else if (document.getDocumentState().equals(DocumentState.REJECTED)){
                    reject.add(document.getTitle());
                }
            }
        }

        return new DocumentCountGetCommand(
                count.size(),
                submit.size(),
                accept.size(),
                reject.size());
    }
}
