package lt.akademijait.bronza.entities;

import javax.persistence.*;

@Entity
@Table(name="documents", uniqueConstraints = {@UniqueConstraint(columnNames = "title")})
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;




    








}
