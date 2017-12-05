package entity;

import entity.Cantante;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-22T10:57:41")
@StaticMetamodel(Genero.class)
public class Genero_ { 

    public static volatile SingularAttribute<Genero, Integer> añoCreacion;
    public static volatile CollectionAttribute<Genero, Cantante> cantanteCollection;
    public static volatile SingularAttribute<Genero, Integer> id;
    public static volatile SingularAttribute<Genero, String> nombre;

}