from typing import List


def sort_words(words: List[str]) -> List[str]:
    words.sort(key=getlen, reverse = True)
    return words


def sort_numbers(numbers: List[int]) -> List[int]:
    numbers.sort(key=getabs)
    return numbers

def getlen(word : str) -> int:
    return len(word)

def getabs(number : int) -> int:
    if number < 0:
        return number * -1
    else:
        return number


# do not modify below this line
print(sort_words(["cherry", "apple", "blueberry", "banana", "watermelon", "zucchini", "kiwi", "pear"]))

print(sort_numbers([1, -5, -3, 2, 4, 11, -19, 9, -2, 5, -6, 7, -4, 2, 6]))
