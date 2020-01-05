package com.example.demojpa.module.system.service.mapper;

        import com.example.demojpa.module.system.entity.Person;
        import com.example.demojpa.module.system.service.dto.PersonDto;
        import org.mapstruct.Mapper;
        import org.mapstruct.ReportingPolicy;

        @Mapper(componentModel = "spring", uses = Person.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
        public interface PersonMapper {

        PersonDto toDto(Person person);
        }
