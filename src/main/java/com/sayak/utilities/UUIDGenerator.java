package com.sayak.utilities;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.hibernate.type.descriptor.java.UUIDTypeDescriptor;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Properties;
import java.util.UUID;

public class UUIDGenerator implements IdentifierGenerator, Configurable {
    public static final String UUID_NAMESPACE = "uuid_namespace";

    private String namespace;
    private UUIDTypeDescriptor.ValueTransformer valueTransformer;

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws RuntimeException {
        namespace = String.valueOf(params.get(UUID_NAMESPACE));
        if (Objects.equals(namespace, "null")) {
            namespace = "";
        }

        if (UUID.class.isAssignableFrom(type.getReturnedClass())) {
            valueTransformer = UUIDTypeDescriptor.PassThroughTransformer.INSTANCE;
        } else if (String.class.isAssignableFrom(type.getReturnedClass())) {
            valueTransformer = UUIDTypeDescriptor.ToStringTransformer.INSTANCE;
        } else if (byte[].class.isAssignableFrom(type.getReturnedClass())) {
            valueTransformer = UUIDTypeDescriptor.ToBytesTransformer.INSTANCE;
        } else {
            throw new RuntimeException("Unanticipated return type [" + type.getReturnedClass().getName() + "] for UUID conversion");
        }
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws RuntimeException {
        return valueTransformer.transform(UUID.nameUUIDFromBytes((namespace + OffsetDateTime.now().toEpochSecond()).getBytes()));
    }
}
