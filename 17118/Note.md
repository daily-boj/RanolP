# {@ problem-title @}

~~~problem-info-table
~~~

## 문제 분석

~~~pirim
"kudegi"
~~~

## 풀이

이 문제의 구데기성은 크게 두 부분으로 나눌 수 있습니다.

### p 구하기

예제를 통해 p를 역산해 구할 수 있다고 합니다. 하지만 저는 굳이 그러고 싶지 않습니다.
키파한테 물어보고 p가 몇인지 알아냈습니다.
직접 구하고 싶다면 [구데기컵 에디토리얼](https://github.com/jh05013/ghudegy_cup/blob/master/2nd-editorial.md#-%EA%B0%93-%EC%86%8C%EC%88%98)을 참고하세요.

### -2초

~~~pirim
"-2s"
~~~

네! -2초입니다! 놀랍다!
백준에서 Ruby 2.7이나 C# 6.0, F# 등의 언어는 시간 제한 배수가 없고 추가만 5초인 언어입니다.
이런 언어를 통해 풀어야만 -2초의 벽을 극복할 수 있습니다.

### 드디어 풀 수 있다

문제의 정의대로 LCG를 구할 수도 있겠지만 그래야 할까요?
저는 저걸 {@ math: O(1) @}로 구하고 싶었습니다.
{@ math: x_k = ax_{k-1} + b @}를 적절히 전개하면 다음과 같은 식을 얻을 수 있습니다.

{@ math: x_k = a^kx_0 + b \sum\limits_{i = 0}^{k - 1}{a^i} \bmod N @}

여기서, 우리는 k=N=p임을 알고, x_0=n이므로

{@ math: a^pn + b \sum\limits_{i = 0}^{p - 1}{a^i} \bmod p @}

이고, a, b는 문제에서 주어졌으므로,
{@ math: a^p @}, {@ math: b \sum\limits_{i = 0}^{p - 1}{a^i} \bmod p @}를 [미리](https://www.wolframalpha.com/) [구할 수](evaluate_sigma.py) 있습니다.

그렇게 구한 값을 하드코딩하면 {@ math: O(1) @}! 최고다!

~~~pirim
"ac"
~~~
