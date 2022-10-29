package testes;

import dao.CategoriaDao;
import dao.ProdutoDao;
import modelo.Categoria;
import modelo.Produto;
import utilJpa.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {
        cadastrarProduto();

        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getPreco());

        List<Produto> todosProdutos = produtoDao.buscarTodos();
        todosProdutos.forEach(p2 -> System.out.println(p.getNome()));

    }
        private static void cadastrarProduto () {
            Categoria celulares = new Categoria("CELULARES");
            Produto celular = new Produto("Xiaomi Redmi 9"
                    , "celualr de boa qualidade", new BigDecimal("900"), celulares);

            EntityManager em = JpaUtil.getEntityManager();
            ProdutoDao produtoDao = new ProdutoDao(em);
            CategoriaDao categoriaDao = new CategoriaDao(em);

            em.getTransaction().begin();

            categoriaDao.cadastrar(celulares);
            produtoDao.cadastrar(celular);

            em.getTransaction().commit();
            em.close();
        }


    }
