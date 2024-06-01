package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class generateRandomNumTest {
    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void randomTest(){
        GenerateRandomNum generateRandomNum = new GenerateRandomNum();
        List<Integer> test = generateRandomNum.create();
        assertThat(3).isEqualTo(test.size());
    }
}