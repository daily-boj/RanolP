# {@ problem-title @}

~~~problem-info-table
~~~

## 문제 분석

이 문제는 n~m 범위의 자릿수합(Digit Sum)을 빠르게 구하는 방법을 요구한다.

## 풀이

{@ math: D(n) @}을 {@ var: n @}의 자릿수합이라고 하고,
{@ math: S(n) @}을 0부터 {@ var: n @}까지의 자릿수합이라고 하자.

### 보조정리: S(m) - S(n - 1)은 n ~ m 범위의 자릿수합이다

임의의 자연수 {@ var: m @}에 대해
{@ math: S(m + k) = S(m - 1) + D(m) + D(m + 1) + \cdots + D(m + k - 1) + D(m + k) @}이므로
{@ math: S(m) - S(n - 1) @}은 n과 m을 포함하는 범위의 자릿수합이라고 할 수 있다.

### S(n)

#### 자릿수로 나눠서 생각하기

{@ math: n = a_0 + a_1 10 + a_2 10^2 + \cdots @}라고 하자.

한 자리수에선 자릿수합이나 합이나 다름이 없으므로,
{@ math: S(a_0) = \frac{a_0 (a_0 - 1)}{2} @}이다.

십의 자리 뒤에 붙을 수 있는 숫자들을 생각해보자.
일의 자리 수 0~9가 붙을 거니까 십의 자리 수는 10번 나오고,
10의 자리로 오기 전의 자릿수합을 생각하면 되니까 S(10 - 1)을 넣으면 될 것이다.
그렇다면 {@ math: (0 \times 10 + S(10 - 1)) + (1 \times 10 + S(10 - 1)) + \cdots + a_1 @}이다.

백의 자리는 어떨까?
0~99가 붙을 거니까 백의 자리는 100번 나오고,
백의 자리로 오기 전까지의 자릿수합을 생각하면 되니까 S(100 - 1)을 넣으면 될 것이다.
그렇다면 {@ math: (0 \times 10 + S(100 - 1)) + (1 \times 10 + S(100 - 1)) + \cdots + (a_2) @}이다.

그렇다면 그 다음 자리도, 다음 다음 자리도, 그 뒤로도 쭉 비슷하게 생각할 수 있지 않을까? 10, 100, 1000, 10000, ...으로 계속될 것이다.

따라서, 이 식의 일반화된 꼴은 다음과 같다:

{@ math: \frac{a_n(a_n - 1)}{2} \times 10^n + a_n + a_n \times S(10^n - 1) @}

##### S(9), S(99), S(999), …

위의 성질로 인해 우리는 {@ math: 10^k - 1 @}꼴을 자주 구해야 한다는 걸 알 수 있다.
더 빠르게 구할 방법은 없을까? 한 번 직접 전개해보자.

- {@ math: S(0) = 0 @}
- {@ math: S(9) = (0 \times 1 + S(0)) + (1 \times 1 + S(0)) + \cdots + (8 \times 1 + S(0)) + (9 \times 1 + S(0)) + S(0) @}
- {@ math: S(99) = (0 \times 10 + S(9)) + (1 \times 10 + S(9)) + \cdots + (8 \times 10 + S(9)) + (9 \times 10 + S(9)) + S(9) @}
- {@ math: S(999) = (0 \times 10 + S(99)) + (1 \times 10 + S(99)) + \cdots + (8 \times 10 + S(99)) + (9 \times 10 + S(99)) + S(99) @}
- ...

반복되는 꼴을 찾을 수 있다. 괄호를 풀고 좀 정리를 하면 다음과 같이 정리가 된다.

{@ math: S(10^k - 1) = 45 \times 10^{k - 1} + 10 \times S(10^{k - 1} - 1) @} (단, 0 < k)

조금 복잡해보이지만 직접 대입해서 풀어보면 45 × 1, 45 × 20, 45 × 300, ... 임을 알 수 있다. 따라서 식을 다음과 같이 변형할 수 있다.

{@ math: S(10^k - 1) = 45 \times k \times 10^{k - 1} @}

#### 나누어둔 걸 합치기

슬프게도 {@ math: S(a_0) + S(a_1 10) + S(a_2 10^2) + \cdots = S(a_0 + a_1 10 + a_2 10^2 + \cdots) @}가 아니다.
{@ math: a_n @}은 {@ math: a_{n - 1} + a_{n - 2} + a_{n - 3} + \cdots @}번 더 등장하기 때문이다. 이걸 고려해서 더해줘야 제대로 된 결과가 나온다.

## 사실

지금에서야 저렇게 멋지게 정리할 수 있었지만 나는 이 문제를 다음과 같은 방법으로 풀었다.

~~~pirim
'proof-by-ac'
~~~
