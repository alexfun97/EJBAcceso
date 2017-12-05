package entity;

import entity.Genero;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-22T10:57:41")
@StaticMetamodel(Cantante.class)
public class Cantante_ { 

    public static volatile SingularAttribute<Cantante, Date> fechaNac;
    public static volatile SingularAttribute<Cantante, Genero> genero;
    public static volatile SingularAttribute<Cantante, Integer> id;
    public static volatile SingularAttribute<Cantante, String> nombre;
    public static volatile SingularAttribute<Cantante, String> nacionalidad;

}