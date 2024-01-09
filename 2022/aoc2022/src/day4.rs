use itertools::Itertools;

fn part1(ranges: Vec<((u64, u64), (u64, u64))>) -> u64 {
    ranges
        .into_iter()
        .filter(|((s1, e1), (s2, e2))| (s1 >= s2 && e1 <= e2)  || (s1 <= s2 && e1 >= e2))
        .count() as u64
}

fn part2(ranges: Vec<((u64, u64), (u64, u64))>) -> u64 {
    ranges
        .into_iter()
        .filter(|((s1, e1), (s2, e2))| (s1 <= e2 && s2 <= e1))
        .count() as u64
}

fn parse() -> Vec<((u64, u64), (u64, u64))> {
    return include_str!("../assets/input4.txt")
        .lines()
        .map(|l| {
            l.split(',')
                .map(|range| {
                    range
                        .split('-')
                        .map(|n| n.parse().expect("Start and End not formatted Properly"))
                        .collect_tuple::<(u64, u64)>()
                        .expect("Each range needs a start and an end")
                })
                .collect_tuple::<(_,_)>()
                .unwrap()
        })
        .collect()
}

pub fn solve() {

    let input = parse();

    println!("Day 4 Part 1: {:?}", part1(input.clone()));
    println!("Day 4 Part 2: {:?}", part2(input.clone()))
}
