# Revision history for nqueens-java

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## [0.3.0] - 2018-06-10
### Added
* javadocs for all methods.
* Add `nqueens-cli` subproject.
* Add `nqueens-server` subproject.
* Add `Board` class.
### Changed
* Change from single gradle project to a collection of subprojects.
* Move `src` to `nqueens-core`.

## [0.2.0] - 2018-06-10
### Added
* `Utils` to hold some generic, static methods: `copy`, `arrayToArrayList`, `threePointsFormALine`.
* Add tests for `noThreeInLineConstraint`.
### Changed
* Rename `NaiveSolver` to `BruteForceSolver`.
* Add parameter to `BruteForceSolver` constructor `noThreeInLineConstraint`.

## [0.1.0] - 2018-06-09
### Added
* Implement a naive solution (disregarding performance or space) for the N-Queens problem in NaiveSolution.
* Add tests for NaiveSolver.
