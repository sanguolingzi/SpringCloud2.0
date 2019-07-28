package demo.business.tcc;

import java.math.BigDecimal;

public interface TccTestService {
    public void add(Integer bankRollId, BigDecimal amount);

    public void minus(Integer bankRollId, BigDecimal amount);
}
