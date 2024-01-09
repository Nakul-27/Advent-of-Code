use std::collections::HashMap;


fn part1(lines: Vec<Option<&str>>, priorities: HashMap<char, u64>) -> u64 {
    let sums: Vec<u64> = lines
        .into_iter()
        .map(|line| {
            let mut seen: HashMap<char, bool> = HashMap::new();
            let mut duplicates: HashMap<u64, bool> = HashMap::new();
            let len = line.unwrap().len();
            let (comp1, comp2) = line.unwrap().split_at(len / 2);
            comp1.chars().for_each(|c| {
                seen.insert(c, true);
            });
            comp2.chars().for_each(|c| {
                if let Some(&true) = seen.get(&c) {
                    let value = priorities.get(&c).unwrap();
                    if !duplicates.contains_key(value) {
                        duplicates.insert(*value, true);
                    }
                }
            });
            match line {
                _ => duplicates.keys().sum()
            }
        }).collect();

    return sums.iter().sum()
}

fn part2(lines: Vec<Vec<Option<&str>>>, priorities: HashMap<char, u64>) -> u64 {
    let mut values = Vec::new();
    // TODO: Do this better.
    lines
        .into_iter()
        .for_each(|group| {
            let index = group[0]
                .unwrap()
                // .iter()
                .find(|c| group[1].unwrap().contains(c) && group[2].unwrap().contains(c))
                .unwrap();
            let first = group[0].unwrap();
            values.push(priorities.get(&first.chars().nth(index).unwrap()).unwrap())
        });
    return values.into_iter().sum();
}

fn parse1() -> Vec<Option<String>> {
    return include_str!("../assets/input3.txt")
        .lines()
        .map(|v| v.parse::<String>().ok())
        .collect::<Vec<_>>();
}

fn parse2(lines: Vec<Option<&str>>) -> Vec<Vec<Option<&str>>> {
    return lines
        .chunks(3)
        .map(|chunk| chunk.to_vec())
        .collect();
}

pub fn solve() {
    let priorities = HashMap::from([
        ('a', 1), ('b', 2), ('c', 3), ('d', 4), ('e', 5), ('f', 6), ('g', 7), ('h', 8), ('i', 9), ('j', 10), ('k', 11), ('l', 12), ('m', 13), ('n', 14), ('o', 15), ('p', 16), ('q', 17), ('r', 18), ('s', 19), ('t', 20), ('u', 21), ('v', 22), ('w', 23), ('x', 24), ('y', 25), ('z', 26),
        ('A', 27), ('B', 28), ('C', 29), ('D', 30), ('E', 31), ('F', 32), ('G', 33), ('H', 34), ('I', 35), ('J', 36), ('K', 37), ('L', 38), ('M', 39), ('N', 40), ('O', 41), ('P', 42), ('Q', 43), ('R', 44), ('S', 45), ('T', 46), ('U', 47), ('V', 48), ('W', 49), ('X', 50), ('Y', 51), ('Z', 52),
    ]);

    let binding1 = parse1();
    let input1: Vec<Option<&str>> = binding1
        .iter()
        .map(|s| s.as_deref())
        .collect::<Vec<_>>();
    let input2: Vec<Vec<Option<&str>>> = parse2(input1.clone());

    let part1 = part1(input1, priorities.clone());
    let part2 = part2(input2, priorities);


    // println!("{:?}", input2);
    println!("Day 3 Part 1: {:?}", part1);
    println!("Day 3 Part 2: {:?}", part2);
}
