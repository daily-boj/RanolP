use std::collections::VecDeque;
use std::io::{stdin, BufRead};

#[derive(Debug)]
enum State {
    Nope,
    B,
    BU,
}

impl AsRef<str> for State {
    fn as_ref(&self) -> &str {
        match self {
            State::Nope => "",
            State::B => "B",
            State::BU => "BU",
        }
    }
}

fn main() {
    let stdin = stdin();
    let mut stdin = stdin.lock();
    stdin.lines().for_each(|line| {
        let mut stack = VecDeque::new();
        let mut result = String::new();
        for c in line.unwrap().bytes() {
            match c {
                b'B' => {
                    stack.push_back(State::B);
                }
                b'U' => {
                    if let Some(State::B) = stack.back() {
                        stack.pop_back();
                        stack.push_back(State::BU);
                    } else {
                        while let Some(v) = stack.pop_front() {
                            result.push_str(v.as_ref());
                        }
                        result.push(c.into());
                    }
                }
                b'G' => {
                    if let Some(State::BU) = stack.back() {
                        stack.pop_back();
                    } else {
                        while let Some(v) = stack.pop_front() {
                            result.push_str(v.as_ref());
                        }
                        result.push(c.into());
                    }
                }
                _ => {
                    while let Some(v) = stack.pop_front() {
                        result.push_str(v.as_ref());
                    }
                    result.push(c.into());
                }
            }
        }
        while let Some(v) = stack.pop_front() {
            result.push_str(v.as_ref());
        }
        println!("{}", result);
    })
}
