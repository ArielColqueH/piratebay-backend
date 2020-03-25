package bo.edu.ucb.sis.piratebay;

import org.apache.ibatis.annotations.Insert;

public interface ClientMapper {
    @Insert("Insert into client (first_name,last_name,birth_date,status)\n"+
            "values(#{firstName},#{lastName},#{birthDate},true)")
    void create(ClientDto clientDto);
}
