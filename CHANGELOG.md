# Revision history for nqueens-java

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## [0.1.0] - 2018-06-09
### Changed
* Add parameter to NaiveSolver constructor `noThreeInLineConstraint`.
* Alter `isSafe` to check for linearity between three queens if `noThreeInLineConstraint` is true.


## [0.1.0] - 2018-06-09
### Added
* Implement a naive solution (disregarding performance or space) for the N-Queens problem in NaiveSolution.
* Add tests for NaiveSolver.