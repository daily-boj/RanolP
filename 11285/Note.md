# {@ problem-title @}

~~~problem-info-table
~~~

## 문제 분석

입력된 초성, 중성, 종성으로 음절을 만듭니다. 한글 처리에 주의해야 합니다.

## 풀이

한글은 유니코드 상에서 규칙적으로 배열되어 있습니다.
종성이 총 28개(빈 종성 포함)이므로 28개마다 중성이 바뀌며,
중성은 총 21개이므로 21 × 28 = 588개마다 초성이 바뀝니다.
가장 처음 소리인 '가'(`U+AC00`)을 기준으로,
(초성 번호) × 588 + (중성 번호) × 28 + (종성 번호)를 더하면 음절이 완성됩니다.
