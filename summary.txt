NETS 1500 HW5 Project Summary

Project Title: The Crowd Dynamic– How Does Opinion Spread in a Network? 

Project Description: 
Our project idea is to create a mathematical model that can accurately model the spread of opinion in crowds. 
Crowd wisdom is especially difficult to model due to the seeming randomness of individual behaviors, but can we 
gain a glimpse into how wisdom forms through study of opinion formation? It is possible to design a network of 
individuals and consider a game played on each edge to determine the decisions that are made by each individual. 
Games on certain clusters and sequences of decisions can impact group behavior as well. Our goal is to create a 
weighted model that considers all of these phenomena that influence group behavior and predict group proportions
on decisions (and see group decisions). Our plan is to test the model by creating a simulation and see if there 
exists a pattern of opinion spread. 

Work Breakdown:

Tasks: Model generation, Formalizing experiment, Determining formulae for model metrics, 
Creating simulations, Writing paper

Arnab: Model generation, Formalizing experiment, Model comparison, Writing paper, Data Analysis and formatting
Mahika: User Manual, Java comments, Creating simulations, Creating Mixed Strategy NE Calculator, Writing paper
Sruthi: Creating simulations, Creating CSV files, Determining formulae for model metrics, Writing
paper

Project Concepts: Graph/Graph Algorithms, Social Networks, Game Theory/Auctions/Matching Markets (specifically 
mixed strategy nash equilibrium)

We plan to generate a model driven by graph theory and degree measures and the influence of
decisions of others on personal decisions (game theory). Games will be played on edges of the network between 
each player. In an iterative process, the payoff functions of each game will be updated after each round of 
“play” by considering the degree of each node in its respective game.

Changes:

Initially, we were interested in measuring the “wisdom” of crowds. While we are still interested in pursuing 
this greater goal of assessing crowd wisdom, it was difficult to find data that could be manipulated in a way 
that would allow us to test hypotheses relating to crowd wisdom. Thus, we decided to analyze the spread of opinion,
which serves as somewhat of a proxy for crowd wisdom development (or at least a herd-mentality vs polarized 
opinions). We do not have any metric on whether the wisdom is accurate– a step that we want to take in the future 
to understand whether crowds are reliable or provide the best plans of action regarding important decisions.

We also initially wanted to use real-world data to validate our initial model. However, finding time-series spread 
of opinion data across a network was quite difficult. Ideally, we would like to use statistical techniques to infer 
previous opinion distributions from stable-state opinion data on networks, but we decided that that could be done 
in future work. 
