package modelo;

import testes.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroProdutos {
    public static void main(String[] args) {
        Produto celular = new Produto();

        celular.setNome("Xiaomi Redmi 9");
        celular.setDescricao("Muito bom");
        celular.setPreco(new BigDecimal("900"));

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("loja");

        EntityManager em = factory.createEntityManager();
        em.persist(celular);

       em.getTransaction().begin();
       em.persist(celular);
       em.getTransaction().commit();
       em.close();
    }
}
