use std::fs;

// Good Practice with Structs and Enums.
// Not used to them in Rust so it's good to get to use them.
#[derive(Debug)]
enum Dir {
    Forward,
    Down,
    Up,
}

#[derive(Debug)]
struct Movement {
    move_type: Dir,
    value: i32
}

fn get_movements(input: &mut String) -> Vec<Result<Movement,String>> {
    // Essentially how this works is that we go through the input
    // We first split it by new line
    // Next we split each line by spaces so that we now have a direction and a value
    // From here we need to check what direction it is.
    // After that we create a Movement Object with the proper direction and value
    // We also did Error Handling
    // Which means that this returns a Vector that is a Result<Movement, String>
    if input.ends_with('\n') {
	input.pop();
    }
    return input.split('\n').map(
	|line| {
	    // println!("{}", line);
	    // Help from:
	    // https://github.com/Mereep/advent_of_code_2021_rust/blob/master/src/day2/mod.rs
	    // Needed help with dealing with the Options and how to parse the string in an idiomatic manner.
	    // I'd spent a couple of hours trying out my own solutions and trying to figure out how to parse this in a "rust-like" manner,
	    // However I'd made little progress due to errors such as mismatching methods.
	    // I found this reference useful.
	    let line_split: Vec<&str> = line.split(' ').collect();
	    if line_split.len() != 2 {
		return Err(format!("Failure in Parsing line: {}", line))
	    }
	    let line_direction = *line_split.get(0).unwrap();
	    let line_value = *line_split.get(1).unwrap();

	    // Interesting syntax for dealing with Options
	    let result: Result<Movement, String> = if let Some(move_type) = match line_direction {
		"forward" => Some(Dir::Forward),
		"down" => Some(Dir::Down),
		"up" => Some(Dir::Up),
		_ => None
	    } {
		if let Ok(value) = line_value.parse::<i32>() {
		    Ok(Movement {
			move_type, value
		    })
		} else {
		    Err(format!("Value Error"))
		}
	    } else {
		Err(format!("Direction Error"))
	    };
	    return result;
	}
    ).collect();

    // This wasn't working when I just tried to do it with input so I'm breaking this up
}

fn part1(input_vec: &Vec<Result<Movement, String>>, mut pos: i32, mut depth: i32) -> i32 {
    for instruction in input_vec {
	match instruction {
	    Ok(movement) => {
		// Interesting syntax to check types with pattern matching
		match movement {
		    Movement {move_type: Dir::Forward, value} => {
			pos += *value;
		    }
		    Movement {move_type: Dir::Down, value} => {
			depth += *value;
		    }
		    Movement {move_type: Dir::Up, value} => {
			depth -= *value;
		    }
		}
	    }
	    Err(msg) => panic!("{}", msg)
	}
    }
    return pos * depth;
}

// Factor some of this into another function
// Look into "impl"
fn part2(input_vec: &Vec<Result<Movement, String>>, mut pos: i32, mut depth: i32, mut aim: i32) -> i32 {
    for instruction in input_vec {
	match instruction {
	    Ok(movement) => {
		match movement {
		    Movement {move_type: Dir::Forward, value} => {
			pos += *value;
			depth += aim * *value;
		    }
		    Movement {move_type: Dir::Down, value} => {
			aim += *value;
		    }
		    Movement {move_type: Dir::Up, value} => {
			aim -= *value;
		    }
		}
	    }
	    Err(msg) => panic!("{}", msg)
	}
    }
    return pos * depth;
}

fn main() {
    let mut input: String = fs::read_to_string("input.txt")
	.expect("Wrong Filename");

    // This wasn't the most efficient way to handle this for sure
    let input_vec: Vec<Result<Movement,String>> = get_movements(&mut input);
    println!("Part 1: {}", part1(&input_vec, 0, 0));
    println!("Part 2: {}", part2(&input_vec, 0, 0, 0));

    // println!("Part 1: {}", part1(&input));
}

