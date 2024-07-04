# Custom HashMap Implementation

This repository contains a custom implementation of a HashMap in Java. The implemented `CustomHashMap` class includes methods such as `put`, `size`, `get`, `remove`, and `containsKey`. Linear probing is used to handle hash collisions.

## Features

- **put(K key, V value)**: Inserts a key-value pair into the map. If the key already exists, the value is updated.
- **size()**: Returns the number of key-value pairs in the map.
- **get(Object key)**: Retrieves the value associated with the specified key. Returns `null` if the key does not exist.
- **remove(Object key)**: Removes the key-value pair associated with the specified key. Returns the value associated with the key or `null` if the key does not exist.
- **containsKey(Object key)**: Checks if the map contains the specified key. Returns `true` if the key is present, otherwise `false`.

## Getting Started

To understand the basics and get started with the implementation, I referred to an article by [Marcio Endo](https://x.com/marcioendo). This article provides a good introduction to the concepts and techniques used in implementing a custom HashMap.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- An IDE or text editor of your choice


## Implementation Details
## Linear Probing
Linear probing is used to handle hash collisions. When a collision occurs, the algorithm checks the next available slot in the array until an empty slot is found.

## Hash Function
A simple hash function is used to compute the index for a given key. The hash function ensures that the index is within the bounds of the underlying array.

## Contributing
Contributions are welcome! Please open an issue or submit a pull request for any improvements or new features.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Acknowledgements
Thanks to Marcio Endo for the informative article that served as a reference for this project.

