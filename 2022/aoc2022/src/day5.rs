fn part1() {
    unimplemented!()
}

fn part2() {
    unimplemented!()
}

fn parse() -> Vec<&'static str> {
    return include_str!("../assets/input5.txt")
        .lines()
        .map(|l| l)
        .collect::<Vec<_>>();
}

pub fn solve() {

    let binding = parse();
    let input = binding;

    println!("Day 5 Part 1: {:?}", part1());
    println!("Day 5 Part 2: {:?}", part2())
}
