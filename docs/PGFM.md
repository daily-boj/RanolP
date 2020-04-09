# PGFM

PGFM은 마크다운 전처리기 및 그 규격으로, Preprocessor for Github Flavored Markdown의 약어입니다.

## 확장 문법

PGFM의 모든 문법은 물결표 세 개로 시작해, 명령 이름을 붙이고, 필요하다면 JSON5 규격에 맞는 추가 설정을 넘긴 후, 물결표 세 개로 끝마칩니다.

예시:

```markdown
~~~problem-table
~~~
```

## 지원 블록 목록

### problem-table

#### 설정 규격

```json
{}
```

#### 설명

문제 테이블을 생성합니다.

### language-usage

#### 설정 규격

```json
{}
```

#### 설명

문제 풀이에 사용한 언어 비율을 보여줍니다.
