package com.sayak.tableschema;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

import static com.sayak.utilities.UUIDGenerator.UUID_NAMESPACE;

@MappedSuperclass
public class TableEntity {
    @Id
    @Column(columnDefinition = "uuid", updatable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "com.sayak.utilities.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = UUID_NAMESPACE,
                            value = "Sayak"
                    )
            }
    )
    private UUID hexId;

    private boolean deleted;

    public TableEntity(boolean deleted) {
        this.deleted = deleted;
    }

    public UUID getHexId() {
        return hexId;
    }

    public void setHexId(UUID hexId) {
        this.hexId = hexId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
