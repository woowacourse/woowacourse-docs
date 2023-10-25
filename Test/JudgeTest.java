package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CompareTest {
    Compare compare;

    @BeforeEach
    void setUp(){
        compare = new Compare();
    }

    @Test
    @DisplayName("몇개의 숫자가 같은지 확인")
    void count(){
        assertThat(3).isEqualTo(compare.howMany(Arrays.asList(1,2,3), Arrays.asList(3,1,2)));
    }

    @Test
    @DisplayName("스트라이크 수 확인")
    void strike(){
        assertThat(1).isEqualTo(compare.countStrike(Arrays.asList(3,2,4),Arrays.asList(3,1,2)));
    }
}