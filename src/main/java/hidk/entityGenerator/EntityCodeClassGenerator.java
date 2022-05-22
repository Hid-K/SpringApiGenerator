package hidk.entityGenerator;

import hidk.entityGenerator.entity.Entity;
import hidk.entityGenerator.javaEntityClassCodeGenerator.EntityClass;

import java.util.List;

public interface EntityCodeClassGenerator
{
    List<EntityClass> generateEntityClassesCode();
    String generateEntityClassCode( Entity entity );
}
