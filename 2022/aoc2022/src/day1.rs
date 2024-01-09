use itertools::Itertools;
use std::cmp::Reverse;

fn part1(lines: Vec<Option<u64>>) -> Option<u64> {
    let max: Option<u64> = lines
        .split(|line| line.is_none())
        .map(|group| group.iter().map(|v| v.unwrap()).sum::<u64>())
        .max();
    max
}

fn part2() -> u64 {
    return include_str!("../assets/input1.txt")
        .lines()
        .map(|v| v.parse::<u64>().ok())
        .batching(|it| it.map_while(|x| x).sum1::<u64>())
        .map(Reverse)
        .k_smallest(3)
        .map(|x| x.0)
        .sum::<u64>();
}

pub fn solve() {
    let lines = include_str!("../assets/input1.txt")
        .lines()
        .map(|v| v.parse::<u64>().ok())
        .collect::<Vec<_>>();

    let p1 = part1(lines).unwrap();
    let p2 = part2();

    println!("Day 1 Part1: {p1:?}");
    println!("Day 1 Part2: {p2:?}");
}
