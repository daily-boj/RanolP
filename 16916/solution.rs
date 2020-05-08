//! This is free and unencumbered software released into the public domain.
//!
//! Anyone is free to copy, modify, publish, use, compile, sell, or
//! distribute this software, either in source code form or as a compiled
//! binary, for any purpose, commercial or non-commercial, and by any
//! means.
//!
//! In jurisdictions that recognize copyright laws, the author or authors
//! of this software dedicate any and all copyright interest in the
//! software to the public domain. We make this dedication for the benefit
//! of the public at large and to the detriment of our heirs and
//! successors. We intend this dedication to be an overt act of
//! relinquishment in perpetuity of all present and future rights to this
//! software under copyright law.
//!
//! THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
//! EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
//! MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
//! IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
//! OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
//! ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
//! OTHER DEALINGS IN THE SOFTWARE.
//!
//! For more information, please refer to <http://unlicense.org/>
//!
//! Source Code URL:
//! https://gist.github.com/RanolP/3d17fdb99fbf30d6c67bfac1cc366133

use std::io::{stdin, BufRead, ErrorKind, StdinLock};

fn get_word(stdin: &mut StdinLock) -> String {
    let mut buffer = Vec::new();
    loop {
        let available = match stdin.fill_buf() {
            Ok(n) => n.to_vec(),
            Err(ref e) if e.kind() == ErrorKind::Interrupted => continue,
            _ => panic!(),
        };
        if available.len() == 0 && buffer.len() != 0 {
            break String::from_utf8(buffer).unwrap().trim().to_string();
        }
        let count = available
            .iter()
            .enumerate()
            .find(|(_, chr)| match chr {
                b' ' | b'\n' | b'\r' => true,
                _ => false,
            })
            .map(|(idx, _)| idx);
        if let Some(count) = count {
            buffer.extend_from_slice(&available[..count]);
            stdin.consume(count + 1);
            if !buffer.is_empty() {
                break String::from_utf8(buffer).unwrap().trim().to_string();
            }
        } else {
            buffer.extend_from_slice(&available);
            stdin.consume(available.len());
        }
    }
}

macro_rules! input {
    (@inner $stdin:ident; line) => {{
        let mut buf = String::new();
        $stdin.read_line(&mut buf).unwrap();
        buf.trim_end_matches('\n').to_string()
    }};
    (@inner $stdin:ident; word) => {
        get_word(&mut $stdin)
    };
    (@inner $stdin:ident; ($($t:ty),*)) => {
        ($(input!(@inner $stdin; $t),)*)
    };
    (@inner $stdin:ident; [$size:literal; ($($t:ty),*)]) => {{
        let mut result = [<($($t),*) as Default>::default(); $size];
        for i in 0..$size {
            result[i] = ($(input!(@inner $stdin; $t)),*);
        }
        result
    }};
    (@inner $stdin:ident; [$size:literal; $t:ty]) => {
        input!(@inner $stdin; [$size; ($t)])
    };
    (@inner $stdin:ident; Vec[$size:expr; $($t:tt)+]) => {{
        let mut result = Vec::with_capacity($size);
        for _ in 0..$size {
            result.push(input!(@inner $stdin; $($t)*));
        }
        result
    }};
    (@inner $stdin:ident; HashSet[$size:expr; $($t:tt),+]) => {{
        let mut result = std::collections::HashSet::with_capacity($size);
        for _ in 0..$size {
            result.insert(input!(@inner $stdin; $($t)*));
        }
        result
    }};
    (@inner $stdin:ident; $t:ty) => {
        input!(@inner $stdin; word).parse::<$t>().unwrap()
    };
    ($size:literal; ($($t:ty),*)) => {
        input!([$size; ($($t),*)])
    };
    ($size:literal; $t:ty) => {
        input!([$size; $t])
    };
    ($($($t:tt)+),*) => {{
        let stdin = stdin();
        let mut stdin = stdin.lock();
        ($(input!(@inner stdin; $($t)+)),*)
    }};
}

fn main() {
    if let Some(value) = input!(line).find(&input!(line)) {
        println!("1");
    } else {
        println!("0");
    }
}
