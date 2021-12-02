// Advent of Code Day 1

use std::fs;
// Part 1: Number of times the measurement increases
fn part1(mut count: i32, v: &Vec<i32>) -> i32 {
    for index in 1..v.len() {
	// println!("{} {} {}", v[index], v[index-1], (v[index] > v[index - 1]) as i32);
	count += (v[index] > v[index-1]) as i32;
    }

    return count;
}

// Part 2: Number of times that the window measurement increases
fn part2(mut count: i32, v: &Vec<i32>) -> i32 {
    // Most modern languages I've found have some sort of window feature built in to it.
    // Since I'm new to Rust, after some searching I came up with std::slice.Windows
    // let win: &Vec<i32> = &v.windows(3).collect();
    let v_array = v.as_slice();
    let mut first: i32 = v_array[0..2].iter().sum();

    for index in 3..v.len() {
	let second: i32 = v_array[index] + v_array[index - 1] + v_array[index - 2];
	count += (second > first) as i32;
	first = second;
    }
    return count;
 }

fn main() {
    let v: Vec<i32> = fs::read_to_string("input.txt")
	.expect("Wrong Filename")
	.lines()
	.map(|e| e.parse::<i32>().expect("Failed to parse to i32"))
	.collect();

    let day1_count: i32 = part1(0, &v);
    let day2_count: i32 = part2(0, &v);

    println!("{:?}", day1_count);
    println!("{:?}", day2_count);
}
