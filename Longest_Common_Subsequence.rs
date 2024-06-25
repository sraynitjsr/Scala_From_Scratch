fn longest_common_subsequence(text1: String, text2: String) -> usize {
    let m = text1.len();
    let n = text2.len();

    let mut dp = vec![vec![0; n + 1]; m + 1];

    for i in 1..=m {
        for j in 1..=n {
            if text1.chars().nth(i - 1) == text2.chars().nth(j - 1) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = std::cmp::max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    dp[m][n]
}

fn main() {
    let text1 = String::from("abcde");
    let text2 = String::from("ace");

    let lcs_length = longest_common_subsequence(text1, text2);
    println!("{}", lcs_length);
}
