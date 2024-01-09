use std::str::FromStr;

#[derive(Debug, Clone, Copy)]
enum Move {
    Rock,
    Paper,
    Scissors,
}

#[derive(Debug, Clone, Copy)]
struct Round {
    theirs: Move,
    ours: Move,
}

#[derive(Debug, Clone, Copy)]
enum Outcome {
    Lose,
    Draw,
    Win,
}

impl Move {
    const ALL_MOVES: [Move; 3] = [Move::Rock, Move::Paper, Move::Scissors];

    fn winning_move(self) -> Self {
        Self::ALL_MOVES
            .iter()
            .copied()
            .find(|m| m.beats(self))
            .expect("at least one move beats us")
    }

    fn losing_move(self) -> Self {
        Self::ALL_MOVES
            .iter()
            .copied()
            .find(|&m| self.beats(m))
            .expect("We beat at least one move")
    }

    fn drawing_move(self) -> Self {
        self
    }

    // Part 1
    fn inheritence_points(self) -> usize {
        match self {
            Move::Rock => 1,
            Move::Paper => 2,
            Move::Scissors => 3
        }
    }

    fn beats(self, other: Move) -> bool {
        matches!(
            (self, other),
            (Self::Rock, Self::Scissors)
                | (Self::Paper, Self::Rock)
                | (Self::Scissors, Self::Paper)
        )
    }

    fn outcome(self, theirs: Move) -> Outcome {
        if self.beats(theirs) {
            Outcome::Win
        } else if theirs.beats(self) {
            Outcome::Lose
        } else {
            Outcome::Draw
        }
    }
}

impl Round {
    fn outcome(self) -> Outcome {
        self.ours.outcome(self.theirs)
    }

    fn our_score(self) -> usize {
        self.ours.inheritence_points() + self.outcome().inheritence_points()
    }
}

impl Outcome {
    fn inheritence_points(self) -> usize {
        match self {
            Outcome::Win => 6,
            Outcome::Draw => 3,
            Outcome::Lose => 0,
        }
    }

    fn matching_move(self, theirs: Move) -> Move {
        match self {
            Outcome::Win => theirs.winning_move(),
            Outcome::Draw => theirs.drawing_move(),
            Outcome::Lose => theirs.losing_move()
        }
    }
}


impl TryFrom<char> for Move {
    type Error = color_eyre::Report;

    fn try_from(c: char) -> Result<Self, Self::Error> {
        match c {
            'A' => Ok(Move::Rock),
            'B' => Ok(Move::Paper),
            'C' => Ok(Move::Scissors),
            _ => Err(color_eyre::eyre::eyre!("{c:?} is not a valid move.")),
        }
    }

    // Part 1
    // fn try_from(c: char) -> Result<Self, Self::Error> {
    //     match c {
    //         'X' | 'A' => Ok(Move::Rock),
    //         'Y' | 'B' => Ok(Move::Paper),
    //         'Z' | 'C' => Ok(Move::Scissors),
    //         _ => Err(color_eyre::eyre::eyre!("{c:?} is not a valid move.")),
    //     }
    // }
}

impl TryFrom<char> for Outcome {
    type Error = color_eyre::Report;

    fn try_from(c: char) -> Result<Self, Self::Error> {
        match c {
            'X' => Ok(Outcome::Lose),
            'Y' => Ok(Outcome::Draw),
            'Z' => Ok(Outcome::Win),
            _ => Err(color_eyre::eyre::eyre!("{c:?} is not a valid outcome.")),
        }
    }
}

impl FromStr for Round {
    type Err = color_eyre::Report;

    fn from_str(s: &str) -> Result<Self, Self::Err> {
        let mut chars = s.chars();
        let (Some(theirs), Some(' '), Some(outcome), None) = (chars.next(), chars.next(), chars.next(), chars.next()) else {
            return Err(color_eyre::eyre::eyre!("expected <theirs>SP<outcome>EOF, got {s:?}"));
        };

        // Part 1
        // let (Some(theirs), Some(' '), Some(ours), None) = (chars.next(), chars.next(), chars.next(), chars.next()) else {
        //     return Err(color_eyre::eyre::eyre!("Expectes <theirs> <ours> , got {s:?}"));
        // };
        
        let theirs = Move::try_from(theirs)?;
        let outcome = Outcome::try_from(outcome)?;
        let ours = outcome.matching_move(theirs);

        Ok(Self{ theirs, ours })

        // Ok(Self {
        //     theirs: theirs.try_into()?,
        //     ours: ours.try_into()?,
        // })
    }
}

fn part1(rounds: Vec<Round>) -> usize {
    let total_score: usize = rounds.iter().map(|r| r.our_score()).sum();

    return total_score;
}

fn parse() -> Vec<Round> {
    return include_str!("../assets/input2.txt")
        .lines()
        .map(|v| v.parse::<Round>().unwrap())
        .collect::<Vec<_>>();
}

pub fn solve() {
    let rounds: Vec<Round> = parse();
    // let p1: usize = part1(rounds);
    let p2: usize = part1(rounds);
    // dbg!(p1);

    println!("Day 2 Part 2: {p2:?}");
}
