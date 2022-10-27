import java.math.BigDecimal;

public class CadastroProdutos {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Xiaomi Redmi 9");
        celular.setDescricao("Muito bom");
        celular.setPreco(new BigDecimal("900"));
    }
}
